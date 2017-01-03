package DAO;

import configuration.HibernateConnect;
import employees.Company;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by Nikita Philippov on 03.01.17.
 */
public class CompanyDAO extends AbstractDAO {


    public Company getEntityById(Long id) {
        Session session = null;
        Company company = null;
        try {
            session = HibernateConnect.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Company where id = :id");
            query.setParameter("id", id);
            company = (Company) query.getSingleResult();
            session.getTransaction().commit();
        } catch (Throwable ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return company;
    }





    //TODO
    public Collection getAllEntities() {
        return null;
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
