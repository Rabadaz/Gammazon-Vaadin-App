package at.scheuchi.Gammazon.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="UserAccount")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @OneToOne
    private Customer customer;

}
