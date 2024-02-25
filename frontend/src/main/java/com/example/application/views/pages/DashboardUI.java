package com.example.application.views.pages;

import com.example.application.views.component.recordAllergy.RecordAllergy;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("dashboard")
public class DashboardUI extends HorizontalLayout {

    Dashboard sidebar = new Dashboard();
    RecordAllergy recordAllergy = new RecordAllergy();

    public DashboardUI () {
        Div main = new Div();
        main.add(sidebar, recordAllergy);

        add(main);
    }
}
