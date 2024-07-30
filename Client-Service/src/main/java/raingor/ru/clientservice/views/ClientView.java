package raingor.ru.clientservice.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import raingor.ru.clientservice.layouts.MainLayout;

@Route(value = "", layout = MainLayout.class)
public class ClientView extends Div {

    public ClientView() {
        setText("Client");
    }

}
