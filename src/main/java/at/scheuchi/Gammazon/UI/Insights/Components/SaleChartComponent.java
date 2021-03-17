package at.scheuchi.Gammazon.UI.Insights.Components;

import at.scheuchi.Gammazon.Model.Sale;
import be.ceau.chart.dataset.BarDataset;
import com.syndybat.chartjs.ChartJs;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Collection;


public class SaleChartComponent extends VerticalLayout {
    ChartJs chartJs;
    private Collection<Sale> sales;

    public SaleChartComponent(Collection<Sale> sales) {


        this.sales = sales;
    }

    private ChartJs prepareChart(){



        BarDataset dataset = new BarDataset()
                .setLabel("Sales")
                //.setData()
    }

}
