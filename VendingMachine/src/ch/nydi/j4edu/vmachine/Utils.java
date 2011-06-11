/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.vmachine;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Helper class with static operations.
 * 
 * @author Daniel Nydegger
 */
public final class Utils {

    public static int getNotNullAmount(final Object[] arr) {
        int notNullValues = 0;
        for (int i = 0; i < arr.length; i++) {
            if (null != arr[i]) {
                notNullValues++;
            }
        }
        return notNullValues;
    }

    public static Object getFirstNotNullValue(final Object[] arr) {
        if (0 == getNotNullAmount(arr)) {
            return null;
        }

        for (int i = (arr.length - 1); i >= 0; --i) {
            if (null != arr[i]) {
                final Object retVal = arr[i];
                arr[i] = null;
                return retVal;
            }
        }
        return null;
    }

    public static boolean replaceFirstNullValue(final Object[] arr, final Object object) {
        if (arr.length == getNotNullAmount(arr)) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (null == arr[i]) {
                arr[i] = object;
                return true;
            }
        }
        return false;
    }

    public static String formatMoney(final Double amount) {
        final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("de", "CH"));
        return numberFormat.format(amount);
    }
}
