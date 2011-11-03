/*
 * Java edcucation examples.
 *  
 * Source: https://github.com/nydi/java4edu
 */
package ch.nydi.j4edu.dbaccess.dao;

import ch.nydi.j4edu.dbaccess.model.Person;
import ch.nydi.j4edu.dbaccess.utils.SessionFactoryUtil;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hibernate implementation of {@link PersonDao}.
 * 
 * @author Daniel Nydegger
 */
public class PersonDaoHibernateImpl
    implements PersonDao {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertPerson(Person person) {
        Session session = getSession();
        // set the member number

        try {
            session.beginTransaction();

            person.setMemberNr(getNextMemberNumber());
            session.save(person);

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("database operation failed", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updatePerson(Person person) {
        Session session = getSession();

        try {
            session.beginTransaction();

            session.update(person);

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("database operation failed", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePerson(Person person) {
        Session session = getSession();

        try {
            session.beginTransaction();

            session.delete(person);

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("database operation failed", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getPerson(Long id) {
        Session session = getSession();
        try {
            session.beginTransaction();

            Person person = (Person) session.get(Person.class, id);

            session.getTransaction().commit();
            return person;

        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("database operation failed", e);
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    // hibernate criteria isn't type save
    @Override
    public List<Person> getAllPersons() {
        Session session = getSession();

        try {
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Person.class);
            List<Person> persons = criteria.list();

            session.getTransaction().commit();

            return persons;

        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("database operation failed", e);
        }

        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    // hibernate criteria isn't type save
    @Override
    public List<Person> getPersonsByLastname(String lastname) {
        Session session = getSession();

        try {
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Person.class);
            criteria.add(Restrictions.like("lastname", lastname));
            List<Person> persons = criteria.list();

            session.getTransaction().commit();

            return persons;

        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("database operation failed", e);
        }

        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getNextMemberNumber() {
        Session session = getSession();

        Query query = session.createSQLQuery("SELECT S_MEMBER.NEXTVAL AS NEXTVAL");
        Integer number = ((BigInteger) query.uniqueResult()).intValue();
        return number;
    }

    private Session getSession() {
        return SessionFactoryUtil.getInstance().getCurrentSession();
    }
}
