package employees;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita Philippov on 20.12.16.
 */
@Entity
@Table(name = "companies")
public class Company extends DataModel {

    //Variables
    @Column(name = "legal_form", nullable = false)
    private String legalForm;

    @Column(name = "legal_name", nullable = false)
    private String legalName;

    @Column(name = "full_brand_name")
    private String fullBrandName;

    @Column(name = "short_brand_name")
    private String shortBrandName;

    @Column(name = "brand")
    private String brand;

    @Column(name = "legal_address")
    private String legalAddress;

    @Column(name = "fact_address")
    private String factAddress;

    @Column(name = "description")
    private String description;

    // payment information
    @Column(name = "inn")
    private String inn;

    @Column(name = "kpp")
    private String kpp;



    @ManyToMany(mappedBy = "companies")
    private Set<Person> people = new HashSet<Person>();





    //Constructors



    //Getters & Setters
    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getFullBrandName() {
        return fullBrandName;
    }

    public void setFullBrandName(String fullBrandName) {
        this.fullBrandName = fullBrandName;
    }

    public String getShortBrandName() {
        return shortBrandName;
    }

    public void setShortBrandName(String shortBrandName) {
        this.shortBrandName = shortBrandName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLegalAddress() {
        return legalAddress;
    }

    public void setLegalAddress(String legalAddress) {
        this.legalAddress = legalAddress;
    }

    public String getFactAddress() {
        return factAddress;
    }

    public void setFactAddress(String factAddress) {
        this.factAddress = factAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

}
