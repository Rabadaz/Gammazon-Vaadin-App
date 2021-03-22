package at.scheuchi.Gammazon.UI.Layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.RouterLink;

public class NavTab extends Tab implements AfterNavigationObserver {
    public final RouterLink link;

    public NavTab(String text, Class<? extends Component> navigationTarget) {
        link = new RouterLink(null, navigationTarget);
        link.add(text);
        this.add(link);
    }


    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        if (event.getLocation().getFirstSegment().equals(link.getHref()))
            ((Tabs)this.getParent().get()).setSelectedTab(this);

    }
}
