package DAO;

import configuration.HibernateConnect;
import employees.Person;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nikita Philippov on 02.01.17.
 */
public class PersonDAO extends AbstractDAO {


    public void addPerson(Person person) throws SQLException {
        Session session = null;
        try {
            session = HibernateConnect.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.getMessage();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }



    public Person getEntityById(Long id) {
        Session session = null;
        Person person = null;
        try {
            session = HibernateConnect.getSessionFactory().openSession();
            session.beginTransaction();
            person = session.load(Person.class, id);


            session.getTransaction().commit();
        } catch (Throwable ex) {
            session.getTransaction().rollback();
            ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return person;
    }



    public Collection getAll() {
        Session session = null;
        Collection people = null;
        try {
            session = HibernateConnect.getSessionFactory().openSession();
            session.beginTransaction();
            CriteriaQuery<Person> criteriaQuery = session.getCriteriaBuilder().createQuery(Person.class);
            Root<Person> personRoot = criteriaQuery.from(Person.class);
            criteriaQuery.select(personRoot);
            people = session.createQuery(criteriaQuery).getResultList();
            session.getTransaction().commit();
        } catch (Throwable ex) {
            session.getTransaction().rollback();
            ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return people;
    }



    public Object update(Object entity) {
        return null;
    }

    public boolean delete(Object id) {
        return false;
    }

    public boolean create(Object entity) {
        return false;
    }
}
