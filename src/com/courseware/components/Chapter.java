package com.courseware.components;

import java.util.ArrayList;
import java.util.List;

import com.courseware.flyweight.SharedText;

//represent a chapter that cna have multiple curriculum components like lessons, quizzes, diagrams, video.
//This is the COMPOSITE COMPONENT in the design pattern
public class Chapter implements CurriculumComponent{
    private String name;
    //list of child curriculum components contained within this chapter
    private List<CurriculumComponent> children=new ArrayList<>();
    // Flyweight references: Loaded into RAM only once, shared across all chapters
    private SharedText honorCode;
    private SharedText testInstructions;

    //create a chapter with the specified name
    public Chapter(String name){
        this.name=name;
    }

    //add a curriculum component to the chapter
    public void add(CurriculumComponent component){
        children.add(component);
    }

    // Setters for the shared memory (Flyweight) policies
    public void setPolicy(SharedText honorCode) {
        this.honorCode = honorCode;
    }
    
    public void setInstructions(SharedText testInstructions) {
        this.testInstructions = testInstructions;
    }

    //preserving the Open/Closed Principle
    public String getName() {
        return name;
    }

    //preserving the Open/Closed Principle
    public List<CurriculumComponent> getChildren() {
        return children;
    }

    //display the chapter name and all of its child components
    @Override
    public void display() {
        System.out.println("\n=== Chapter: " + name + " ===");
        
        // Display Flyweight text if they have been injected
        if (honorCode != null) System.out.println("[Policy]: " + honorCode.getContent());
        if (testInstructions != null) System.out.println("[Instructions]: " + testInstructions.getContent());
        
        System.out.println("--- Content ---");
        for (CurriculumComponent c : children) {
            c.display();
        }
    }
}
