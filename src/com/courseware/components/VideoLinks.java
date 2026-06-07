package com.courseware.components;

//this is a LEAF component
public class VideoLinks implements CurriculumComponent{
    private String url;

    //create a video link with the specified URL
    public VideoLinks(String url){
        this.url=url;
    }

    //display the video link info
    @Override
    public void display(){
        System.out.println("Video: "+ url);
    }
}
