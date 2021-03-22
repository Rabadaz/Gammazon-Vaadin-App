package at.scheuchi.Gammazon.UI.Insights.Components;

import at.scheuchi.Gammazon.Model.Product;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class RevenueChartComponent extends VerticalLayout {

    private Chart chart = new Chart();
    public RevenueChartComponent(Collection<Product> productCollection) {

        List<Number> prizes =
                productCollection.stream()
                        .map(p ->
                                ((p.getSales().stream()
                                        .mapToInt(s ->
                                                s.getCount()).sum()
                                )* p.getPrice() / 100.0))
                        .collect(Collectors.toList());


        Configuration configuration = chart.getConfiguration();
        configuration.setTitle("Sales");
        chart.getConfiguration().getChart().setType(ChartType.COLUMN);

        configuration.addSeries(new ListSeries("Revenue", prizes));


        XAxis x = new XAxis();
        x.setCrosshair(new Crosshair());
        productCollection.stream().map(p -> p.getTitle()).forEach(t -> x.addCategory(t));
        configuration.addxAxis(x);

        YAxis y = new YAxis();
        y.setMin(0);
        y.setTitle("€");
        configuration.addyAxis(y);



        add(chart);


    }
}
