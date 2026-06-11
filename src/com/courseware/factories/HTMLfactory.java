package com.courseware.factories;

import com.courseware.exporters.Exporter;
import com.courseware.exporters.HTMLexporter;

//Concrete factory for creating HTML Exporters.
public class HTMLfactory implements Exportfactory {
    @Override
    public Exporter createExporter() {
        return new HTMLexporter();
    }
}