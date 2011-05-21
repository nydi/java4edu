/**
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 *
 * FileName    : HelloWorldAsClass.java
 * Created on  : 21.05.2011
 * Created by  : Daniel Nydegger
 */
package ch.nydi.j4edu.basic;

/**
 * Hello World output separated in a class.
 * 
 * @author Daniel Nydegger
 * @date 21.05.2011
 */
public class HelloWorldAsClass {

    private final String hello = "Hello World taken from HelloWorldAsClass";

    public void printHelloWorld() {
        System.out.println(hello);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

}
