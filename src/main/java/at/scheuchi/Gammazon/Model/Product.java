package at.scheuchi.Gammazon.Model;

import com.vaadin.flow.component.Component;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.awt.*;
import java.util.Collection;
import java.util.LinkedList;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String description;

    private String pictureUrl;

    /**
     * Prize represented in Cents -- 100 -> 1€
     */
    private int price;

    private boolean inStock;

    private int deliveryDays;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Review> reviews;

    @ManyToOne
    private ProductCategory category;

    @ManyToMany
    private Collection<Tag> tags;

    @ManyToOne
    private ProductColor color;
}
