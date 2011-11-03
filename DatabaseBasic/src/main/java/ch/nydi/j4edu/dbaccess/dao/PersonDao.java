/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.dbaccess.dao;

import ch.nydi.j4edu.dbaccess.model.Person;

import java.util.List;

/**
 * Data access object for the Person entity.
 * 
 * @author Daniel Nydegger
 */
public interface PersonDao {

    /**
     * Inserts a person in the database.
     * 
     * @param person
     *            person to save
     */
    void insertPerson(Person person);

    /**
     * Updates a person.
     * 
     * @param person
     *            person
     */
    void updatePerson(Person person);

    /**
     * Deletes a person.
     * 
     * @param person
     *            person
     */
    void deletePerson(Person person);

    /**
     * Gets a person by id.
     * 
     * @param id
     *            id of person
     * @return retrieved person or null if the id doesn't exists
     */
    Person getPerson(Long id);

    /**
     * @return all Person entries as list or an empty list if no persons retrieved
     */
    List<Person> getAllPersons();

    /**
     * Gets all persons with the same lastname.
     * 
     * @param lastname
     *            lastname
     * @return list of persons with the same lastname or an empty list
     */
    List<Person> getPersonsByLastname(String lastname);

    /**
     * @return next available person member number
     */
    Integer getNextMemberNumber();
}
