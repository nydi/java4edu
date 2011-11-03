/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.dbaccess.dao;

import static ch.nydi.j4edu.dbaccess.utils.DatabaseSetup.convertBoolean;
import static ch.nydi.j4edu.dbaccess.utils.DatabaseSetup.encloseWithQuotes;
import static ch.nydi.j4edu.dbaccess.utils.DatabaseSetup.formatDate;
import ch.nydi.j4edu.dbaccess.model.Person;
import ch.nydi.j4edu.dbaccess.utils.DatabaseSetup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple {@link PersonDao} JDBC implementation.
 * 
 * @author Daniel Nydegger
 */
public class PersonDaoJDBCImpl
    implements PersonDao {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final DatabaseSetup databaseSetup;
    private static final String SELECT_BODY =
        "SELECT ID, ACTIV, BIRTHDAY, FIRSTNAME, LASTNAME, LOCKVERSION, MEMBERNR FROM DBBASIC.PERSON ";

    /**
     * @param databaseSetup
     *            database setup class
     */
    public PersonDaoJDBCImpl(DatabaseSetup databaseSetup) {
        this.databaseSetup = databaseSetup;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertPerson(Person person) {
        // Insert a new row in the person table
        // S_PERSON.NEXTVAL gets new value to insert an id

        // build the query
        final StringBuilder sqlStatement = new StringBuilder();

        final Long personId = getNextSequenceNumber("S_PERSON");

        sqlStatement.append("INSERT INTO DBBASIC.PERSON (ID,ACTIV,BIRTHDAY,FIRSTNAME,LASTNAME,MEMBERNR) VALUES (");

        sqlStatement.append(personId);
        sqlStatement.append(",");
        sqlStatement.append(encloseWithQuotes(convertBoolean(person.getActiv())));
        sqlStatement.append(",");
        if (null == person.getBirthday()) {
            sqlStatement.append("null");
        } else {
            sqlStatement.append(encloseWithQuotes(formatDate(person.getBirthday())));
        }
        sqlStatement.append(",");
        sqlStatement.append(encloseWithQuotes(person.getFirstname()));
        sqlStatement.append(",");
        sqlStatement.append(encloseWithQuotes(person.getLastname()));
        sqlStatement.append(",");
        // insert nextval of S_MEMBER for unique member number
        // sqlStatement.append("S_MEMBER.NEXTVAL)"); // alternative to use sequence inline
        Integer memberNr = getNextMemberNumber();
        sqlStatement.append(memberNr);
        sqlStatement.append(")");

        final Integer rowCount = executeUpdate(sqlStatement.toString());

        person.setId(personId);
        person.setMemberNr(memberNr);

        logger.info("value of row count: {}", rowCount);
        logger.info("Person inserted: {}", person.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updatePerson(Person person) {
        // updates the common data of person, id and member number are immutable

        // build the query
        final StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE DBBASIC.PERSON SET ");

        sqlStatement.append("ACTIV=");
        sqlStatement.append(encloseWithQuotes(convertBoolean(person.getActiv())));
        sqlStatement.append(",BIRTHDAY=");
        if (null == person.getBirthday()) {
            sqlStatement.append("null");
        } else {
            sqlStatement.append(encloseWithQuotes(formatDate(person.getBirthday())));
        }
        sqlStatement.append(",FIRSTNAME=");
        sqlStatement.append(encloseWithQuotes(person.getFirstname()));
        sqlStatement.append(",LASTNAME=");
        sqlStatement.append(encloseWithQuotes(person.getLastname()));
        // set where clause by id
        sqlStatement.append(" WHERE ID=").append(person.getId());

        executeUpdate(sqlStatement.toString());

        logger.info("Person updated: {}", person.toString());

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePerson(Person person) {
        // build the query
        final StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("DELETE FROM DBBASIC.PERSON WHERE id=").append(person.getId());
        executeUpdate(sqlStatement.toString());

        logger.info("Person deleted: {}", person.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getPerson(Long id) {

        List<Person> result = executeQuery("WHERE ID=" + id);
        if (result.size() > 0) {
            return result.get(0);
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Person> getAllPersons() {
        return executeQuery("");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Person> getPersonsByLastname(String lastname) {
        return executeQuery("WHERE LASTNAME LIKE '%" + lastname + "%'");
    }

    private List<Person> executeQuery(String clause) {

        Connection connection = null;
        Statement stmt = null;

        List<Person> results = new ArrayList<Person>();
        try {
            connection = databaseSetup.getConnection();
            stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery(SELECT_BODY + clause);

            while (resultSet.next()) {
                results.add(mapResultSetEntry(resultSet));
            }

        } catch (Exception e) {
            throw new DatabaseException("executeQuery failed", e);
        }
        finally {
            try {
                if (null != stmt) {
                    stmt.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (final SQLException e) {
                logger.error("close connection failed", e);
            }
        }

        return results;
    }

    private Integer executeUpdate(String sqlStatement) {

        Connection connection = null;
        Statement stmt = null;

        try {
            connection = databaseSetup.getConnection();
            stmt = connection.createStatement();

            return stmt.executeUpdate(sqlStatement);

        } catch (final Exception e) {
            throw new DatabaseException("executeUpdate person failed", e);
        }
        finally {
            try {
                if (null != stmt) {
                    stmt.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (final SQLException e) {
                logger.error("close connection failed", e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getNextMemberNumber() {
        return Integer.parseInt(Long.toString(getNextSequenceNumber("S_MEMBER")));
    }

    public Long getNextSequenceNumber(String sequenceName) {
        Connection connection = null;
        Statement stmt = null;
        try {
            connection = databaseSetup.getConnection();
            stmt = connection.createStatement();

            // build the query
            final StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append("SELECT ").append(sequenceName).append(".NEXTVAL AS NEXTVAL");
            ResultSet resultSet = stmt.executeQuery(sqlStatement.toString());
            if (resultSet.next()) {
                return resultSet.getLong("NEXTVAL");
            }
        } catch (Exception e) {
            throw new DatabaseException("getNextSequenceNumber person failed", e);
        }
        finally {
            try {
                if (null != stmt) {
                    stmt.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (final SQLException e) {
                logger.error("close connection failed", e);
            }
        }

        return null;
    }

    private Person mapResultSetEntry(ResultSet resultSet) {
        Person person = new Person();

        try {
            person.setId(resultSet.getLong("ID"));
            person.setActiv(resultSet.getBoolean("ACTIV"));
            person.setBirthday(DatabaseSetup.parseDate(resultSet.getString("BIRTHDAY")));
            person.setFirstname(resultSet.getString("FIRSTNAME"));
            person.setLastname(resultSet.getString("LASTNAME"));
            person.setMemberNr(resultSet.getInt("MEMBERNR"));
            return person;

        } catch (Exception e) {
            logger.error("map entry failed", e);
            return null;
        }
    }
}
