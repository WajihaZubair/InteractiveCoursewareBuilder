package com.courseware.components;

//this is a LEAF component

public class QuizBlocks implements CurriculumComponent{
    //LSP proof: so anywhere where the system expects CurriculumComponent, we can pass QuizBlocks without affecting correctness
    private String question;

    //create a quiz block with the specific question
    public QuizBlocks(String question){
        this.question=question;
    }

    //display the quiz question
    @Override
    public void display(){
        System.out.println("Quiz: "+question);
    }
}
