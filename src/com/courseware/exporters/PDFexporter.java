package com.courseware.exporters;
//This is a Concrete product in the factory method
public class PDFexporter implements Exporter{
    //exports the specified course as an PDF document
    @Override
    public void exports(String courseName){
        System.out.println("Exporting "+courseName+ " as PDF...");
    }
}
