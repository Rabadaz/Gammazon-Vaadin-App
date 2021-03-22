package at.scheuchi.Gammazon.Model;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

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

    @ManyToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<GrantedPermission> authorities;

}
