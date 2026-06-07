package com.courseware.components;

import java.util.ArrayList;
import java.util.List;

//represent a chapter that cna have multiple curriculum components like lessons, quizzes, diagrams, video.
//This is the COMPOSITE COMPONENT in the design pattern
public class Chapters implements CurriculumComponent{

    public String name;
    //list of child curriculum components contained within this chapter
    private List<CurriculumComponent> children=new ArrayList<>();
    //create a chapter with the specified name
    public Chapters(String name){
        this.name=name;
    }

    //add a curriculum component to the chapter
    public void add(CurriculumComponent component){
        children.add(component);
    }

    //display the chapter name and all of its child components
    @Override
    public void display(){
        System.out.println("\nChapter: " +name);
        for(CurriculumComponent c:children){
            c.display();
        }
    }
}
