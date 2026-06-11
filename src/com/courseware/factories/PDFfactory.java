package com.courseware.factories;

import com.courseware.exporters.Exporter;
import com.courseware.exporters.PDFexporter;

//Concrete factory for creating PDF Exporters.
public class PDFfactory implements Exportfactory {
    @Override
    public Exporter createExporter() {
        return new PDFexporter();
    }
}