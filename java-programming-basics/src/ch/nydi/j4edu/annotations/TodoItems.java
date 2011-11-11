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
 * Annotation to collect todos together.
 * 
 * @author Daniel Nydegger
 */
@Documented
@Target({ ElementType.TYPE })
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface TodoItems {

    Todo[] todos();
}
