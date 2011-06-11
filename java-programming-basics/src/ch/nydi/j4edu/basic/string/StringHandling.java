/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.basic.string;

/**
 * String and string handling examples.
 * 
 * @author Daniel Nydegger
 */
public class StringHandling {

    public static void main(String[] args) {
        StringHandling stringHandling = new StringHandling();
        stringHandling.concat();
        stringHandling.stringBuilder();
    }

    /**
     * Simple string concatenation.
     */
    private void concat() {
        // concatenation of strings is very easy
        System.out.println("Hello " + "World " + "once " + "more");

        // but
        // String variables and literals are not mutuable
        String str = "Hello"; // contains a fixed char[]
        // so
        str = str + " World";
        // produces a new string containing a char[] with the char[] of str and " Welt"
        // this is inefficient, also for a few strings, lt me say more than 3.
        // OK, current compilers detect such weak implementation, but... I think, we have
        // to code correct implementations.

        // So we look for a dynamic string structure -> StringBuilder

        // String has some nice features
        // iterate over all chars

        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }

        // ask index of a char or substring
        int indexOfA = str.indexOf('a');
        System.out.println("char 'a' at " + indexOfA);

        int indexOfLo = str.indexOf("lo");
        System.out.println("String lo at " + indexOfLo);

        // replace a substring with another string
        str = str.replace("World", "Universe");
        System.out.println(str);
    }

    /**
     * Use StringBuilder as dynamic string data structure.
     */
    private void stringBuilder() {

        StringBuilder builder = new StringBuilder();
        builder.append("Hello ");
        builder.append("world ");
        builder.append("once ");
        builder.append("more");

        System.out.println(builder.toString());

        // OK, but a bit boiler plate, short variant:
        builder = new StringBuilder(); // assign new instance to variable builder
        // no one line
        builder.append("Hello ").append("world ").append("once ").append("more");

        System.out.println(builder.toString());
        // just for fun, reverse output
        System.out.println(builder.reverse().toString());

        // Note: StringBuilder has an equivalent sister class named StringBuffer, this is a thread save variant of
        // StringBuilder. In most cases it is recommended to use StringBuilder instead of StringBuffer, StringBuffer has
        // a performance penalty caused by handling the thread safety.

    }
}
