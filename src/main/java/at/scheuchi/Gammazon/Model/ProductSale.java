package at.scheuchi.Gammazon.Model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class ProductSale {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Product product;
    @ManyToOne
    private Sale sale;
    private int count;


}
