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

package de.poeschl.histogramGenerator.generators;

import de.poeschl.histogramGenerator.models.HistogramData;
import de.poeschl.histogramGenerator.models.ImageData;

import java.awt.*;

/**
 * Created by Markus Pöschl on 29.03.2014.
 */
public class RGBHistogramGenerator {

    private ImageData imageSource;

    private HistogramData histogram;

    /**
     * Creates a generator for one color channel or combined. The channel needs to be defined by the type parameter.
     *
     * @param imageSource The source image as color values.
     */
    public RGBHistogramGenerator(ImageData imageSource) {
        this.imageSource = imageSource;
    }

    /**
     * Calculates the histogram data based on one color channel or the grayscaled version of the image.
     */
    public void generateImageData() {
        histogram = new HistogramData();


        for (int y = 0; y < imageSource.getHeight(); y++) {
            for (int x = 0; x < imageSource.getWidth(); x++) {
                Color currentPixelColor = imageSource.getPixel(x, y).getColor();

                int combinedBrightness = (int) (0.299 * currentPixelColor.getRed() + 0.587 * currentPixelColor.getGreen() + 0.114 * currentPixelColor.getBlue());
                int redBrightness = currentPixelColor.getRed();
                int greenBrightness = currentPixelColor.getGreen();
                int blueBrightness = currentPixelColor.getBlue();

                histogram.getCombinedChannel().incrementBrightnessValue(combinedBrightness);
                histogram.getRedChannel().incrementBrightnessValue(redBrightness);
                histogram.getGreenChannel().incrementBrightnessValue(greenBrightness);
                histogram.getBlueChannel().incrementBrightnessValue(blueBrightness);
            }
        }
    }

    /**
     * Returns the output for the histogram. Or null if no output generated.
     *
     * @return The histogram data.
     */
    public HistogramData getHistogramOutput() {
        return histogram;
    }

}
