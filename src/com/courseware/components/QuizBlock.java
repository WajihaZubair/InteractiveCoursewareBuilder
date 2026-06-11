package com.courseware.components;

//this is a LEAF component
//LSP Proof: QuizBlock extends LessonText, meaning it can safely replace LessonText anywhere in the system without breaking functionality.
public class QuizBlock extends LessonText {
    //create a quiz block with the specific question
    public QuizBlock(String question){
        super(question);
    }

    //Overrides the parent behavior to identify as a Quiz
    @Override
    public void display(){
        System.out.println("Quiz: "+ content);
    }
}
