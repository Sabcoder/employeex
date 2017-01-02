package employees;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita Philippov on 21.12.16.
 */
@Entity
@Table(name = "schedules")
public class Schedule extends DataModel {


    //Variables
    @OneToMany(mappedBy = "schedule")
    private Set<Person> people = new HashSet<Person>();



    //Constructors



    //Getters & Setters
    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

}

