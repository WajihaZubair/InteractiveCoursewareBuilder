package com.courseware.factories;

import com.courseware.exporters.Exporter;

//The Abstract Factory interface. Defines the contract for creating Exporter objects.
public interface Exportfactory {
    Exporter createExporter();
}