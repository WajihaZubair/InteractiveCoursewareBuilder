package com.courseware.exporters;

//This is a Concrete product in the factory method
public class HTMLexporter implements Exporter{
    //exports the specified course as an HTML document
    @Override
    public void exports(String courseName){
        System.out.println("Exporting "+courseName+ " as HTML...");
    }
}
