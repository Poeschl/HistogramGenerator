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

package de.poeschl.histogramGenerator.exporter;

import de.poeschl.histogramGenerator.models.HistogramData;

import java.io.FileOutputStream;

/**
 * Created by Markus Pöschl on 31.03.2014.
 */
public interface ExporterInterface {
    /**
     * Export the generated data to a file through a FileOutputStream.
     *
     * @param fileStream The File to write to.
     * @param data       The data to be written into the file.
     */
    public void exportToFileWriter(FileOutputStream fileStream, HistogramData data);
}
