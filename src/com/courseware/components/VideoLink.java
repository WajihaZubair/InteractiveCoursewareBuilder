package com.courseware.components;

//this is a LEAF component
public class VideoLink implements CurriculumComponent{
    private String url;

    //create a video link with the specified URL
    public VideoLink(String url){
        this.url=url;
    }

    //preserving the Open/Closed Principle
    public String getUrl() {
        return url;
    }

    //display the video link info
    @Override
    public void display(){
        System.out.println("Video: "+ url);
    }
}
