package employees;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita Philippov on 20.12.16.
 */
@Entity
@Table(name = "lighthouse_reward")
public class LighthouseReward extends DataModel {

    //Variables
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private LighthouseTypes type;

    @Column(name = "votes")
    private int votes;

    @Column(name = "period") // month+year
    private Date period;

    @ManyToMany(mappedBy = "lighthouseRewards")
    private Set<Person> people = new HashSet<Person>();



    //Constructors



    //Getters & Setters
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

    public LighthouseTypes getType() {
        return type;
    }

    public void setType(LighthouseTypes type) {
        this.type = type;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }
}
