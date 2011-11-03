/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.dbaccess.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Simple database setup class.
 * 
 * @author Daniel Nydegger
 */
public final class DatabaseSetup {

    private final String driverName;
    private final String username;
    private final String password;
    private final String url;

    /**
     * @param username
     *            database user name
     * @param password
     *            database password
     * @param url
     *            database connection string
     */
    public DatabaseSetup(String driverName, String username, String password, String url) {
        this.driverName = driverName;
        this.username = username;
        this.password = password;
        this.url = url;
        init();
    }

    private void init() {
        try {
            Class.forName(driverName);
        } catch (final Exception e) {
            throw new IllegalStateException("Initalizing database driver failed, interupt startup", e);
        }
    }

    public Connection getConnection()
        throws Exception {
        return DriverManager.getConnection(url, username, password);
    }

    // *** static helper methods ***

    public static final String convertBoolean(final Boolean bool) {
        if (bool) {
            return "1";
        }
        return "0";
    }

    public static final String encloseWithQuotes(final String str) {
        return "'" + str + "'";
    }

    public static final String formatDate(Date date) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static final Date parseDate(String date)
        throws ParseException {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(date);
    }
}
