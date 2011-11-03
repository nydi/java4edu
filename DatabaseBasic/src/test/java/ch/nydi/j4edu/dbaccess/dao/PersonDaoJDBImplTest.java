/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.dbaccess.dao;

import ch.nydi.j4edu.dbaccess.model.Person;
import ch.nydi.j4edu.dbaccess.utils.DatabaseSetup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the methods of {@link PersonDaoJDBCImpl}.
 * 
 * @author Daniel Nydegger
 */
public class PersonDaoJDBImplTest {

    private final String driverName = "org.h2.Driver";
    private final String username = "sa";
    private final String password = "";
    private final String url = "jdbc:h2:tcp://localhost/~/DB/EDU/DBBASICS;SCHEMA_SEARCH_PATH=DBBASICS";

    // static holder list to save the id's to delete, not th way to do it, but it works ;-)
    private static List<Long> idsToDelete = new ArrayList<Long>();

    /**
     * Test method for
     * {@link ch.nydi.j4edu.dbaccess.dao.PersonDaoJDBCImpl#insertPerson(ch.nydi.j4edu.dbaccess.model.Person)}.
     */
    @Test
    public void testInsertPerson() {

        DatabaseSetup databaseSetup = new DatabaseSetup(driverName, username, password, url);
        PersonDao personDao = new PersonDaoJDBCImpl(databaseSetup);

        Person person =
            TestPersonFactory.createPerson("Roger", "Schnaller", true, new GregorianCalendar(1980, Calendar.FEBRUARY,
                14));

        personDao.insertPerson(person);

        // assertions
        Assert.assertNotNull("id of person is null", person.getId());
        Assert.assertNotNull("member nr of person is null", person.getMemberNr());

        idsToDelete.add(person.getId());
    }

    /**
     * Test method for
     * {@link ch.nydi.j4edu.dbaccess.dao.PersonDaoJDBCImpl#updatePerson(ch.nydi.j4edu.dbaccess.model.Person)}.
     */
    @Test
    public void testUpdatePerson() {

        // insert person
        DatabaseSetup databaseSetup = new DatabaseSetup(driverName, username, password, url);
        PersonDao personDao = new PersonDaoJDBCImpl(databaseSetup);

        Person person =
            TestPersonFactory.createPerson("Andrea", "Keller", false,
                new GregorianCalendar(1986, Calendar.DECEMBER, 23));

        personDao.insertPerson(person);
        idsToDelete.add(person.getId());

        // update the person
        person.setActiv(true);
        person.setFirstname("Sonja");
        personDao.updatePerson(person);

        // assertions
        // reread from database
        person = personDao.getPerson(person.getId());
        Assert.assertEquals("Firstname isn't Sonja", "Sonja", person.getFirstname());
        Assert.assertEquals("Status isn't activ", Boolean.TRUE, person.getActiv());
    }

    /**
     * Test method for
     * {@link ch.nydi.j4edu.dbaccess.dao.PersonDaoJDBCImpl#deletePerson(ch.nydi.j4edu.dbaccess.model.Person)}.
     */
    @Test
    public void testDeletePerson() {
        // insert person
        DatabaseSetup databaseSetup = new DatabaseSetup(driverName, username, password, url);
        PersonDao personDao = new PersonDaoJDBCImpl(databaseSetup);

        Person person =
            TestPersonFactory.createPerson("Werner", "Akinopa", false, new GregorianCalendar(1959, Calendar.JULY, 3));

        personDao.insertPerson(person);

        // delete person
        personDao.deletePerson(person);

        // assertions
        // reread from database
        person = personDao.getPerson(person.getId());
        Assert.assertNull("Person still exists", person);
    }

    /**
     * Test method for {@link ch.nydi.j4edu.dbaccess.dao.PersonDaoJDBCImpl#getPerson(java.lang.Long)}.
     */
    @Test
    public void testGetPerson() {
        // insert person
        DatabaseSetup databaseSetup = new DatabaseSetup(driverName, username, password, url);
        PersonDao personDao = new PersonDaoJDBCImpl(databaseSetup);

        Person person =
            TestPersonFactory.createPerson("Rolf", "Keller", true, new GregorianCalendar(1985, Calendar.MAY, 13));

        personDao.insertPerson(person);
        idsToDelete.add(person.getId());

        // get the person
        Person personFromDatabase = personDao.getPerson(person.getId());

        // assertions
        Assert.assertNotNull("person not found in database", personFromDatabase);
        Assert.assertEquals("id is not equals", person.getId(), personFromDatabase.getId());
    }

    /**
     * Test method for {@link ch.nydi.j4edu.dbaccess.dao.PersonDaoJDBCImpl#getAllPersons()}.
     */
    @Test
    public void testGetAllPersons() {
        DatabaseSetup databaseSetup = new DatabaseSetup(driverName, username, password, url);
        PersonDao personDao = new PersonDaoJDBCImpl(databaseSetup);

        List<Person> persons = personDao.getAllPersons();

        // assertions
        Assert.assertNotNull("Person list is null", personDao);
        Assert.assertFalse("Person list is empty", persons.isEmpty());
    }

    /**
     * Test method for {@link ch.nydi.j4edu.dbaccess.dao.PersonDaoJDBCImpl#getPersonsByLastname(java.lang.String)}.
     */
    @Test
    public void testGetPersonsByLastname() {
        DatabaseSetup databaseSetup = new DatabaseSetup(driverName, username, password, url);
        PersonDao personDao = new PersonDaoJDBCImpl(databaseSetup);

        List<Person> persons = personDao.getPersonsByLastname("Keller");

        // assertions
        Assert.assertNotNull("Person list is null", personDao);
        Assert.assertFalse("Person list is empty", persons.isEmpty());
    }

    @Test
    public void testDeleteAllEntries() {

        DatabaseSetup databaseSetup = new DatabaseSetup(driverName, username, password, url);
        PersonDao personDao = new PersonDaoJDBCImpl(databaseSetup);

        for (Long idToDelete : idsToDelete) {
            Person person = personDao.getPerson(idToDelete);
            personDao.deletePerson(person);
        }
    }
}
