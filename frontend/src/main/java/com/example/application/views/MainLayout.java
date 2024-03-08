package com.example.application.views;

import com.example.application.views.pages.authentication.LoginPage;
import com.example.application.views.pages.dashboard.Dashboard;
import com.example.application.views.pages.profile.Profile;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.theme.lumo.LumoUtility;

/**
 * The main view is a top-level placeholder for other views.
 */
@CssImport("./themes/frontend/Layout.css")
public class MainLayout extends AppLayout {

    private H2 appName;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        appName = new H2("Aller Gus");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, appName);
    }

    private void addDrawerContent() {
        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Dashboard", Dashboard.class, VaadinIcon.DASHBOARD.create()));
        nav.addItem(new SideNavItem("Profile", Profile.class, VaadinIcon.USER.create()));
        nav.addItem(new SideNavItem("Logout", LoginPage.class, VaadinIcon.ARROW_RIGHT.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }
}
