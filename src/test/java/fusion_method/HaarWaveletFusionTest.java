/*
 * Copyright 2014 Arthur Henning.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fusion_method;

import ij.ImagePlus;
import image_processing.PostProcessor;
import java.io.File;
import javax.swing.JFileChooser;
import junit.framework.TestCase;

/**
 *
 * @author Arthur Henning
 */
public class HaarWaveletFusionTest extends TestCase {

    public HaarWaveletFusionTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of fuse method, of class HaarWaveletFusion.
     */
    public void testFuse() {
        System.out.println("fuse");
        // the relative path to the image
        ImagePlus image1 = new ImagePlus("target/test-classes/mri.jpg");
        image1.show();
        ImagePlus image2 = new ImagePlus("F:\\UTCN\\test_images\\mri_hard.jpg");
        image2.show();
        HaarWaveletFusion instance = new HaarWaveletFusion(4, new SimpleMaximumFusion());
        ImagePlus expResult = null;
        ImagePlus result = instance.fuse(image1, image2);
        result.show();
        PostProcessor pr = new PostProcessor();
        pr.process(result, 0);
        result.show();
        assertEquals(expResult, result);
    }

}
