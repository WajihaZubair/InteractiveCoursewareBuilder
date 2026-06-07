package com.courseware.components;

//this is a LEAF component
public class Diagrams implements CurriculumComponent{
    private String diagramName;

    //create diagram with the specified name/title
    public Diagrams(String diagramName){
        this.diagramName=diagramName;
    }

    //display the diagram info
    @Override
    public void display(){
        System.out.println("Diagram: "+ diagramName);
    }
}
