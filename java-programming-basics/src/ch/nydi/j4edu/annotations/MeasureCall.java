/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation to signal a annotation processor to instrument the method call with a duration call timer. Note: Example
 * for a useful annotation without implementation of the annotation processor.
 * 
 * @author Daniel Nydegger
 */
@Inherited
@Documented
@Target({ ElementType.METHOD })
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface MeasureCall {

    String description() default "duration of method call";
}
