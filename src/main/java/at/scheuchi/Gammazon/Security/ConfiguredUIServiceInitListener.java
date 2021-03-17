package at.scheuchi.Gammazon.Security;

import at.scheuchi.Gammazon.UI.Login.LoginView;
import at.scheuchi.Gammazon.UI.Login.RegisterView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;
import org.springframework.stereotype.Component;


@Component
public class ConfiguredUIServiceInitListener implements VaadinServiceInitListener {

    private Class[] allowedViews = {
            LoginView.class, RegisterView.class
    };

    @Override
    public void serviceInit(ServiceInitEvent event) {
        event.getSource().addUIInitListener(uiEvent -> {
            final UI ui = uiEvent.getUI();
            ui.addBeforeEnterListener(this::beforeEnter);
        });
    }

    private void beforeEnter(BeforeEnterEvent event) {
        boolean allowedPage = false;
        for(Class c : allowedViews){
            if(c.equals(event.getNavigationTarget())){
                allowedPage = true;
            }
        }
        if (!allowedPage && !SecurityUtils.isUserLoggedIn()) {
            event.rerouteTo(LoginView.class);
        }
    }
}
