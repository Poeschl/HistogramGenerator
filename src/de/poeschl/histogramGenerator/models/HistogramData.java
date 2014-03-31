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
 * Stores the data of the histogram of a image. It only hold values for one defined channel or combinedChannel.
 * <p/>
 * Created by Markus Pöschl on 29.03.2014.
 */
public class HistogramData {

    private ChannelData combinedChannel;
    private ChannelData redChannel;
    private ChannelData greenChannel;
    private ChannelData blueChannel;

    public HistogramData() {
        combinedChannel = new ChannelData(ChannelType.RGB);
        redChannel = new ChannelData(ChannelType.RED);
        greenChannel = new ChannelData(ChannelType.GREEN);
        blueChannel = new ChannelData(ChannelType.BLUE);
    }

    public ChannelData getCombinedChannel() {
        return combinedChannel;
    }

    public void setCombinedChannel(ChannelData combinedChannel) {
        this.combinedChannel = combinedChannel;
    }

    public ChannelData getRedChannel() {
        return redChannel;
    }

    public void setRedChannel(ChannelData redChannel) {
        this.redChannel = redChannel;
    }

    public ChannelData getGreenChannel() {
        return greenChannel;
    }

    public void setGreenChannel(ChannelData greenChannel) {
        this.greenChannel = greenChannel;
    }

    public ChannelData getBlueChannel() {
        return blueChannel;
    }

    public void setBlueChannel(ChannelData blueChannel) {
        this.blueChannel = blueChannel;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(combinedChannel.toString());
        builder.append(redChannel.toString());
        builder.append(greenChannel.toString());
        builder.append(blueChannel.toString());

        return builder.toString();
    }
}
