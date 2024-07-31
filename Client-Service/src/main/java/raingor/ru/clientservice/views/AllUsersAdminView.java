package raingor.ru.clientservice.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import raingor.ru.clientservice.dtos.UserDTO;
import raingor.ru.clientservice.layouts.MainLayout;
import raingor.ru.clientservice.services.UserService;

import java.util.List;

@Route(value = "users", layout = MainLayout.class)
@PageTitle("User List")
public class AllUsersAdminView extends VerticalLayout {
    private final UserService userService;

    @Autowired
    public AllUsersAdminView(UserService userService) {
        this.userService = userService;
        initialize();
    }

    private void initialize() {
        Grid<UserDTO> grid = new Grid<>(UserDTO.class);

        List<UserDTO> users = userService.getAllUsers();
        grid.setItems(users);
        grid.setColumns("id", "username", "email");

        add(grid);
    }
}
