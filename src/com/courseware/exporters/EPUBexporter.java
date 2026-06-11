package com.courseware.exporters;

import com.courseware.components.*;

// This is a Concrete product in the factory method
public class EPUBexporter implements Exporter {
    
    // Exports the specified curriculum tree as an EPUB document
    @Override
    public void exports(CurriculumComponent component) {
        System.out.println("--- GENERATING ACTUAL EPUB (XML) ---");
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        System.out.println("<package version=\"3.0\">");
        System.out.println("  <spine>");
        System.out.println(generateNode(component));
        System.out.println("  </spine>");
        System.out.println("</package>");
    }

    // Recursively traverses the Composite tree
    private String generateNode(CurriculumComponent c) {
        if (c instanceof Chapter) {
            Chapter ch = (Chapter) c;
            StringBuilder epub = new StringBuilder();
            epub.append("    <chapter title=\"").append(ch.getName()).append("\">\n");
            
            for (CurriculumComponent child : ch.getChildren()) {
                epub.append(generateNode(child));
            }
            epub.append("    </chapter>\n");
            return epub.toString();
        } 
        else if (c instanceof QuizBlock) {
            return "      <quiz>" + ((QuizBlock) c).getContent() + "</quiz>\n";
        } 
        else if (c instanceof LessonText) {
            return "      <text>" + ((LessonText) c).getContent() + "</text>\n";
        } 
        else if (c instanceof VideoLink) {
            return "      <video src=\"" + ((VideoLink) c).getUrl() + "\"/>\n";
        } 
        else if (c instanceof Diagram) {
            return "      <image src=\"" + ((Diagram) c).getDiagramName() + ".png\"/>\n";
        }
        return "";
    }
}