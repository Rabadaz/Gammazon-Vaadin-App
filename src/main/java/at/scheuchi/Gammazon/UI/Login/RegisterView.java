package at.scheuchi.Gammazon.UI.Login;

import at.scheuchi.Gammazon.Model.Customer;
import at.scheuchi.Gammazon.Model.User;
import at.scheuchi.Gammazon.Repository.CustomerRepository;
import at.scheuchi.Gammazon.Repository.UserRepository;
import at.scheuchi.Gammazon.UI.Layout.MainLayout;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "register", layout = MainLayout.class)
public class RegisterView  extends VerticalLayout {
    private final Div mainDiv = new Div();


    private final Button registerbtn = new Button("Register");
    private final TextField fName = new TextField();
    private final TextField lName = new TextField();
    private final TextField username = new TextField();
    private final PasswordField passwordField = new PasswordField();
    private UserRepository userRepository;
    private CustomerRepository customerRepository;


    public RegisterView(UserRepository userRepository, CustomerRepository customerRepository){
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;

        //labels
        fName.setLabel("First Name");
        fName.setRequired(true);
        lName.setLabel("Last Name");
        lName.setRequired(true);
        username.setLabel("Username");
        username.setRequired(true);
        passwordField.setLabel("Password");
        passwordField.setRequired(true);

        registerbtn.addClickListener(this::onRegisterClicked);


        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        mainDiv.add(new H1("Ɣzon Registration"),new HorizontalLayout(fName, lName), new HorizontalLayout(username, passwordField), registerbtn);
        add(mainDiv);
    }

    private void onRegisterClicked(ClickEvent<Button> buttonClickEvent) {

        if(lName.isEmpty() || fName.isEmpty() || username.isEmpty() || passwordField.isEmpty())
            return;

        Customer c = new Customer();
        c.setFirstName(fName.getValue());
        c.setLastNamme(lName.getValue());

        c = customerRepository.save(c);

        User user = new User();
        user.setUsername(username.getValue());
        user.setPassword(passwordField.getValue());
        user.setCustomer(c);
        userRepository.save(user);
        UI.getCurrent().getPage().setLocation("/");
    }
}
