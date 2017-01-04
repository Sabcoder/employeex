package starting;

import DAO.Factory;
import configuration.HibernateConnect;
import employees.Company;
import employees.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nikita Philippov on 24.12.16.
 */
public class Main {

    public static void main(String[] args) throws Exception {



        Company company;
        company = Factory.getInstance().getCompanyDAO().getEntityById(1L);

        Person newEmp = new Person();
        newEmp.setLeaderId("4");
        newEmp.setFirstName("Anastasiia");
        newEmp.setLastName("Philippova");
        newEmp.setPassword("123456");
        newEmp.setInternalPhoneNumber("11199");
        newEmp.getCompanies().add(company);

//        Factory.getInstance().getPersonDAO().addPerson(newEmp);



        List<Person> people;
        people = (List<Person>) Factory.getInstance().getPersonDAO().getByCompany(company);
        for (Person person : people) {
            System.out.println(person);
        }




    }
}
