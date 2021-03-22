package at.scheuchi.Gammazon.UI.Profile;

import at.scheuchi.Gammazon.Model.User;
import at.scheuchi.Gammazon.Repository.SaleRepository;
import at.scheuchi.Gammazon.UI.Components.SaleGridComponent;
import at.scheuchi.Gammazon.UI.Layout.MainLayout;
import at.scheuchi.Gammazon.Util.UserUtils;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "profile", layout = MainLayout.class)
public class ProfileView extends VerticalLayout {
    private User user;

    public ProfileView(SaleRepository saleRepository) {
        this.user = UserUtils.getUserPrinciple().getUser();

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.START);
        setAlignItems(Alignment.CENTER);

        SaleGridComponent saleGridComponent = new SaleGridComponent(saleRepository.getSalesByCustomer(user.getCustomer()));
        saleGridComponent.setHeightFull();



        Span insightsBadge = new Span("Insights-Manager");
        insightsBadge.setClassName("my-badge");
        insightsBadge.setHeight("fit-content");
        insightsBadge.getStyle().set("margin", "auto 15px");
        HorizontalLayout nameLayout = new HorizontalLayout(new H1("Welcome, " + user.getCustomer().createFullName()));

        if(UserUtils.hasPermission("insights:view")){
            nameLayout.add(insightsBadge);
        }



        add(
                nameLayout,
                saleGridComponent
        );
    }
}
