package com.example.application.views.component.loginForm;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;



@CssImport("./themes/frontend/Login.css")
public class LoginForm extends VerticalLayout {
;
        EmailField email = new EmailField("Email");
        PasswordField passwordField = new PasswordField("Password");
        Button button = new Button("Sign in");

        VerticalLayout form = new VerticalLayout();

        public LoginForm () {
            addClassName("login-form");

            H2 title = new H2("Create your free account");
            title.addClassName("title");

            email.setPlaceholder("Type your email");
            email.addClassName("text-field");

            passwordField.setPlaceholder("Type your password");
            passwordField.addClassName("text-field");

            button.addClassName("register-button");

            HorizontalLayout footerText = new HorizontalLayout();
            footerText.addClassName("footer-text");
            Span alreadyHaveAnAccount = new Span("Don't have an account?");
            Anchor signIn = new Anchor("/register", "Sign in");

            footerText.add(alreadyHaveAnAccount, signIn);
            footerText.setAlignItems(FlexComponent.Alignment.CENTER);

            form.add(title, email, passwordField, button, footerText);

            add(form);

        }
    }


