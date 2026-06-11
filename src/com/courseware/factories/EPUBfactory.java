package com.courseware.factories;

import com.courseware.exporters.Exporter;
import com.courseware.exporters.EPUBexporter;

//Concrete factory for creating EPUB Exporters.
public class EPUBfactory implements Exportfactory {
    @Override
    public Exporter createExporter() {
        return new EPUBexporter();
    }
}