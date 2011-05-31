/**
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 *
 * FileName    : MyClass.java
 * Created on  : 27.05.2011
 * Created by  : Daniel Nydegger
 */
package ch.nydi.j4edu.basic.clazz;

/**
 * A simple class to show instanciation.
 * 
 * @author Daniel Nydegger
 * @date 27.05.2011
 */
public class MyClass {

    public void say(String message) { // message is a formal parameter
        // in here you get a copy of the reference which points to the original data of the object instance
        System.out.println(message + " from " + toString());
    }
}
