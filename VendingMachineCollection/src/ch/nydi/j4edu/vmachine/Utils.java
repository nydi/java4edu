package ch.nydi.j4edu.vmachine;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Helper class with static operations.
 */
public final class Utils {

    public static String formatMoney(final Double amount) {
        final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("de", "CH"));
        return numberFormat.format(amount);
    }
}
