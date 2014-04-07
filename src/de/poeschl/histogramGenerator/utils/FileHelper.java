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

package de.poeschl.histogramGenerator.utils;

import de.poeschl.histogramGenerator.models.ExportFileFormat;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Markus Pöschl on 30.03.2014.
 */
public class FileHelper {
    private static FileHelper ourInstance = new FileHelper();

    public static FileHelper getInstance() {
        return ourInstance;
    }

    private FileHelper() {
    }

    /**
     * Opens a file chooser and selects a image. The filetyps are filterd by the InputType enum.
     *
     * @param stage The current application stage to display the chooser.
     * @return The selected file or null if no file was selected or the chooser was canceled.
     */
    public File selectImageFromFileSystem(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Input Image");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        for (ImageInputType inputType : ImageInputType.values()) {
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(inputType.getLabel(), inputType.getExtensions()));
        }

        return fileChooser.showOpenDialog(stage);
    }

    /**
     * Returns a stream of the file, where the user wants to store the file. Don't forget to close the writer after finishing!
     *
     * @param stage      The current application stage to display the chooser.
     * @param fileFormat The file format of the file to save. The "All files" filter is automatically added.
     * @return A FileOutputStream which is connected to the chosen file.
     */
    public FileOutputStream getSaveFileOutput(Stage stage, ExportFileFormat fileFormat) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File...");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        ExportFileFormat allFiles = ExportFileFormat.ALL_FILES;
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(allFiles.getLabel(), allFiles.getExtensions()));
        if (fileFormat != null) {
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(fileFormat.getLabel(), fileFormat.getExtensions()));
        }

        File output = fileChooser.showSaveDialog(stage);

        if (output == null) {
            return null;
        }

        if (!output.getName().matches(".+[.].+")) {
            output = new File(output.getPath() + fileFormat.getLabel());
        }

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream;
    }

    private enum ImageInputType {
        ALL_IMAGES("All Images", "*.png", "*.jpg", "*.jpeg", "*.gif"), PNG(".png", "*.png"), JPG(".jpeg", "*.jpg", "*jpeg"), GIF(".gif", "*.gif"), ALL_FILES("All files", "*.*");


        private List<String> extensions;
        private String label;

        ImageInputType(String label, String... extensions) {
            this.extensions = new ArrayList<String>();

            Collections.addAll(this.extensions, extensions);

            this.label = label;
        }

        public List<String> getExtensions() {
            return extensions;
        }

        public String getLabel() {
            return label;
        }
    }
}
