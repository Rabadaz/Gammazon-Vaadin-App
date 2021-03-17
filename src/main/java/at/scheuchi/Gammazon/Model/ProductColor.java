package at.scheuchi.Gammazon.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ProductColor {
    @Id
    @GeneratedValue
    private int id;

    private String colorCode;

    private String colorName;

}
