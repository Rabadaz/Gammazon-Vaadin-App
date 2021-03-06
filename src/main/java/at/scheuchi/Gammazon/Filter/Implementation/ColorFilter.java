package at.scheuchi.Gammazon.Filter.Implementation;

import at.scheuchi.Gammazon.Filter.AbstractProductFilter;
import at.scheuchi.Gammazon.Filter.IFilter;
import at.scheuchi.Gammazon.Model.Product;
import at.scheuchi.Gammazon.Model.ProductColor;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ColorFilter extends AbstractProductFilter {
    private ProductColor color;

    public ColorFilter(IFilter<Product> child, ProductColor color) {
        super(child);
        this.color = color;
    }

    @Override
    public Stream<Product> apply() {
        return child.apply().filter(p -> p.getColor().equals(color));
    }

    @Override
    public Paragraph describeParams() {
        return new Paragraph("Color "+color.getColorName());
    }
}
