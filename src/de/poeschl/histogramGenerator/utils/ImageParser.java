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

package de.poeschl.histogramGenerator.utils;

import de.poeschl.histogramGenerator.models.ImageData;
import de.poeschl.histogramGenerator.models.Pixel;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Markus Pöschl on 29.03.2014.
 */
public class ImageParser {
    private static ImageParser ourInstance = new ImageParser();

    public static ImageParser getInstance() {
        return ourInstance;
    }

    private ImageParser() {
    }

    /**
     * Parse the complete image and create a ImageData object from it.
     *
     * @param image The image to be parsed.
     * @return The data of the image.
     */
    public ImageData parseImage(BufferedImage image) {
        ImageData imageData = new ImageData(image.getWidth(), image.getHeight());

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Pixel currentPixel = new Pixel(x, y);

                //Read the colors per pixel
                int colorValue = image.getRGB(x, y);

                currentPixel.setColor(new Color(colorValue));
                imageData.setPixel(currentPixel);
            }
        }
        return imageData;
    }
}
