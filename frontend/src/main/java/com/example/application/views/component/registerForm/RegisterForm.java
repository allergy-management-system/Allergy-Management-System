package com.example.application.views.component.registerForm;

import com.example.application.services.authentication.AuthServices;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.HashMap;
import java.util.Map;

@CssImport("./themes/frontend/Register.css")
public class RegisterForm extends VerticalLayout {

    private final AuthServices authServices;

    TextField name = new TextField("Name");
    EmailField email = new EmailField("Email");
    PasswordField passwordField = new PasswordField("Password");
    Button button = new Button("Sign up");

    VerticalLayout form = new VerticalLayout();

    public RegisterForm (AuthServices authServices) {
        this.authServices = authServices;
        addClassName("register-form");

        H2 title = new H2("Create your free account");
        title.addClassName("title");

        name.setPlaceholder("Type your name");
        name.addClassName("text-field");

        email.setPlaceholder("Type your email");
        email.addClassName("text-field");

        passwordField.setPlaceholder("Type your password");
        passwordField.addClassName("text-field");

        button.addClassName("register-button");
        button.addClickListener(event -> register());
        button.addClickShortcut(Key.ENTER);

        HorizontalLayout footerText = new HorizontalLayout();
        footerText.addClassName("footer-text");
        Span alreadyHaveAnAccount = new Span("Already have an account?");
        Anchor signIn = new Anchor("/login", "Sign in");

        footerText.add(alreadyHaveAnAccount, signIn);
        footerText.setAlignItems(Alignment.CENTER);

        form.add(title, name, email, passwordField, button, footerText);

        add(form);
    }

    private void register() {
        // Construct input data for registration
        Map<String, Object> inputData = new HashMap<>();
        inputData.put("firstName", name.getValue());
        inputData.put("lastName", "LastName");
        inputData.put("email", email.getValue());
        inputData.put("gender", "male");
        inputData.put("password", passwordField.getValue());
        inputData.put("dateOfBirth", "12/23/2006        ");

        // Call the register method in the AuthService
        authServices.register(inputData).ifPresent(responseBody -> {
            System.out.println("InputData: " + inputData);

            System.out.println("Registration successful!");
            System.out.println(responseBody);
            Notification.show("Registration successful!");
            // Process the response if needed
        });
    }
}
