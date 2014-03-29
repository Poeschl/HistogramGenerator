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
public class CombinedRGBGenerator implements GeneratorInterface {

    private ImageData imageSource;
    private HistogramData generatedData;

    public CombinedRGBGenerator(ImageData imageSource) {
        setImageAsInput(imageSource);
    }

    @Override
    public void setImageAsInput(ImageData data) {
        this.imageSource = data;
    }

    /**
     * Calculates the histogram data based on the gray value per pixel. The Calculation of the gray values comes from <a href="http://en.wikipedia.org/wiki/Grayscale">wikipedia</a>.
     */
    @Override
    public void generateImageData() {
        generatedData = new HistogramData(HistogramType.RGB);

        for (int y = 0; y < imageSource.getHeight(); y++) {
            for (int x = 0; x < imageSource.getWidth(); x++) {
                Color currentPixelColor = imageSource.getPixel(x, y).getColor();

                //calculates the grayscale value of the current pixel. The formula comes from wikipedia.
                int combinedValue = (int) (0.2989 * currentPixelColor.getRed() + 0.5870 * currentPixelColor.getGreen() + 0.1140 * currentPixelColor.getBlue());

                generatedData.incrementBrightnessValue(combinedValue);
            }
        }

    }

    @Override
    public HistogramData getHistogramOutput() {
        return null;
    }
}
