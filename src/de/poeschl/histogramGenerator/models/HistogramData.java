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

/**
 * Stores the data of the histogram of a image. It only hold values for one defined channel or combined.
 * <p/>
 * Created by Markus Pöschl on 29.03.2014.
 */
public class HistogramData {

    public static final int MAX_CHANNEL_VALUE = 256;

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
        values[brightness] = ++values[brightness];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(type.toString() + " Values: \n");
        for (int i = 0; i < values.length; i++) {
            builder.append(i);
            builder.append(": ");
            builder.append(values[i]);
            builder.append("\n");
        }
        return builder.toString();
    }
}
