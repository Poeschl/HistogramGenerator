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

package de.poeschl.histogramGenerator;

import de.poeschl.histogramGenerator.generators.RGBHistogramGenerator;
import de.poeschl.histogramGenerator.models.HistogramData;
import de.poeschl.histogramGenerator.models.ImageData;
import de.poeschl.histogramGenerator.utils.ImageParser;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

/**
 * Just for testing the logic and stuff ;).
 * <p/>
 * Created by Markus Pöschl on 29.03.2014.
 */
public class TestingDummy {

    public static void main(String... args) {
        InputStream imageStream = TestingDummy.class.getResourceAsStream("/de/poeschl/histogramGenerator/resources/images/sample.png");

        try {
            ImageData imageData = ImageParser.getInstance().parseImage(ImageIO.read(imageStream));
            RGBHistogramGenerator dummyGenerator;

            dummyGenerator = new RGBHistogramGenerator(imageData);

            dummyGenerator.generateImageData();

            HistogramData result = dummyGenerator.getRedHistogramOutput();

            System.out.println(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
