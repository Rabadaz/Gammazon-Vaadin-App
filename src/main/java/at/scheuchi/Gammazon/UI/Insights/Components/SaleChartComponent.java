package at.scheuchi.Gammazon.UI.Insights.Components;

import at.scheuchi.Gammazon.Model.Product;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Collection;

public class SaleChartComponent extends VerticalLayout {
    private final Chart chart = new Chart();
    public SaleChartComponent(Collection<Product> products){
        Configuration conf  = chart.getConfiguration();

        conf.getChart().setType(ChartType.PIE);

        conf.setTitle("Product Sale Count");

        Tooltip tooltip = new Tooltip();
        tooltip.setValueDecimals(1);
        conf.setTooltip(tooltip);

        PlotOptionsPie plotOptions = new PlotOptionsPie();
        plotOptions.setAllowPointSelect(true);
        plotOptions.setCursor(Cursor.POINTER);
        plotOptions.setShowInLegend(true);
        conf.setPlotOptions(plotOptions);

        DataSeries series = new DataSeries();

        for(var product : products){
            series.add(new DataSeriesItem(product.getTitle(), product.getSales().stream().mapToInt(p -> p.getCount()).sum()));
        }

        conf.setSeries(series);
        chart.setVisibilityTogglingDisabled(true);
        add(chart);
    }


}
