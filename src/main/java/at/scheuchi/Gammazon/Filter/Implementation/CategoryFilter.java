package at.scheuchi.Gammazon.Filter.Implementation;

import at.scheuchi.Gammazon.Filter.AbstractProductFilter;
import at.scheuchi.Gammazon.Filter.IFilter;
import at.scheuchi.Gammazon.Model.Product;
import at.scheuchi.Gammazon.Model.ProductCategory;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;

import java.util.stream.Stream;

public class CategoryFilter extends AbstractProductFilter {
    private ProductCategory category;

    public CategoryFilter(IFilter<Product> child, ProductCategory category) {
        super(child);
        this.category = category;
    }

    @Override
    public Stream<Product> apply() {
        return child.apply().filter(p -> p.getCategory().equals(category));
    }

    @Override
    public Paragraph describeParams() {
        return new Paragraph("Category: "+category.getCategoryName());
    }
}
