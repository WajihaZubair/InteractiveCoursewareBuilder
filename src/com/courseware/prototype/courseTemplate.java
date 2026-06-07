package com.courseware.prototype;

//clone a 101 course template
//a reusable course template that can be duplicated....provides a cloning mechanism, for creating copies of the course template
public class courseTemplate implements Cloneable{

    private String courseName;

    //creates a course template with the specified course name
    public courseTemplate(String courseName){
        this.courseName=courseName;
    }

    //creates and returns a copy of this course template
    @Override
    public courseTemplate clone(){
        try{
            return(courseTemplate) super.clone();
        }
        catch(CloneNotSupportedException e){
            throw new RuntimeException((e));
        }
    }
    public void display(){
        System.out.println(courseName);
    }

}
