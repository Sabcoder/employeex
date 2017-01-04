package starting;

import DAO.Factory;
import employees.Company;
import employees.Person;
import java.util.List;

/**
 * Created by Nikita Philippov on 24.12.16.
 */
public class Main {

    public static void main(String[] args) throws Exception {



        Company company;
        company = Factory.getInstance().getCompanyDAO().getEntityById(1L);

        Person newEmp = new Person();
        newEmp.setLeaderId("1");
        newEmp.setFirstName("Виктория");
        newEmp.setLastName("Филиппова");
        newEmp.setPassword("123456");
        newEmp.setInternalPhoneNumber("11199");
        newEmp.getCompanies().add(company);

        Factory.getInstance().getPersonDAO().addPerson(newEmp);



        List<Person> people;
        people = (List<Person>) Factory.getInstance().getPersonDAO().getByCompany(company);
        for (Person person : people) {
            System.out.println(person);
        }




    }
}
