package at.scheuchi.Gammazon.UI.View;

import at.scheuchi.Gammazon.Filter.FilterableList;
import at.scheuchi.Gammazon.Filter.IFilter;
import at.scheuchi.Gammazon.Filter.Implementation.CategoryFilter;
import at.scheuchi.Gammazon.Filter.Implementation.ColorFilter;
import at.scheuchi.Gammazon.Filter.Implementation.NameMatchFilter;
import at.scheuchi.Gammazon.Filter.Implementation.PrizeFilter;
import at.scheuchi.Gammazon.Model.Product;
import at.scheuchi.Gammazon.Repository.ProductCategoryRepository;
import at.scheuchi.Gammazon.Repository.ProductColorRepository;
import at.scheuchi.Gammazon.Repository.ProductRepository;
import at.scheuchi.Gammazon.UI.Layout.MainLayout;
import at.scheuchi.Gammazon.UI.Components.FilterComponents.CategoryFilterComponent;
import at.scheuchi.Gammazon.UI.Components.FilterComponents.ColorFilterComponent;
import at.scheuchi.Gammazon.UI.Components.FilterComponents.NameMatchFilterComponent;
import at.scheuchi.Gammazon.UI.Components.FilterComponents.PrizeFilterComponent;
import at.scheuchi.Gammazon.UI.Components.ProductTile;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@PageTitle("Ɣ-zon")
@Route(value = "", layout = MainLayout.class)

public class HomeView extends HorizontalLayout {
    private final FilterableList<Product> productFilterableList;

    private IFilter<Product> filterStack;
    private Span treeSpan = new Span();

    public HomeView(ProductRepository productRepository, ProductColorRepository colorRepository, ProductCategoryRepository categoryRepository){

        productFilterableList = new FilterableList<>(productRepository.findAll());
        filterStack = productFilterableList;

        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.getStyle().set("margin","auto");

        VerticalLayout products = new VerticalLayout();
        VerticalLayout filters = new VerticalLayout();


        Button clearFilters = new Button("Clear Filters");
        clearFilters.addClickListener((buttonClickEvent -> {filterStack = productFilterableList; refresh(products);}));


        displayTree(filterStack);
        treeSpan.setWidth("100%");
        filters.add(
                clearFilters
                ,new ColorFilterComponent(colorRepository, (color) -> {filterStack = new ColorFilter(filterStack, color); refresh(products);})
                ,new NameMatchFilterComponent((nameMatch) -> { filterStack = new NameMatchFilter(filterStack,nameMatch); refresh(products); })
                ,new PrizeFilterComponent((min, max) -> {filterStack = new PrizeFilter(filterStack, min, max);  refresh(products);})
                ,new CategoryFilterComponent(categoryRepository, (c) -> { filterStack = new CategoryFilter(filterStack, c); refresh(products);})
                ,treeSpan
                );


        filters.setWidth("15vw");

        filterStack.apply().forEach(p -> products.add(new ProductTile(p)));

        mainLayout.add(filters, products);
        add(mainLayout);
    }
    private void refresh(VerticalLayout products){
        products.removeAll();
        filterStack.apply().forEach(p -> products.add(new ProductTile(p)));
        displayTree(filterStack);
    }

    private void displayTree(IFilter<Product> filterStack){
        treeSpan.removeAll();
        TreeGrid<IFilter<Product>> filterTree = new TreeGrid<>();
        filterTree.setItems(List.of(filterStack), productIFilter -> productIFilter.getChild() == null? List.of() : List.of(productIFilter.getChild()));
        filterTree.addComponentHierarchyColumn(filter -> {
            Paragraph params = filter.describeParams();
            params.getStyle().set("font-size","75%");
            return new Span(new Paragraph(filter.getClass().getSimpleName()), params);
        });
        treeSpan.add(filterTree);
    }

}
