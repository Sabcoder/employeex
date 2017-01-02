package employees;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita Philippov on 19.12.16.
 */
@Entity
@Table(name = "personal_cars")
public class PersonalCar extends DataModel {

    //Variables
    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @ManyToMany(mappedBy = "personalCars")
    private Set<Person> people = new HashSet<Person>();



    //Constructors



    //Getters & Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

}
