package com.example.application.views.pages;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("register")
public class RegisterPage extends HorizontalLayout {

    public RegisterPage () {
        add(new H1("Register Page"));
    }
}
