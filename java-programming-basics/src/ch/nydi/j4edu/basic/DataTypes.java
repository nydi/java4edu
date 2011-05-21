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

/**
 * Play with java data types.
 * 
 * @author Daniel Nydegger
 * @date 21.05.2011
 */
public class DataTypes {

    public static void main(String[] args) {
        tryPrimitives();
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

}
