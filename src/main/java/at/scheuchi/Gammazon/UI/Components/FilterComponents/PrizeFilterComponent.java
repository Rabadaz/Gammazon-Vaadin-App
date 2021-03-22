package at.scheuchi.Gammazon.UI.Components.FilterComponents;

import at.scheuchi.Gammazon.Util.Callback;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;

public class PrizeFilterComponent extends BaseFilterComponent{
    private final NumberField min = new NumberField();
    private final NumberField max = new NumberField();
    private Callback.callback2<Double, Double> onApply;


    public PrizeFilterComponent(Callback.callback2<Double, Double> onApply) {
        super("Prize");
        this.onApply = onApply;

        min.setLabel("Min");
        max.setLabel("Max");
        HorizontalLayout hl = new HorizontalLayout(min, max);

        mainLayout.add(hl);


    }

    @Override
    protected void onAddClicked(ClickEvent<Button> buttonClickEvent) {
        double maxP = max.isEmpty()? Double.MAX_VALUE : max.getValue();
        double minP = min.isEmpty()? -1.0: min.getValue();
        onApply.run(minP, maxP);
    }
}
