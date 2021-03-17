package at.scheuchi.Gammazon.UI.Layout;

import at.scheuchi.Gammazon.Model.User;
import at.scheuchi.Gammazon.UI.View.HomeView;
import at.scheuchi.Gammazon.Util.UserUtils;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;



@CssImport("./styles/main.css")
public class MainLayout extends AppLayout {
    H2 navTitle = new H2("Ɣ-zon Wearhouse");
    Button logoutButton = new Button();
    public MainLayout(){
        if(UserUtils.getUserPrinciple() != null){

            logoutButton.setText("Logout");
            logoutButton.addClickListener(e -> UI.getCurrent().getPage().setLocation("/logout"));
            logoutButton.getStyle().set("margin", "10px auto");


            User user = UserUtils.getUserPrinciple().getUser();

            Paragraph greeting = new Paragraph("Hello, " + user.getCustomer().createFullName());
            greeting.getStyle().set("margin-left", "10px");


            addToNavbar(greeting, logoutButton);

        }




    }
}
