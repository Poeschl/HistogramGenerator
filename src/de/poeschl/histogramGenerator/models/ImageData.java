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
