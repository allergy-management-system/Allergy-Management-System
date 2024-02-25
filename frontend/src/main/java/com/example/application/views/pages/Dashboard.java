package com.example.application.views.pages;


import com.example.application.views.component.settingsForm.settingsForm;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@CssImport("./themes/frontend/layout.css")
public class Dashboard extends AppLayout {


    public Dashboard() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Aller-Gus");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        SideNav nav = getSideNav();

        Scroller scroller = new Scroller(nav);
        scroller.setClassName(LumoUtility.Padding.SMALL);

        addToDrawer(scroller);
        addToNavbar(toggle, title);


    }

    private SideNav getSideNav() {
        SideNav nav = new SideNav();
        nav.addItem(new SideNavItem("Dashboard", "/dashboard",
                        VaadinIcon.DASHBOARD.create()),
                new SideNavItem("Calender", "/calender",
                        VaadinIcon.CALENDAR.create()),
                new SideNavItem("Messages", "/message",
                        VaadinIcon.ENVELOPE.create()),
                new SideNavItem("Settings", "/settings",
                        VaadinIcon.COG.create()),
                new SideNavItem("Logout", "/login",
                        VaadinIcon.SIGN_OUT.create()));
        return nav;
    }


}
