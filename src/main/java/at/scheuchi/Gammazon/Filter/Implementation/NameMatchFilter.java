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

public class NameMatchFilter extends AbstractProductFilter {

    private String namePart;

    public NameMatchFilter(IFilter<Product> child, String namePart) {
        super(child);
        this.namePart = namePart;
    }

    @Override
    public Stream<Product> apply() {
        return child.apply().filter(c -> c.getTitle().contains(namePart));
    }

    @Override
    public Paragraph describeParams() {
       return new Paragraph("Name: "+ namePart);
    }
}
