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
