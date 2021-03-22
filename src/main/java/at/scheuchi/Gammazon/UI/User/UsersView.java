package at.scheuchi.Gammazon.UI.User;

import at.scheuchi.Gammazon.Model.User;
import at.scheuchi.Gammazon.Repository.UserRepository;
import at.scheuchi.Gammazon.UI.Layout.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.Route;

import java.util.Collection;
import java.util.stream.Collectors;

@Route(value = "users", layout = MainLayout.class)
public class UsersView extends VerticalLayout {
    private UserRepository userRepository;

    public UsersView(UserRepository userRepository) {
        this.userRepository = userRepository;

        setSizeFull();
        setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        setAlignItems(FlexComponent.Alignment.CENTER);

        add(new H1("Application Users"), prepareGrid(userRepository.findAll()));


    }

    private TreeGrid<User> prepareGrid(Collection<User> users){
        TreeGrid<User> grid = new TreeGrid<>();
        grid.setItems(users);

        grid.addColumn(User::getUsername).setHeader("Username");
        grid.addColumn(u -> u.getCustomer().getFirstName()).setHeader("First Name");
        grid.addColumn(u -> u.getCustomer().getLastNamme()).setHeader("Last Name");
        grid.addColumn(u -> u.getAuthorities().stream().map(a -> a.getPermission()).collect(Collectors.joining(" "))).setHeader("Permissions");

        return grid;


    }
}
