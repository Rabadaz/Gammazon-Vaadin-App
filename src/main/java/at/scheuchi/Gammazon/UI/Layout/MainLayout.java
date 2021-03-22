package at.scheuchi.Gammazon.UI.Layout;

import at.scheuchi.Gammazon.Model.User;
import at.scheuchi.Gammazon.UI.Insights.InsightView;
import at.scheuchi.Gammazon.UI.Profile.ProfileView;
import at.scheuchi.Gammazon.UI.User.UsersView;
import at.scheuchi.Gammazon.UI.View.HomeView;
import at.scheuchi.Gammazon.Util.UserUtils;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.tabs.Tabs;


@CssImport("./styles/main.css")

public class MainLayout extends AppLayout {
    public MainLayout(){
        if(UserUtils.getUserPrinciple() != null){

            User user = UserUtils.getUserPrinciple().getUser();

            Paragraph greeting = new Paragraph("Hello, " + user.getCustomer().createFullName());
            greeting.getStyle().set("margin-left", "10px");

            Tabs tabs = new Tabs( new AnchorTab("Logout", "/logout", "red") ,new NavTab("Home", HomeView.class), new NavTab("Profile", ProfileView.class));

            if(UserUtils.hasPermission("insights:view"))
                tabs.add(new NavTab("Insights", InsightView.class));

            if(UserUtils.hasPermission("users:view"))
                tabs.add(new NavTab("Users", UsersView.class));

            Paragraph madeBy =  new Paragraph("Made by Martin Scheuchenpflug");
            madeBy.getStyle().set("margin-left", "auto");
            madeBy.getStyle().set("margin-right", "10px");
            madeBy.getStyle().set("color", "gray");

            addToNavbar(greeting, tabs, madeBy);
        }
    }
}
