package com.courseware.components;

//this is a LEAF component

public class LessonText implements CurriculumComponent{
    //LSP proof: so anywhere where the system expects CurriculumComponent, we can pass LessonText without affecting correctness
    protected String content;

    //create lesson with the specified content
    public LessonText(String content){
        this.content=content;
    }

    //preserving the Open/Closed Principle
    public String getContent() {
        return content;
    }

    //display the lesson content
    @Override
    public void display(){
        System.out.println("Lesson: "+ content);
    }
}
