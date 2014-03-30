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

package de.poeschl.histogramGenerator.generators;

import de.poeschl.histogramGenerator.models.HistogramData;
import de.poeschl.histogramGenerator.models.HistogramType;
import de.poeschl.histogramGenerator.models.ImageData;

import java.awt.*;

/**
 * Created by Markus Pöschl on 29.03.2014.
 */
public class RGBHistogramGenerator {

    private ImageData imageSource;

    private HistogramData combinedHistogram;
    private HistogramData redHistogram;
    private HistogramData greenHistogram;
    private HistogramData blueHistogram;

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
        combinedHistogram = new HistogramData(HistogramType.RGB);
        redHistogram = new HistogramData(HistogramType.RED);
        greenHistogram = new HistogramData(HistogramType.GREEN);
        blueHistogram = new HistogramData(HistogramType.BLUE);

        for (int y = 0; y < imageSource.getHeight(); y++) {
            for (int x = 0; x < imageSource.getWidth(); x++) {
                Color currentPixelColor = imageSource.getPixel(x, y).getColor();

                int combinedBrightness = (int) (0.299 * currentPixelColor.getRed() + 0.587 * currentPixelColor.getGreen() + 0.114 * currentPixelColor.getBlue());
                int redBrightness = currentPixelColor.getRed();
                int greenBrightness = currentPixelColor.getGreen();
                int blueBrightness = currentPixelColor.getBlue();

                combinedHistogram.incrementBrightnessValue(combinedBrightness);
                redHistogram.incrementBrightnessValue(redBrightness);
                greenHistogram.incrementBrightnessValue(greenBrightness);
                blueHistogram.incrementBrightnessValue(blueBrightness);
            }
        }
    }

    /**
     * Returns the output for the combined histogram. Or null if no output generated.
     *
     * @return The histogram data.
     */
    public HistogramData getCombinedHistogramOutput() {
        return combinedHistogram;
    }

    /**
     * Returns the output for the red histogram. Or null if no output generated.
     *
     * @return The histogram data.
     */
    public HistogramData getRedHistogramOutput() {
        return combinedHistogram;
    }

    /**
     * Returns the output for the green histogram. Or null if no output generated.
     *
     * @return The histogram data.
     */
    public HistogramData getGreenHistogramOutput() {
        return combinedHistogram;
    }

    /**
     * Returns the output for the blue histogram. Or null if no output generated.
     *
     * @return The histogram data.
     */
    public HistogramData getBlueHistogramOutput() {
        return combinedHistogram;
    }
}
