package com.example.application.views.pages;


import com.example.application.services.dashboard.UsersServices;
import com.example.application.views.component.loginForm.LoginForm;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

import java.util.Collection;

@Route("login")
@CssImport("./themes/frontend/Login.css")
public class LoginPage extends HorizontalLayout  {

    private final UsersServices usersServices;

  LoginForm loginform = new LoginForm();
    public LoginPage () {
        this.usersServices = new UsersServices();

        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.addClassName("main-layout");

        Div leftCol = new Div();
        leftCol.addClassName("left");
        leftCol.add(LoginImage());

        Div rightCol = new Div();
        rightCol.addClassName("right");
        rightCol.add(loginform);

        mainLayout.add(leftCol, rightCol);

        add(mainLayout);

        add(new Button("Get all users", event -> GetUser()));

    }

    public Component LoginImage () {
        StreamResource imageResource = new StreamResource("register-image.png",
                () -> getClass().getResourceAsStream("/assets/images/register-image.png"));

        Image image = new Image(imageResource, "image");
        image.addClassName("register-image");

        return image;
    }
    
    private void GetUser() {
        usersServices.getAllUsers().ifPresent(responseBody -> {
            System.out.println("This is all users");
            System.out.println(responseBody);
        });
    }
}