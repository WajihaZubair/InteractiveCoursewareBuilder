import com.courseware.components.*;
import com.courseware.prototype.*;
import com.courseware.flyweight.*;
import com.courseware.factories.*;
import com.courseware.exporters.*;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- 1. Testing Flyweight Pattern (Memory Optimization) ---");
        // Load the shared text into RAM exactly once.
        SharedText honorCode = FlyweightFactory.getText("University Honor Code Policy");
        SharedText testInstructions = FlyweightFactory.getText("Standard Test Instructions");
        System.out.println("Loaded shared policies into memory.");

        System.out.println("\n--- 2. Testing Composite Pattern (Structure) ---");
        Chapter chapter1 = new Chapter("Chapter 1: Introduction to OOP");
        // Injecting the Flyweight references into the chapter
        chapter1.setPolicy(honorCode);
        chapter1.setInstructions(testInstructions);
        chapter1.add(new LessonText("What is OOP?"));
        chapter1.add(new QuizBlock("Define encapsulation")); 
        chapter1.add(new Diagram("OOP Class Diagram"));
        chapter1.add(new VideoLink("youtube.com/oop-intro"));
        
        System.out.println("Chapter 1 built successfully.");
        chapter1.display();

        System.out.println("\n--- 3. Testing Prototype Pattern (Cloning Templates) ---");
        CourseTemplate baseTemplate = new CourseTemplate("101 Course Template");
        
        // Add the detailed chapter we built in Section 2
        baseTemplate.addChapter(chapter1);
        
        //Simulate the full 15-chapter structure
        for (int i = 2; i <= 15; i++) {
            Chapter dummyChapter = new Chapter("Chapter " + i + ": Standard Module");
            dummyChapter.setPolicy(honorCode);
            dummyChapter.setInstructions(testInstructions);
            baseTemplate.addChapter(dummyChapter);
        }
        System.out.println("Base 15-chapter template loaded into memory.");
        
        // Clone the massive 15-chapter structure instantly
        CourseTemplate oopCourse = (CourseTemplate) baseTemplate.clone();
        oopCourse.setName("CS 201: Advanced Object-Oriented Programming");
        
        // Filling in course-specific questions
        Chapter specificExam = new Chapter("Course-Specific Exam");
        specificExam.setPolicy(honorCode);
        specificExam.setInstructions(testInstructions);
        specificExam.add(new QuizBlock("Explain how the Liskov Substitution Principle works."));
        
        oopCourse.addChapter(specificExam); // This makes it 16 chapters total for the specific course
        
        System.out.println("Cloned base template and renamed to: " + oopCourse.getName());
        System.out.println("Successfully added course-specific questions without altering the base template.");
        
        System.out.println("\n--- 4. Testing Abstract Factory Pattern (Exporters) ---");
        
        // Create a root composite node to hold the entire cloned course
        Chapter courseRoot = new Chapter(oopCourse.getName());
        for (Chapter c : oopCourse.getChapters()) {
            courseRoot.add(c);
        }
        
        // Export to WebLMS (HTML)
        Exportfactory htmlFactory = new HTMLfactory();
        Exporter htmlExporter = htmlFactory.createExporter();
        // Pass the actual component tree instead of a String
        htmlExporter.exports(courseRoot); 
        
        // Export to Printable PDF (LaTeX syntax)
        Exportfactory pdfFactory = new PDFfactory();
        Exporter pdfExporter = pdfFactory.createExporter();
        pdfExporter.exports(courseRoot);

        // Export to ePub
        Exportfactory epubFactory = new EPUBfactory();
        Exporter epubExporter = epubFactory.createExporter();
        epubExporter.exports(courseRoot);
    }
}