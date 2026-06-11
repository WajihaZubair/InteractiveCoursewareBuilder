package com.courseware.exporters;

import com.courseware.components.*;

public class PDFexporter implements Exporter {
    
    @Override
    public void exports(CurriculumComponent component) {
        System.out.println("--- GENERATING ACTUAL LATEX (PDF) ---");
        System.out.println("\\documentclass{article}");
        
        System.out.println("\\usepackage{graphicx}");
        System.out.println("\\usepackage{hyperref}");
        
        System.out.println("\\begin{document}");
        System.out.println(generateNode(component));
        System.out.println("\\end{document}");
    }

    // Recursively traverses the Composite tree to build LaTeX syntax
    private String generateNode(CurriculumComponent c) {
        if (c instanceof Chapter) {
            Chapter ch = (Chapter) c;
            StringBuilder latex = new StringBuilder();
            latex.append("\\section{").append(ch.getName()).append("}\n");
            
            for (CurriculumComponent child : ch.getChildren()) {
                latex.append(generateNode(child));
            }
            return latex.toString();
        } 
        else if (c instanceof QuizBlock) {
            return "\\textbf{Quiz:} " + ((QuizBlock) c).getContent() + "\\\\\n\n";
        } 
        else if (c instanceof LessonText) {
            return ((LessonText) c).getContent() + "\n\n";
        }
        else if (c instanceof Diagram) {
            return "\\begin{figure}[h!]\n  \\centering\n  \\includegraphics{" 
                   + ((Diagram) c).getDiagramName() + ".png}\n\\end{figure}\n\n";
        }
        else if (c instanceof VideoLink) {
            return "\\textbf{Video Resource:} \\url{" + ((VideoLink) c).getUrl() + "}\\\\\n\n";
        }
        return "";
    }
}