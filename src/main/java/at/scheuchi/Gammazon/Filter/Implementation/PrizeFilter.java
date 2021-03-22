package at.scheuchi.Gammazon.Filter.Implementation;

import at.scheuchi.Gammazon.Filter.AbstractProductFilter;
import at.scheuchi.Gammazon.Filter.IFilter;
import at.scheuchi.Gammazon.Model.Product;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrizeFilter extends AbstractProductFilter {


    private int min;
    private int max;

    public PrizeFilter(IFilter<Product> child, Double min, Double max) {
        super(child);
        this.min = (int)(min*100);
        this.max = (int)(max*100);
    }

    @Override
    public Stream<Product> apply() {
        return child.apply().filter(p -> p.getPrice() > min && p.getPrice() < max);
    }

    @Override
    public Paragraph describeParams() {

        if(max == Double.MAX_VALUE)
            return new Paragraph("Min: %d".formatted(min));
        return new Paragraph("Min: %d Max: %d".formatted(min, max));
    }

}
