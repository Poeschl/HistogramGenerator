/*******************************************************************************
 * HistogramGenerator
 *     Copyright (C) 2015 Markus Pöschl
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

package de.poeschl.histogramGenerator.exporter;

import de.poeschl.histogramGenerator.models.HistogramData;
import de.poeschl.histogramGenerator.utils.ChartHelper;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Markus Pöschl on 07.04.2014.
 */
public class PngExporter implements ExporterInterface {

    private static final int PNG_WIDTH = 1200;
    private static final int PNG_HEIGHT = 600;

    private AreaChart<Number, Number> bigHistogram;
    private Scene offScreen;

    public PngExporter() {
        createOffScreen();
        setUpOffScreenChart();
    }

    @Override
    public void exportToFileWriter(FileOutputStream outputStream, HistogramData data) {

        ChartHelper helper = ChartHelper.getInstance();
        helper.setUpChart(bigHistogram);
        helper.updateHistogramChart(bigHistogram, data);

        WritableImage snapshot = offScreen.snapshot(null);
        BufferedImage image = SwingFXUtils.fromFXImage(snapshot, null);

        try {
            ImageIO.write(image, "png", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                System.err.println("We tried to close the stream, but we have no power here!");
            }
        }
    }

    private void createOffScreen() {
        Group offScreenRoot = new Group();
        offScreen = new Scene(offScreenRoot, PNG_WIDTH, PNG_HEIGHT);
    }

    private void setUpOffScreenChart() {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setUpperBound(255);
        xAxis.setLowerBound(0);
        xAxis.setTickUnit(10);
        xAxis.setMinorTickCount(2);
        xAxis.setSide(Side.BOTTOM);
        xAxis.setAutoRanging(false);

        NumberAxis yAxis = new NumberAxis();
        yAxis.setAutoRanging(true);
        yAxis.setMinorTickVisible(false);
        yAxis.setTickUnit(25);
        yAxis.setSide(Side.LEFT);

        bigHistogram = new AreaChart<Number, Number>(xAxis, yAxis);
        bigHistogram.setMinSize(PNG_WIDTH, PNG_HEIGHT);
        bigHistogram.setPrefSize(PNG_WIDTH, PNG_HEIGHT);
        bigHistogram.setAnimated(false);

        ((Group) offScreen.getRoot()).getChildren().add(bigHistogram);
    }
}
