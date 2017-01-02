package employees;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita Philippov on 19.12.16.
 */
@Entity
@Table(name = "departments")
public class Department extends DataModel {


    // Variables
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "departments")
    private Set<Person> people = new HashSet<Person>();



    // Constructors



    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

}
