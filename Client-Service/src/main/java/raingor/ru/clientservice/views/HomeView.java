package raingor.ru.clientservice.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import raingor.ru.clientservice.layouts.MainLayout;

@Route(value = "/home", layout = MainLayout.class)
@PageTitle("FinTrack")
public class HomeView extends Div {

}
