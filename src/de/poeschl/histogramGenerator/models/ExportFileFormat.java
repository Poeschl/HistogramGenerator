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

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Markus Pöschl on 30.03.2014.
 */
public enum ExportFileFormat {
    CSV(".csv", "*.csv"), PNG(".png", "*.png"), ALL_FILES("All files", "*.*");

    private List<String> extensions;
    private String label;

    ExportFileFormat(String label, String... extensions) {
        this.extensions = new ArrayList<String>();

        Collections.addAll(this.extensions, extensions);

        this.label = label;
    }

    @NotNull
    public List<String> getExtensions() {
        return extensions;
    }

    public String getLabel() {
        return label;
    }
}
