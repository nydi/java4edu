/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.io.stockfile;

import java.util.List;

/**
 * @author Daniel Nydegger
 */
public class StockFileReaderTest {

    public static void main(final String[] args) {
        final StockFileReader reader = new StockFileReader();
        final List<StockValue> stockValues = reader.readStockFile("data/stockvalues.csv");

        for (final StockValue stockValue : stockValues) {
            System.out.println(stockValue.toString());
        }

    }
}
