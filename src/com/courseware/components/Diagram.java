package com.courseware.components;

//this is a LEAF component
public class Diagram implements CurriculumComponent{
    private String diagramName;

    //create diagram with the specified name/title
    public Diagram(String diagramName){
        this.diagramName=diagramName;
    }

    //preserving the Open/Closed Principle
    public String getDiagramName() {
        return diagramName;
    }

    //display the diagram info
    @Override
    public void display(){
        System.out.println("Diagram: "+ diagramName);
    }
}
