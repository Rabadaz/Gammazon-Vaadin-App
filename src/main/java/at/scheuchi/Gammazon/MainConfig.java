package at.scheuchi.Gammazon;

import at.scheuchi.Gammazon.Filter.FilterableList;
import at.scheuchi.Gammazon.Filter.Implementation.ColorFilter;
import at.scheuchi.Gammazon.Filter.Implementation.PrizeFilter;
import org.hibernate.mapping.Filterable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("at.scheuchi.Gammazon.*")
public class MainConfig {

}
