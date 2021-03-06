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

package io;

import exception.DicomFusionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import quality_metrics.QualityMetricsOutput;

/**
 *
 * @author Arthur Henning
 */
public class TextResultsWriter implements QMResultsWriter {

    private String path;
    private String filename;

    public void setOutputFolder(String path) {
        this.path = path;
    }

    public void setOutputFile(String filename) {
        this.filename = filename;
    }

    public void write(ArrayList<ArrayList<QualityMetricsOutput>> results) throws DicomFusionException {

        PrintWriter pw = null;
        try {
            File workbookFile = new File(path);
            workbookFile.mkdirs();
            pw = new PrintWriter(new FileOutputStream(new File(this.path + "/" + this.filename + ".txt")));
            for (ArrayList<QualityMetricsOutput> outputArray : results) {
                for (QualityMetricsOutput output : outputArray) {
                    pw.println(output.toString());
                }
                pw.println();
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            throw new DicomFusionException(ex.getMessage());
        } finally {
            pw.close();
        }

    }

}
