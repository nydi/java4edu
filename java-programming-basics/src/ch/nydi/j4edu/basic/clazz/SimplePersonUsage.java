/**
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 *
 * FileName    : SimplePersonUsage.java
 * Created on  : 27.05.2011
 * Created by  : Daniel Nydegger
 */
package ch.nydi.j4edu.basic.clazz;

/**
 * Play with the simple Person.
 * 
 * @author Daniel Nydegger
 * @date 27.05.2011
 */
public class SimplePersonUsage {

    public static void main(String[] args) {
        SimplePersonUsage launcher = new SimplePersonUsage();
        launcher.trySimplePerson1();
        launcher.trySimplePerson2();
    }

    private void trySimplePerson1() {
        SimplePerson1 p1 = new SimplePerson1();
        p1.setName("Werner Meier");
        p1.setYearOfBirth(1978);

        SimplePerson1 p2 = new SimplePerson1();
        p2.setName("Hans Muster");
        p2.setYearOfBirth(1980);

        SimplePerson1 p3 = new SimplePerson1();
        p3.setName("Erika Körner");
        p3.setYearOfBirth(1973);

        System.out.println(p1.toString());
        System.out.println(p2); // call of toString() is done implicit
        System.out.println(p3);

        // all three object references are independent from each other in the stack space. They point to three reserved
        // memory spaces in the heap space.
    }

    private void trySimplePerson2() {
        SimplePerson2 p1 = new SimplePerson2(1978, "Werner Meier");
        System.out.println("age of p1: " + p1.age());
        SimplePerson2 p2 = new SimplePerson2(1980, "Hans Muster");
        System.out.println("age of p2: " + p2.age());
        SimplePerson2 p3 = new SimplePerson2(1973, "Erika Körner");
        System.out.println("age of p3: " + p3.age());
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        // get the static instance counter, access via class reference
        System.out.println(SimplePerson2.instanceCounter);
        // call the class method getInstanceCounter to get the class variable
        System.out.println(SimplePerson2.getInstanceCounter());
    }

}
