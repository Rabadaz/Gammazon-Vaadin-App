package at.scheuchi.Gammazon.UI.Insights;

import at.scheuchi.Gammazon.UI.Layout.MainLayout;
import com.syndybat.chartjs.ChartJs;
import com.vaadin.flow.router.Route;

@Route(value = "insights", layout = MainLayout.class)
public class InsightView {
    ChartJs chartJs;
    public InsightView() {
        chartJs = new ChartJs()

    }
}
