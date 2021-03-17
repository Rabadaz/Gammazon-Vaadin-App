package at.scheuchi.Gammazon.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Collection;
import java.util.Date;

@Data
@Entity

@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue
    private int id;

    private Date saleDate;

    @OneToMany(mappedBy = "sale", fetch = FetchType.EAGER)
    private Collection<ProductSale> products;

    @ManyToOne
    private Customer customer;
}
