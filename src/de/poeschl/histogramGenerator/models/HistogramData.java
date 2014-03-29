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

/**
 * Stores the data of the histogram of a image. It only hold values for one defined channel or combined.
 * <p/>
 * Created by Markus Pöschl on 29.03.2014.
 */
public class HistogramData {

    public static final int MAX_CHANNEL_VALUE = 265;

    private HistogramType type;
    private int[] values;

    public HistogramData(HistogramType type) {
        this.type = type;
        this.values = new int[MAX_CHANNEL_VALUE];
    }

    public HistogramData(HistogramData otherData) {
        this.type = otherData.type;
        this.values = otherData.values;
    }

    public HistogramType getType() {
        return type;
    }

    /**
     * Gives back an int value on the given position in the brightness (0 - 255) of the channel.
     *
     * @param brightness The brightness to look for.
     * @return The count of appearances of this brightness in the picture.
     */
    public int getValueForBrightness(int brightness) {
        return values[brightness];
    }

    public void incrementBrightnessValue(int brightness) {
        values[brightness] = values[brightness]++;
    }
}
