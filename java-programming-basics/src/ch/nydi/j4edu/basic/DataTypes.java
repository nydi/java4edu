/**
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 *
 * FileName    : DataTypes.java
 * Created on  : 21.05.2011
 * Created by  : Daniel Nydegger
 */
package ch.nydi.j4edu.basic;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Play with java data types.
 * 
 * @author Daniel Nydegger
 * @date 21.05.2011
 */
public class DataTypes {

    public static void main(String[] args) {
        tryPrimitives();
        tryWrappers();
        tryFormat();
    }

    /**
     * Play with primitive data types
     */
    private static void tryPrimitives() {

        // byte
        byte oneByte = 12;
        byte anotherByte = 2;
        // cast the result to byte
        byte sumByte = (byte) (oneByte + anotherByte);
        System.out.println(sumByte);

        // short
        short oneShort = 7001;
        short anotherShort = 10000;
        // cast the result to byte
        short diffShort = (short) (anotherShort - oneShort);
        System.out.println(diffShort);

        // char
        char oneCharacter = 'a';
        char anotherCharacter = 'b';
        // print both characters with concatenate
        System.out.println(oneCharacter);
        System.out.println(anotherCharacter);

        // but what happens by using the operator +
        char sumCharacter = (char) (oneCharacter + anotherCharacter);
        System.out.println(sumCharacter);

        // integer
        int oneInteger = 5;
        int anotherInteger = 500000;
        int productInteger = oneInteger * anotherInteger;
        System.out.println(productInteger);

        // but what happens if the product exceeds the data type bounds
        int oneMoreInteger = 300000;
        productInteger = anotherInteger * oneMoreInteger;
        System.out.println(productInteger);

        // long
        long oneLong = 9116893982398399867L; // we have to set the explicit data type with 'L' or 'l'
        long anotherLong = 2L;
        long diffLong = oneLong / anotherLong;
        System.out.println(diffLong);

        // lost precision
        int lostPrecision = (int) diffLong;
        System.out.println(lostPrecision);

        // float
        float oneFloat = 122.5F;
        float anotherFloat = 2F;
        float floatSum = oneFloat + anotherFloat;
        System.out.println(floatSum);

        // double
        double oneDouble = 232232198839318918391798861986392186312988.64724627647D;
        double anotherDouble = 2D;
        double doubleSum = oneDouble + anotherDouble;
        System.out.println(doubleSum);
    }

    /**
     * Play with wrapper classes for primitive data types.
     */
    private static void tryWrappers() {

        Integer oneInteger = new Integer(2);
        Integer anotherInteger = 23; // autoboxing a primitive integer

        Integer sumInteger = oneInteger + anotherInteger;
        System.out.println(sumInteger);

        // wrapper class feature example
        System.out.println("max int value: " + Integer.MAX_VALUE);
        System.out.println("min int value: " + Integer.MIN_VALUE);

        String elevenString = "11";
        Integer eleven = Integer.parseInt(elevenString);
        System.out.println(eleven);

        int twelve = 12;
        String twelveString = Integer.toString(twelve);

        System.out.println("Integers as Strings: " + elevenString + ", " + twelveString);
        // but remember, each object has a toString method, they are implemented for most Java API classes
        System.out.println("Integers as Integer Objects: " + eleven + ", " + twelve);

        // There are wrapper classes for all primitive data types, play with it to learn the features
        // Character has some nice methods, like
        char a = 'a';
        char nine = '9';

        System.out.println("is " + a + " a digit: " + Character.isDigit(a));
        System.out.println("is " + nine + " a digit: " + Character.isDigit(nine));
    }

    /**
     * Try formating classes
     */
    private static void tryFormat() {
        // example to parse a user input

        String pricePerUnitInput = "430.35";
        String amountInput = "3";

        Double pricePerUnit = Double.parseDouble(pricePerUnitInput);
        Integer amount = Integer.parseInt(amountInput);

        Double total = pricePerUnit * amount;
        System.out.println("Total: " + total); // well, it's not a nice output format

        // so use printf
        System.out.printf("Total wit printf: %5.2f", total);
        System.out.println();

        // or use NumberFormat
        NumberFormat numberFormat = new DecimalFormat("####0.00");
        System.out.println("Total with decimalformat: " + numberFormat.format(total));
        // the grouping characters are not usual for your country?
        numberFormat = new DecimalFormat("####0.00", new DecimalFormatSymbols(new Locale("de", "CH")));
        System.out.println("Total with decimalformat and symbols: " + numberFormat.format(total));

        // or use prepared DecimalFormat class for currency
        NumberFormat currencyConverter = DecimalFormat.getCurrencyInstance(new Locale("de", "CH"));
        System.out.println(currencyConverter.format(total));
    }

}
