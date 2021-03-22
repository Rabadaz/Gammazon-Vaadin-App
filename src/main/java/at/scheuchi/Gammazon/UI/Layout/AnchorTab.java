package at.scheuchi.Gammazon.UI.Layout;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import org.yaml.snakeyaml.tokens.AnchorToken;

public class AnchorTab extends Tab implements AfterNavigationObserver {

    private final Anchor anchor;

    public AnchorTab(String text, String href){
        anchor = new Anchor(href, text);
        add(anchor);

    }

    public AnchorTab(String text, String href, String color){
        this(text, href);
        getStyle().set("color", color);
    }


    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        if (event.getLocation().getFirstSegment().equals(anchor.getHref()))
            ((Tabs)this.getParent().get()).setSelectedTab(this);

    }
}
