import com.courseware.components.*;
import com.courseware.prototype.*;

public class Main{
    public static void main(String[] args){
        Chapters chapter1=new Chapters("Introdcution");
        chapter1.add(new LessonText("What is OOP?"));
        chapter1.add(new QuizBlocks("Define encapsulation"));
        chapter1.add(new Diagrams("OOP Class Diagram"));
        chapter1.add(new VideoLinks("youtube.com/oop-intro"));
        System.out.println("---Display chapter components---");
        chapter1.display();

        System.out.println("\n---Testing Prototype pattern (cloning)---");
        courseTemplate template=new courseTemplate("101 Course Template");
        courseTemplate oopCourse=(courseTemplate)template.clone();
        oopCourse.display();
    }


}