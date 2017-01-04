package DAO;

import configuration.HibernateConnect;
import employees.Company;
import employees.Person;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Nikita Philippov on 02.01.17.
 */
public class PersonDAO extends AbstractDAO {

// GET
    public Collection<Person> getAllEntities() {
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

    public Person getEntityById(Long id) {
        Session session = null;
        Person person = null;
        try {
            session = HibernateConnect.getSessionFactory().openSession();
            session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Person> query = cb.createQuery(Person.class);
            Root<Person> personRoot = query.from(Person.class);
            query.select(personRoot);
            query.where(cb.equal(personRoot.get("id"), id));
            person = session.createQuery(query).getSingleResult();

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

    public Collection<Person> getByCompany(Company company) {
        Session session = null;
        Collection<Person> people = null;

        try {
            session = HibernateConnect.getSessionFactory().openSession();
            session.beginTransaction();

            String hql = "select p from Company c join c.people p where c.id = :company_id";
            Query query = session.createQuery(hql);
            query.setParameter("company_id", company.getId());
            people = query.getResultList();

            session.getTransaction().commit();
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return people;
    }




// ADD
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
