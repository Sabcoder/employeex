package starting;

import DAO.Factory;
import configuration.HibernateConnect;
import employees.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.Iterator;git config --global user.email "Ваш Email"
import java.util.List;

/**
 * Created by Nikita Philippov on 24.12.16.
 */
public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateConnect.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Person> result = null;
        Person singlePerson = null;
        String text = null;

        try {
            session.beginTransaction();
            result = (List) Factory.getInstance().getPersonDAO().getAll();
            Iterator iterator = result.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }


            /*
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // SELECT
            CriteriaQuery<Person> criteria = cb.createQuery(Person.class);
            Root<Person> personRoot = criteria.from(Person.class);
            criteria.select(personRoot);
            criteria.orderBy(cb.asc(personRoot.get("id")));
            result = session.createQuery(criteria).getResultList();
            criteria.where(cb.equal(personRoot.get("id"), "1"));
            text = session.createQuery(criteria).getSingleResult().getAddress();

            // UPDATE
            CriteriaUpdate criteriaUpdate = cb.createCriteriaUpdate(Person.class);
            Root employee = criteriaUpdate.from(Person.class);
            criteriaUpdate.set("address", "Томилино, улица Гаршина 9А");
            criteriaUpdate.where(cb.equal(employee.get("id"), "1"));
            Query query = session.createQuery(criteriaUpdate);
            query.executeUpdate();

            // INSERT
            Person newEmp = new Person();
            newEmp.setLeaderId("1");
            newEmp.setFirstName("Василий");
            newEmp.setFirstName("Василий");
            newEmp.setLastName("Астахов");
            newEmp.setId(3L);
            newEmp.setPassword("dwdw");
            session.save(newEmp);
            */


            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }


    }

}
