package at.scheuchi.Gammazon.UI.Components.FilterComponents;

import at.scheuchi.Gammazon.Model.ProductColor;
import at.scheuchi.Gammazon.Repository.ProductColorRepository;
import at.scheuchi.Gammazon.Util.Callback;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;

public class ColorFilterComponent extends BaseFilterComponent{
    private final Callback.callback1<ProductColor> onFilterApply;
    private ComboBox<ProductColor> colorBox = new ComboBox<>();

    public ColorFilterComponent(ProductColorRepository colorRepository, Callback.callback1<ProductColor> onFilterApply) {
        super("Color Filter");
        this.onFilterApply = onFilterApply;
        colorBox.setLabel("Color");
        colorBox.setItems(colorRepository.findAll());
        colorBox.setItemLabelGenerator(ProductColor::getColorName);
        mainLayout.add(colorBox);
    }

    @Override
    protected void onAddClicked(ClickEvent<Button> buttonClickEvent) {
        onFilterApply.run(this.colorBox.getValue());
    }
}
