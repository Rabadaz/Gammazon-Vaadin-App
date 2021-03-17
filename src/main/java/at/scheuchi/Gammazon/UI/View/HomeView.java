package at.scheuchi.Gammazon.UI.View;

import at.scheuchi.Gammazon.Filter.AbstractProductFilter;
import at.scheuchi.Gammazon.Filter.FilterableList;
import at.scheuchi.Gammazon.Filter.IFilter;
import at.scheuchi.Gammazon.Filter.Implementation.ColorFilter;
import at.scheuchi.Gammazon.Filter.Implementation.NameMatchFilter;
import at.scheuchi.Gammazon.Filter.Implementation.PrizeFilter;
import at.scheuchi.Gammazon.GammazonApplication;
import at.scheuchi.Gammazon.Model.Product;
import at.scheuchi.Gammazon.Model.ProductColor;
import at.scheuchi.Gammazon.Repository.ProductColorRepository;
import at.scheuchi.Gammazon.Repository.ProductRepository;
import at.scheuchi.Gammazon.UI.Layout.MainLayout;
import at.scheuchi.Gammazon.UI.View.Components.FilterComponents.ColorFilterComponent;
import at.scheuchi.Gammazon.UI.View.Components.FilterComponents.NameMatchFilterComponent;
import at.scheuchi.Gammazon.UI.View.Components.FilterComponents.PrizeFilterComponent;
import at.scheuchi.Gammazon.UI.View.Components.ProductTile;
import at.scheuchi.Gammazon.UI.View.Components.RatingStars.MyRatingStars;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@PageTitle("Ɣ-zon")
@Route(value = "", layout = MainLayout.class)
public class HomeView extends HorizontalLayout {
    private final FilterableList<Product> productFilterableList;

    private IFilter<Product> filterStack;
    private TreeGrid<IFilter<Product>> filterTree = new TreeGrid<>();
    public HomeView(ProductRepository productRepository, ProductColorRepository colorRepository){

        productFilterableList = new FilterableList<>(productRepository.findAll());
        filterStack = productFilterableList;

        VerticalLayout products = new VerticalLayout();
        VerticalLayout filters = new VerticalLayout();

        Button clearFilters = new Button("Clear Filters");
        clearFilters.addClickListener((buttonClickEvent -> {filterStack = productFilterableList; refresh(products);}));



        filterTree.setItems(List.of(filterStack), productIFilter -> productIFilter.getChild() == null? List.of() : List.of(productIFilter.getChild()));
        filterTree.addComponentHierarchyColumn(filter -> {
            return new Span(filter.getClass().getSimpleName());
        });

        filters.add(
                clearFilters
                ,new ColorFilterComponent(colorRepository, (color) -> {filterStack = new ColorFilter(filterStack, color); refresh(products);})
                ,new NameMatchFilterComponent((nameMatch) -> { filterStack = new NameMatchFilter(filterStack,nameMatch); refresh(products); })
                ,new PrizeFilterComponent((min, max) -> {filterStack = new PrizeFilter(filterStack, min, max);  refresh(products);}),
                filterTree
                );
        filters.setWidth("15vw");

        filterStack.apply().forEach(p -> products.add(new ProductTile(p)));

        add(filters, products);
    }
    private void refresh(VerticalLayout products){
        products.removeAll();
        filterStack.apply().forEach(p -> products.add(new ProductTile(p)));

    }

}
