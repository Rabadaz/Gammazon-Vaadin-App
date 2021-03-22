package at.scheuchi.Gammazon.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(exclude = {"user"})
public class Customer{
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "customer")
    private User user;

    private String firstName;
    private String lastNamme;


    public String createFullName(){
        return firstName + " " + lastNamme;
    }
}
