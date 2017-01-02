package employees;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita Philippov on 20.12.16.
 */
@Entity
@Table(name = "roles")
public class Role extends DataModel {


    //Variables
    @Column(name = "role_name", nullable = false)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<Person> people = new HashSet<Person>();



    //Constructors



    //Getters & Setters
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

}
