/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.basic.clazz;

/**
 * Example for instanciate objects of a reference type
 * 
 * @author Daniel Nydegger
 */
public class ClassUsage {

    public static void main(String[] args) {
        ClassUsage classUsage = new ClassUsage();
        classUsage.tryMyClass();
    }

    /**
     * Create a few instances.
     */
    private void tryMyClass() {

        // create two instances of MyClass
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();

        // use it
        myClass1.say("first hello");
        myClass2.say("second hello");
    }
}
