package employees;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita Philippov on 19.12.16.
 */
@Entity
@Table(name = "employees")
public class Person extends DataModel {

    // Profile
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "photo")
    private String photoFilename;

    @ManyToMany
    @JoinTable(name = "employee_roles",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<Role>();

    @ManyToMany
    @JoinTable(name = "employee_lighthouse_rewards",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "lighthouse_reward_id")})
    private Set<LighthouseReward> lighthouseRewards;


    // Organization structure
    @Column(name = "employment_date")
    private Date employmentDate;

    @Column(name = "dismissal_date")
    private Date dismissalDate;

    @ManyToMany
    @JoinTable(name = "employee_companies",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "company_id")})
    private Set<Company> companies = new HashSet<Company>();

    @ManyToMany
    @JoinTable(name = "employee_departments",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "department_id")})
    private Set<Department> departments = new HashSet<Department>();

    @ManyToMany
    @JoinTable(name = "employee_positions",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "position_id")})
    private Set<Position> positions = new HashSet<Position>();

    @Column(name = "leader")
    private String leaderId;

    @ManyToMany
    @JoinTable(name = "employee_subordinates",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "subordinate_id")})
    private Set<Person> subordinates = new HashSet<Person>();

    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    private Schedule schedule;


    // Contacts
    @Column(name = "work_email")
    private String workEmail;

    @Column(name = "personal_email")
    private String personalEmail;

    @Column(name = "internal_phone_number")
    private String internalPhoneNumber;

    @Column(name = "work_cellphone")
    private String workCellphone;

    @Column(name = "personal_cellphone")
    private String personalCellphone;

    @Column(name = "address")
    private String address;


    // Personal information;
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birthday")
    private Date birthday;

    @ManyToMany
    @JoinTable(name = "employee_personal_cars",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "personal_car_id")})
    private Set<PersonalCar> personalCars = new HashSet<PersonalCar>();

    @ManyToMany
    @JoinTable(name = "employee_children",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "child_id")})
    private Set<PersonalChild> personalChildren = new HashSet<PersonalChild>();



    //Constructors
    public Person() {

    }



    //Getters & Setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoFilename() {
        return photoFilename;
    }

    public void setPhotoFilename(String photoFilename) {
        this.photoFilename = photoFilename;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<LighthouseReward> getLighthouseRewards() {
        return lighthouseRewards;
    }

    public void setLighthouseRewards(Set<LighthouseReward> lighthouseRewards) {
        this.lighthouseRewards = lighthouseRewards;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Date getDismissalDate() {
        return dismissalDate;
    }

    public void setDismissalDate(Date dismissalDate) {
        this.dismissalDate = dismissalDate;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public Set<Person> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Person> subordinates) {
        this.subordinates = subordinates;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getInternalPhoneNumber() {
        if (internalPhoneNumber == null)
            return "[внутренный добавочный номер телефона не указан]";
        else
            return internalPhoneNumber;
    }

    public void setInternalPhoneNumber(String internalPhoneNumber) {
        this.internalPhoneNumber = internalPhoneNumber;
    }

    public String getWorkCellphone() {
        if (workCellphone == null)
            return "[рабочий мобильный телефон не указан]";
        else
            return workCellphone;
    }

    public void setWorkCellphone(String workCellphone) {
        this.workCellphone = workCellphone;
    }

    public String getPersonalCellphone() {
        if (personalCellphone == null)
            return "[личный мобильный телефон не указан]";
        else
            return personalCellphone;
    }

    public void setPersonalCellphone(String personalCellphone) {
        this.personalCellphone = personalCellphone;
    }

    public String getAddress() {
        if (address == null)
            return "[адрес не указан]";
        else
            return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        if (firstName == null)
            return "[имя не указано]";
        else
            return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        if (secondName == null)
            return "[отчество не указано]";
        else
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        if (lastName == null)
            return "[фамилия не указана]";
        else
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
            return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<PersonalCar> getPersonalCars() {
        return personalCars;
    }

    public void setPersonalCars(Set<PersonalCar> personalCars) {
        this.personalCars = personalCars;
    }

    public Set<PersonalChild> getPersonalChildren() {
        return personalChildren;
    }

    public void setPersonalChildren(Set<PersonalChild> personalChildren) {
        this.personalChildren = personalChildren;
    }



    //Methods
    @Override
    public String toString() {
        return String.format("ID: %s - %s %s %s", this.getId(), this.getLastName(), this.getFirstName(), this.getSecondName());
    }
}
