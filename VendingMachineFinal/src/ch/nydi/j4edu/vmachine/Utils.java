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

    public static String formatMoney(final Double amount) {
        final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("de", "CH"));
        return numberFormat.format(amount);
    }
}
