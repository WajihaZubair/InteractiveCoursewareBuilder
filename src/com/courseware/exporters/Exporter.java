package com.courseware.exporters;

import com.courseware.components.CurriculumComponent;

public interface Exporter {
    //It takes the curriculum structure
    void exports(CurriculumComponent treeRoot);
}