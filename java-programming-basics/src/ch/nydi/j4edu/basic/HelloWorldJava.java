/**
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 *
 * FileName    : HelloWorldJava.java
 * Created on  : 21.05.2011
 * Created by  : Daniel Nydegger
 */
package ch.nydi.j4edu.basic;

/**
 * Hello World output in vaiations.
 * 
 * @author Daniel Nydegger
 * @date 21.05.2011
 */
public class HelloWorldJava {

    public static void main(String[] args) {
        // print out a string literal
        System.out.println("Hello World in Java, what a success ;-)");

        // print out a variable
        String hello = "Hello World cointained in String variable";
        System.out.println(hello);

        // Create a instance of HelloWorldAsClass an print the Hello World of that class
        HelloWorldAsClass helloClass = new HelloWorldAsClass();
        helloClass.printHelloWorld();

        // Call the printMessage method of HelloWorldAsClass to print Hello World, reuse instance of helloClass
        helloClass.printMessage("Hello World from HelloWorldJava");
    }
}
