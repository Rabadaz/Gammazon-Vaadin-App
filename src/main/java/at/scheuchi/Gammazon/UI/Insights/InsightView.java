package at.scheuchi.Gammazon.UI.Insights;

import at.scheuchi.Gammazon.Model.Product;
import at.scheuchi.Gammazon.Repository.ProductRepository;
import at.scheuchi.Gammazon.Repository.SaleRepository;
import at.scheuchi.Gammazon.UI.Components.SaleGridComponent;
import at.scheuchi.Gammazon.UI.Insights.Components.RevenueChartComponent;
import at.scheuchi.Gammazon.UI.Insights.Components.SaleChartComponent;
import at.scheuchi.Gammazon.UI.Layout.MainLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Collection;

@Route(value = "insights", layout = MainLayout.class)
public class InsightView extends VerticalLayout {

    public InsightView(ProductRepository productRepository, SaleRepository saleRepository) {
        Collection<Product> productCollection = productRepository.findAll();

        setSizeFull();
        HorizontalLayout hl = new HorizontalLayout();
        hl.setWidth("100%");

        hl.add(new RevenueChartComponent(productCollection), new SaleChartComponent(productCollection));

        SaleGridComponent saleGridComponent =new SaleGridComponent(saleRepository.findAll());
        saleGridComponent.setHeightFull();

        add(hl, saleGridComponent);
    }
}
