import com.courseware.components.*;

public class Main{
    public static void main(String[] args){
        Chapters chapter1=new Chapters("Introdcution");
        chapter1.add(new LessonText("What is OOP?"));
        chapter1.add(new QuizBlocks("Define encapsulation"));
        chapter1.display();
    }


}