package at.scheuchi.Gammazon.UI.View.Components.FilterComponents;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@CssImport("./styles/FilterComponent.css")
public abstract class BaseFilterComponent extends VerticalLayout {

    protected final Div mainLayout = new Div();
    private final Button addButton = new Button("Apply Filter");
    public BaseFilterComponent(String name){
        H2 head = new H2(name);
        head.setClassName("heading");
        addButton.addClickListener(this::onAddClicked);
        add(new H2(name), mainLayout, addButton);
    }

    protected abstract void onAddClicked(ClickEvent<Button> buttonClickEvent);
}
