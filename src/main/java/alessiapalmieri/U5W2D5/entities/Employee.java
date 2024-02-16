package alessiapalmieri.U5W2D5.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String avatarURL;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Device> deviceList;

    public Employee(String username, String name, String lastname, String email) {
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }
}
