/*******************************************************************************
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Markus Pöschl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package de.poeschl.histogramGenerator.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Markus Pöschl on 29.03.2014.
 */
public class ApplicationController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fileInputPreviewImageView.setSmooth(true);

        setUpSampleData();
    }

    private void setSourceImage(BufferedImage image) {
        this.sourceImage = image;
        updateSourceImagePreview();
    }

    private void updateSourceImagePreview() {
        WritableImage previewImage = new WritableImage(sourceImage.getWidth(), sourceImage.getHeight());
        SwingFXUtils.toFXImage(sourceImage, previewImage);

        fileInputPreviewImageView.setImage(previewImage);
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
}
