package at.scheuchi.Gammazon.Service;

import at.scheuchi.Gammazon.Model.Customer;
import at.scheuchi.Gammazon.Model.Product;
import at.scheuchi.Gammazon.Model.ProductSale;
import at.scheuchi.Gammazon.Model.Sale;
import at.scheuchi.Gammazon.Repository.ProductSaleRepository;
import at.scheuchi.Gammazon.Repository.SaleRepository;
import at.scheuchi.Gammazon.Util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class BuyService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductSaleRepository productSaleRepository;


    public Sale buyProduct(Product product, int count){
        Sale s = new Sale();
        Customer c = UserUtils.getUserPrinciple().getUser().getCustomer();
        s.setSaleDate(new Date());
        s.setCustomer(c);
        s = saleRepository.save(s);

        ProductSale ps = new ProductSale();
        ps.setProduct(product);
        ps.setCount(count);
        ps.setSale(s);
        productSaleRepository.save(ps);

        return saleRepository.save(s);

    }

}
