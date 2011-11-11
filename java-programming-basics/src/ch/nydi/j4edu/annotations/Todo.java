/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Simple todo annotation.
 * 
 * @author Daniel Nydegger
 */
@Documented
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Todo {

    public enum Severity {
        CRITICAL, MAJOR, NORMAL, LOW;
    }

    Severity severity() default Todo.Severity.NORMAL;

    String description();

    String owner();

    String assigned() default "unassigned";
}
