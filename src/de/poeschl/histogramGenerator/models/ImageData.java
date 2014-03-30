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

package de.poeschl.histogramGenerator.models;

import java.awt.*;

/**
 * This class is the representation of a image as RGB Values.
 * <p/>
 * Created by Markus Pöschl on 29.03.2014.
 */
public class ImageData {

    /**
     * Here is all the pixel data. imageMatrix [x][y]
     */
    private Color[][] imageMatrix;

    public ImageData(int width, int height) {
        imageMatrix = new Color[width][height];
    }

    /**
     * Sets the color of a pixel. The needed coordinate is included in the pixel model. If a pixel is set twice, the newer one replaces the old one.
     *
     * @param pixel The pixel to set. Includes coordinates and color.
     */
    public void setPixel(Pixel pixel) {
        imageMatrix[pixel.getxPosition()][pixel.getyPosition()] = pixel.getColor();
    }

    /**
     * Returns the pixel for the given position.
     *
     * @param x The x position.
     * @param y The y position.
     * @return The pixel on the position with color.
     */
    public Pixel getPixel(int x, int y) {
        return new Pixel(x, y, imageMatrix[x][y]);
    }

    public int getHeight() {
        return imageMatrix[0].length;
    }

    public int getWidth() {
        return imageMatrix.length;
    }
}
