/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.annotations;

/**
 * Use the {@link TodoAnnotationProcessor}.
 * 
 * @author Daniel Nydegger
 */
public class TestTodoAnnotationProcessor {

    public static void main(String[] args) {
        TestTodoAnnotationProcessor app = new TestTodoAnnotationProcessor();
        app.testProcessor();
    }

    private void testProcessor() {
        TodoAnnotationProcessor annotationProcessor = new TodoAnnotationProcessor(System.out);
        annotationProcessor.processTodoAnnotations(MyClass.class);
    }
}
