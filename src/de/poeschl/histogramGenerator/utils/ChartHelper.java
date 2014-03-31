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

package de.poeschl.histogramGenerator.utils;

import de.poeschl.histogramGenerator.models.ChannelData;
import de.poeschl.histogramGenerator.models.HistogramData;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;

/**
 * Created by Markus Pöschl on 31.03.2014.
 */
public class ChartHelper {
    private static ChartHelper ourInstance = new ChartHelper();

    public static ChartHelper getInstance() {
        return ourInstance;
    }

    private ChartHelper() {
    }

    public void updateHistogramChart(AreaChart<Number, Number> chart, HistogramData data) {
        chart.getData().clear();

        XYChart.Series<Number, Number> combinedSeries = new XYChart.Series<Number, Number>();
        combinedSeries.setName("RGB combined");
        XYChart.Series<Number, Number> redSeries = new XYChart.Series<Number, Number>();
        redSeries.setName("Red");
        XYChart.Series<Number, Number> greenSeries = new XYChart.Series<Number, Number>();
        greenSeries.setName("Green");
        XYChart.Series<Number, Number> blueSeries = new XYChart.Series<Number, Number>();
        blueSeries.setName("Blue");

        for (int i = 0; i < ChannelData.MAX_CHANNEL_VALUE; i++) {
            XYChart.Data<Number, Number> combinedSet = new XYChart.Data<Number, Number>(i, data.getCombinedChannel().getValueForBrightness(i));
            combinedSeries.getData().add(combinedSet);
            XYChart.Data<Number, Number> redSet = new XYChart.Data<Number, Number>(i, data.getRedChannel().getValueForBrightness(i));
            redSeries.getData().add(redSet);
            XYChart.Data<Number, Number> greenSet = new XYChart.Data<Number, Number>(i, data.getGreenChannel().getValueForBrightness(i));
            greenSeries.getData().add(greenSet);
            XYChart.Data<Number, Number> blueSet = new XYChart.Data<Number, Number>(i, data.getBlueChannel().getValueForBrightness(i));
            blueSeries.getData().add(blueSet);
        }

        chart.getData().addAll(combinedSeries, redSeries, greenSeries, blueSeries);
    }

    public void setUpChart(AreaChart chart) {
        // Apply style
        chart.getStylesheets().add(ChartHelper.class.getResource("/de/poeschl/histogramGenerator/resources/layouts/chart.css").toExternalForm());
    }
}
