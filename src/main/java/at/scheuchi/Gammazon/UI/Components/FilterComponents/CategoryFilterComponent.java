package at.scheuchi.Gammazon.UI.Components.FilterComponents;

import at.scheuchi.Gammazon.Model.ProductCategory;
import at.scheuchi.Gammazon.Repository.ProductCategoryRepository;
import at.scheuchi.Gammazon.Util.Callback;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;

public class CategoryFilterComponent extends BaseFilterComponent{
    private ComboBox<ProductCategory> categoryComboBox = new ComboBox<>();
    private Callback.callback1<ProductCategory> onFilterApply;

    public CategoryFilterComponent(ProductCategoryRepository categoryRepository, Callback.callback1<ProductCategory> onFilterApply) {
        super("Category");
        this.onFilterApply = onFilterApply;

        categoryComboBox.setItems(categoryRepository.findAll());
        categoryComboBox.setItemLabelGenerator(ProductCategory::getCategoryName);
        categoryComboBox.setLabel("Category");




        mainLayout.add(categoryComboBox);


    }

    @Override
    protected void onAddClicked(ClickEvent<Button> buttonClickEvent) {
        onFilterApply.run(categoryComboBox.getValue());
    }
}
