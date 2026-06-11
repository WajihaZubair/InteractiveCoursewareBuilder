package com.courseware.exporters;

import com.courseware.components.*;

public class HTMLexporter implements Exporter {
    
    @Override
    public void exports(CurriculumComponent component) {
        System.out.println("--- GENERATING HTML FILE ---");
        System.out.println("<html>\n<head><title>Course Export</title></head>\n<body>");
        System.out.println(generateNode(component));
        System.out.println("</body>\n</html>");
    }

    // Recursively traverses the Composite tree to build HTML
    private String generateNode(CurriculumComponent c) {
        if (c instanceof Chapter) {
            Chapter ch = (Chapter) c;
            StringBuilder html = new StringBuilder();
            html.append("  <h1>").append(ch.getName()).append("</h1>\n");
            
            // Generate HTML for all children inside this chapter
            for (CurriculumComponent child : ch.getChildren()) {
                html.append(generateNode(child));
            }
            return html.toString();
        } 
        // We check QuizBlock FIRST because it extends LessonText (LSP)
        else if (c instanceof QuizBlock) {
            return "  <div style='border:1px solid red; padding:10px;'>" + 
                   "<b>Quiz Question:</b> " + ((QuizBlock) c).getContent() + 
                   "</div>\n";
        } 
        else if (c instanceof LessonText) {
            return "  <p>" + ((LessonText) c).getContent() + "</p>\n";
        } 
        else if (c instanceof VideoLink) {
            return "  <a href='" + ((VideoLink) c).getUrl() + "'>Watch Video</a><br>\n";
        } 
        else if (c instanceof Diagram) {
            return "  <img src='" + ((Diagram) c).getDiagramName() + ".png' alt='Diagram'/><br>\n";
        }
        return "";
    }
}