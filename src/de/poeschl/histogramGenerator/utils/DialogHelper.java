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

import javafx.scene.Scene;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Created by Markus Pöschl on 07.04.2014.
 */
public class DialogHelper {

    private static final int DIALOG_WIDTH = 100;
    private static final int DIALOG_HEIGHT = 40;

    private static DialogHelper ourInstance = new DialogHelper();

    public static DialogHelper getInstance() {
        return ourInstance;
    }

    private DialogHelper() {
    }

    public void showBasicDialog(String message) {
        Stage dialogStage = new Stage();

        Text messageText = new Text(message);
        messageText.prefHeight(DIALOG_HEIGHT);
        messageText.prefWidth(DIALOG_WIDTH);
        messageText.setTextAlignment(TextAlignment.CENTER);

        VBoxBuilder builder = VBoxBuilder.create().children(messageText);
        builder.prefHeight(DIALOG_HEIGHT);
        builder.prefWidth(DIALOG_WIDTH);
        dialogStage.setScene(new Scene(builder.build()));

        dialogStage.show();
    }
}
