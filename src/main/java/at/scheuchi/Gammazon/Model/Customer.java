package at.scheuchi.Gammazon.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
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
