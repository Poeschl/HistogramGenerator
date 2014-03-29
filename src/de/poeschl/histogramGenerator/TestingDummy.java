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

package de.poeschl.histogramGenerator;

import de.poeschl.histogramGenerator.generators.GeneratorInterface;
import de.poeschl.histogramGenerator.generators.RGBGenerator;
import de.poeschl.histogramGenerator.models.HistogramData;
import de.poeschl.histogramGenerator.models.HistogramType;
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
            GeneratorInterface dummyGenerator;

            dummyGenerator = new RGBGenerator(HistogramType.RED, imageData);

            dummyGenerator.generateImageData();

            HistogramData result = dummyGenerator.getHistogramOutput();

            System.out.println(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
