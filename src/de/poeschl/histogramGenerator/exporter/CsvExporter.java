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

package de.poeschl.histogramGenerator.exporter;

import de.poeschl.histogramGenerator.models.ChannelData;
import de.poeschl.histogramGenerator.models.HistogramData;

import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by Markus Pöschl on 31.03.2014.
 */
public class CsvExporter implements ExporterInterface {

    @Override
    public void exportToFileWriter(FileOutputStream outputStream, HistogramData data) {

        PrintWriter printWriter = new PrintWriter(outputStream);

        //Write header in file
        printWriter.println(generateHeadEntry());

        //Gather data and print it into file
        ChannelData combined = data.getCombinedChannel();
        ChannelData red = data.getRedChannel();
        ChannelData green = data.getGreenChannel();
        ChannelData blue = data.getBlueChannel();

        for (int i = 0; i < ChannelData.MAX_CHANNEL_VALUE; i++) {
            String entry = generateDataEntry(i, combined.getValueForBrightness(i), red.getValueForBrightness(i), green.getValueForBrightness(i), blue.getValueForBrightness(i));
            printWriter.println(entry);
        }

        printWriter.close();
    }

    private String generateHeadEntry() {
        return "Brightness, Combined value, Red value, Green value, Blue value";
    }

    private String generateDataEntry(int brightness, int combinedValue, int redValue, int greenValue, int blueValue) {
        return String.format("%d, %d, %d, %d, %d", brightness, combinedValue, redValue, greenValue, blueValue);
    }
}
