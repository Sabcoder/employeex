package employees;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita Philippov on 19.12.16.
 */
@Entity
@Table(name = "personal_children")
public class PersonalChild extends DataModel {

    //Variables
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToMany(mappedBy = "personalChildren")
    private Set<Person> people = new HashSet<Person>();



    //Constructors



    //Getters & Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }
}
