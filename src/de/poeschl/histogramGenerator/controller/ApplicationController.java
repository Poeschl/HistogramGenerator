/*******************************************************************************
 * HistogramGenerator
 *     Copyright (C) 2014 Markus Pöschl
 *
 *     This program is free software; you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation; either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License along
 *     with this program; if not, write to the Free Software Foundation, Inc.,
 *     51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 ******************************************************************************/

package de.poeschl.histogramGenerator.controller;

import de.poeschl.histogramGenerator.HistogramGeneratorApplication;
import de.poeschl.histogramGenerator.generators.RGBHistogramGenerator;
import de.poeschl.histogramGenerator.models.ImageData;
import de.poeschl.histogramGenerator.utils.FileHelper;
import de.poeschl.histogramGenerator.utils.ImageParser;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Markus Pöschl on 29.03.2014.
 */
public class ApplicationController implements Initializable, EventHandler<Event> {

    @FXML
    private TextField fileInputTextField;

    @FXML
    private Button selectFileInputButton;

    @FXML
    private Button generateButton;

    @FXML
    private ImageView fileInputPreviewImageView;

    @FXML
    private ImageView histogramImageView;

    @FXML
    private Button csvExportButton;

    @FXML
    private Button pngExportButton;

    private BufferedImage sourceImage;
    /**
     * A flag to recognise the modification of the image path.
     */
    private boolean inputPathChanged = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fileInputTextField.addEventHandler(KeyEvent.KEY_PRESSED, this);
        selectFileInputButton.addEventHandler(ActionEvent.ACTION, this);
        generateButton.addEventHandler(ActionEvent.ACTION, this);

        csvExportButton.addEventHandler(ActionEvent.ACTION, this);
        pngExportButton.addEventHandler(ActionEvent.ACTION, this);

        setUpSampleData();
    }

    private void setSourceImage(BufferedImage image) {
        this.sourceImage = image;
        updateSourceImagePreview();
    }

    private void setUpSampleData() {
        InputStream imageStream = ApplicationController.class.getResourceAsStream("/de/poeschl/histogramGenerator/resources/images/sample.png");

        try {
            setSourceImage(ImageIO.read(imageStream));
        } catch (IOException e) {
            //TODO: Show error dialog
            e.printStackTrace();
        }
    }

    @Override
    public void handle(Event event) {
        if (event.getEventType().equals(ActionEvent.ACTION)) {
            onActionEvents(event);

        } else if (event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
            onKeyPressedEvents(event);

        }
    }

    private void onActionEvents(Event event) {
        Object actionSource = event.getSource();

        if (actionSource.equals(selectFileInputButton)) {
            //Find the input file
            selectInputFile();

        } else if (actionSource.equals(generateButton)) {
            if (inputPathChanged) {
                loadFile(new File(fileInputTextField.getText()));
            }

            ImageData imageData = ImageParser.getInstance().parseImage(sourceImage);
            RGBHistogramGenerator generator = new RGBHistogramGenerator(imageData);
            generator.generateImageData();

            System.out.println(generator.getCombinedHistogramOutput().toString());


        } else if (actionSource.equals(csvExportButton)) {

        } else if (actionSource.equals(pngExportButton)) {

        }
    }

    private void onKeyPressedEvents(Event event) {
        if (event.getSource().equals(fileInputTextField)) {
            inputPathChanged = true;
        }
    }

    private void updateSourceImagePreview() {
        WritableImage previewImage = SwingFXUtils.toFXImage(sourceImage, null);
        fileInputPreviewImageView.setImage(previewImage);
    }

    private void selectInputFile() {
        File inputFile = FileHelper.getInstance().selectImageFromFileSystem(HistogramGeneratorApplication.getApplicationStage());
        if (inputFile == null) {
            return;
        }
        loadFile(inputFile);
    }

    private void loadFile(File file) {
        if (!file.exists()) {
            //TODO Add dialog, when file don't exists.
            return;
        }

        try {
            setSourceImage(ImageIO.read(file));

            this.fileInputTextField.setText(file.getPath());
            inputPathChanged = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
