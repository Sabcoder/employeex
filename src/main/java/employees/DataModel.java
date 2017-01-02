package employees;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Nikita Philippov on 24.12.16.
 */
@MappedSuperclass
public abstract class DataModel implements Serializable {
    public static final long serialVersionUID = -40294827598756L;

    //Variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;



    //Constructors
    public DataModel() {

    }



    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
