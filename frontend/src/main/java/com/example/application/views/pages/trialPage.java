package com.example.application.views.pages;

import com.example.application.views.component.settingsForm.settingsForm;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("settings")
public class trialPage extends HorizontalLayout {

    settingsForm form = new settingsForm();
    Dashboard dash = new Dashboard();
    public trialPage(){
        Div main = new Div();

        main.add(dash,form);
        add(main);
    }
}
