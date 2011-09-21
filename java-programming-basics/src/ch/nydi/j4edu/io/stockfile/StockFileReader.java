/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.io.stockfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Daniel Nydegger
 */
public class StockFileReader {

    /**
     * Reads each line of a file and builds a list of {@link StockValue} objects.
     * 
     * @param pathToFile
     *            path to file
     * @return list of stocks
     */
    public List<StockValue> readStockFile(final String pathToFile) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(pathToFile));
            final List<StockValue> stockList = new ArrayList<StockValue>();

            String input;
            while ((input = reader.readLine()) != null) {
                // usage of parseLine(...)
                stockList.add(parseLine(input));
            }

            return stockList;

        } catch (final Exception e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
        finally {
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (final IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Parses a line of the stock value file and creates a {@link StockValue} Object.
     * 
     * @param line
     *            line of the stock value file
     * @return {@link StockValue} object
     */
    private StockValue parseLine(final String line) {

        final Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");

        int position = 0;
        final StockValue stockValue = new StockValue();
        while (scanner.hasNext()) {
            final String str = scanner.next();
            if (0 == position) {
                stockValue.setName(str);
            } else if (1 == position) {
                stockValue.setValue(Double.parseDouble(str));
            }
            position++;
        }
        return stockValue;
    }
}
