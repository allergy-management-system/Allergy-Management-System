package com.example.application.views.pages.authentication;

import com.example.application.services.authentication.AuthServices;
import com.example.application.views.component.registerForm.RegisterForm;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

@Route("register")
@CssImport("./themes/frontend/Register.css")
public class RegisterPage extends HorizontalLayout {

    private final AuthServices authServices;

    public RegisterPage () {
        this.authServices = new AuthServices();
        RegisterForm registerForm = new RegisterForm(authServices);

        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.addClassName("main-layout");

        Div leftCol = new Div();
        leftCol.addClassName("left-col");
        leftCol.add(registerForm);

        Div rightCol = new Div();
        rightCol.addClassName("right-col");
        rightCol.add(RegisterImage());

        mainLayout.add(leftCol, rightCol);

        add(mainLayout);
    }

    public Component RegisterImage () {
        StreamResource imageResource = new StreamResource("register-image.png",
                () -> getClass().getResourceAsStream("/assets/images/register-image.png"));

        Image image = new Image(imageResource, "image");
        image.addClassName("register-image");

        return image;
    }
}
