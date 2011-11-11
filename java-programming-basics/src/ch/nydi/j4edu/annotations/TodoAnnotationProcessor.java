/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.annotations;

import java.io.PrintStream;
import java.lang.reflect.Method;

/**
 * Processes the {@link Todo} and {@link TodoItems} annotations.
 * 
 * @author Daniel Nydegger
 */
public class TodoAnnotationProcessor {

    private static final String NL = "\n";
    private final PrintStream out;

    /**
     * @param out
     *            print stream to output the annotation pars result.
     */
    public TodoAnnotationProcessor(PrintStream out) {
        this.out = out;
    }

    public void processTodoAnnotations(Class<?> clazz) {
        StringBuilder builder = new StringBuilder();

        // check for TodoItems annotations (type)
        if (clazz.isAnnotationPresent(TodoItems.class)) {
            builder.append("Todo Items for class ").append(clazz.getName());
            builder.append(printTodoItems(clazz.getAnnotation(TodoItems.class)));
        }
        // check for Todo annotations (type)
        if (clazz.isAnnotationPresent(Todo.class)) {
            builder.append("Todo for class ").append(clazz.getName());
            builder.append(printTodo(clazz.getAnnotation(Todo.class)));
        }

        // check for Todos (method)
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                builder.append("Todos for method ").append(method.toString()).append(NL);
                builder.append(printTodo(method.getAnnotation(Todo.class))).append(NL);
            }
        }
        out.println(builder.toString());
    }

    private String printTodoItems(TodoItems todoItems) {
        StringBuilder builder = new StringBuilder();

        builder.append(NL);
        for (Todo todo : todoItems.todos()) {
            builder.append(printTodo(todo));
            builder.append(NL);
        }

        return builder.toString();
    }

    private String printTodo(Todo todo) {
        StringBuilder builder = new StringBuilder();
        builder.append("Severity: ").append(todo.severity().toString()).append(NL);
        builder.append("Description: ").append(todo.description()).append(NL);
        builder.append("Owner: ").append(todo.owner()).append(NL);
        builder.append("Assigned to: ").append(todo.assigned()).append(NL);

        return builder.toString();
    }
}
