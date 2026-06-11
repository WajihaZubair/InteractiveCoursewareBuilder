package com.courseware.prototype;

import com.courseware.components.Chapter;
import java.util.ArrayList;
import java.util.List;

//clone a 101 course template
//a reusable course template that can be duplicated....provides a cloning mechanism, for creating copies of the course template
public class CourseTemplate implements Cloneable{

    private String courseName;
    private List<Chapter> chapters = new ArrayList<>();

    //creates a course template with the specified course name
    public CourseTemplate(String courseName){
        this.courseName=courseName;
    }

    public void setName(String courseName) {
        this.courseName = courseName;
    }

    public String getName() {
        return courseName;
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }
    
    public List<Chapter> getChapters() {
        return chapters;
    }

    //creates and returns a copy of this course template
    @Override
    public CourseTemplate clone(){
        try{
            CourseTemplate clonedTemplate = (CourseTemplate) super.clone();

            //performing deep copy
            clonedTemplate.chapters = new ArrayList<>(this.chapters);

            return clonedTemplate;
        }
        catch(CloneNotSupportedException e){
            throw new RuntimeException((e));
        }
    }

    public void display(){
        System.out.println("\n==================================");
        System.out.println("COURSE: " + courseName);
        System.out.println("==================================");
        
        for (Chapter c : chapters) {
            c.display();
        }
    }

}
