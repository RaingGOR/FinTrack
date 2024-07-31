package raingor.ru.clientservice.layouts;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.theme.lumo.LumoUtility;
import raingor.ru.clientservice.views.AllUsersAdminView;
import raingor.ru.clientservice.views.ClientView;
import raingor.ru.clientservice.views.AllTransactionAdminView;

// По сути мы тут делаем главную страницу
public class MainLayout extends AppLayout {

    public MainLayout() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("FinTrack");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        SideNav nav = getSideNav();

        Scroller scroller = new Scroller(nav);
        scroller.setClassName(LumoUtility.Padding.SMALL);

        addToDrawer(scroller);
        addToNavbar(toggle, title);
    }

    private SideNav getSideNav() {
        SideNav sideNav = new SideNav();

        SideNavItem clientProfileLink = new SideNavItem("Client Profile", ClientView.class);
        SideNavItem adminPanelItem = new SideNavItem("Admin Panel");
        adminPanelItem.addItem(new SideNavItem("All Users", AllUsersAdminView.class));
        adminPanelItem.addItem(new SideNavItem("All Transactions", AllTransactionAdminView.class));


        sideNav.addItem(clientProfileLink);
        sideNav.addItem(adminPanelItem);

        return sideNav;
    }


}
