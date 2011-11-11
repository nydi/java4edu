/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.annotations;

/**
 * Test class to play with annotations.
 * 
 * @author Daniel Nydegger
 */
@TodoItems(todos = {
@Todo(severity = Todo.Severity.MAJOR, description = "rename the class", owner = "D.Nydegger", assigned = "Q.Meier"),
@Todo(description = "add more examples", owner = "D.Nydegger", assigned = "D.Nydegger") })
public class MyClass {

    @Todo(severity = Todo.Severity.NORMAL, description = "add some logic", owner = "D.Nydegger", assigned = "D.Nydegger")
    public void simpleCall() {

    }

    public void anootherSimpleCall() {

    }
}
