package at.scheuchi.Gammazon.UI.Login;

import at.scheuchi.Gammazon.UI.Layout.MainLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import org.jboss.jandex.Main;

@Route(value = "login", layout = MainLayout.class)

public class LoginView extends VerticalLayout  implements BeforeEnterObserver {
    LoginForm loginForm = new LoginForm();

    public LoginView(){

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        loginForm.setAction("login");
        loginForm.setForgotPasswordButtonVisible(false);
        add(new H1("Ɣzon Warehouse Login"), loginForm, new Anchor("register", "Register"));
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        var error = beforeEnterEvent.getLocation().getQueryParameters().getParameters().containsKey("error");
        loginForm.setError(error);
    }
}
