package at.scheuchi.Gammazon.UI.Components.FilterComponents;

import at.scheuchi.Gammazon.Util.Callback;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;

public class NameMatchFilterComponent extends BaseFilterComponent{

    TextField matchField = new TextField();
    private Callback.callback1<String> onApply;

    public NameMatchFilterComponent(Callback.callback1<String> onApply) {
        super("Name Match");
        this.onApply = onApply;
        matchField.setLabel("Match Filter");
        mainLayout.add(matchField);
    }

    @Override
    protected void onAddClicked(ClickEvent<Button> buttonClickEvent) {
        onApply.run(matchField.getValue());
    }
}
