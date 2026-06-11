# Interactive Courseware Builder

## SOLID Adherence

This project adheres to the SOLID principles, with a focus on the Liskov Substitution Principle (LSP) and the Open/Closed Principle (OCP).

### 1. Liskov Substitution Principle (LSP)
**Proof in Code:** `com.courseware.components.QuizBlock` and `com.courseware.components.LessonText`

LSP states that objects of a superclass shall be replaceable with objects of its subclasses. In this project:
* `LessonText` is a base Leaf node that holds standard text content.
* `QuizBlock` directly `extends LessonText`. 
`QuizBlock` reuses the parent's data structure but overrides the `display()` behavior. As it inherits from `LessonText`, the client (`Main.java`) and the composite node (`Chapter.java`) can accept a `QuizBlock` anywhere a standard `LessonText` is expected.

### 2. Open/Closed Principle (OCP)
**Proof in Code:** `com.courseware.exporters.*` and `com.courseware.factories.*`

OCP states that software entities should be open for extension but closed for modification. 
In our Abstract Factory and Exporter implementation, the curriculum components (`Chapter`, `LessonText`, etc.) contain zero knowledge of how they are exported; they merely provide data via getters. 
If the university suddenly requires a new format (e.g., Markdown), we do not need to modify **any** existing component or factory classes. We create a new `MarkdownExporter` (implementing `Exporter`) and a `MarkdownFactory` (implementing `Exportfactory`). The system structure remains entirely untouched (closed for modification) while seamlessly supporting new formats (open for extension).