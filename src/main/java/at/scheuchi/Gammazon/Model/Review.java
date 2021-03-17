package at.scheuchi.Gammazon.Model;

import com.vaadin.flow.component.Component;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private int id;

    private int rating;

    private String title;

    private String text;

    @ManyToOne
    private Customer customer;


    public Review(int rating, String title, String text, Customer customer) {
        this.rating = rating;
        this.title = title;
        this.text = text;
        this.customer = customer;
    }
}
