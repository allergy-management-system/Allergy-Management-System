package com.example.application.views.component.loginForm;

import com.example.application.services.authentication.AuthServices;
import com.example.application.views.pages.Dashboard;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@CssImport("./themes/frontend/Login.css")
public class LoginForm extends VerticalLayout {
;
    private final AuthServices authServices;

        Map<String, Object> inputData = new HashMap<>();
        EmailField email = new EmailField("Email");
        PasswordField password = new PasswordField("Password");
        Button button = new Button("Sign in");

        VerticalLayout form = new VerticalLayout();

        public LoginForm (AuthServices authServices) {
            this.authServices = authServices;
            addClassName("login-form");

            H2 title = new H2("Glad to have you back");
            title.addClassName("title");

            email.setPlaceholder("Type your email");
            email.addClassName("text-field");

            password.setPlaceholder("Type your password");
            password.addClassName("text-field");

            button.addClassName("register-button");
            button.addClickListener(event -> login());
            button.addClickShortcut(Key.ENTER);

            HorizontalLayout footerText = new HorizontalLayout();
            footerText.addClassName("footer-text");
            Span alreadyHaveAnAccount = new Span("Don't have an account?");
            Anchor signIn = new Anchor("/register", "Sign up");

            footerText.add(alreadyHaveAnAccount, signIn);
            footerText.setAlignItems(FlexComponent.Alignment.CENTER);

            form.add(title, email, password, button, footerText);

            add(form);

        }

    private void login() {
        inputData.put("email", email.getValue());
        inputData.put("password", password.getValue());

        ValidationResult validationResult = validateForm(email.getValue());

        if (validationResult.isValid()) {
            submitForm(inputData.toString());
        } else {
            String errorMessage = validationResult.getErrorMessage();
            showErrorMessage(errorMessage);
        }
    }

    private void submitForm(String formData) {
        Object authLogin = authServices.login(formData);
        // Check if the response is an instance of ResponseEntity (assuming it's used for handling HTTP responses)
        if (authLogin instanceof ResponseEntity<?>) {
            // Cast the response to ResponseEntity<String> to access status code
            ResponseEntity<String> responseEntity = (ResponseEntity<String>) authLogin;
            //<--Check the response status
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                Notification.show("Login successful!");
                // Navigate to the Dashboard page
                getUI().ifPresent(ui -> ui.navigate(Dashboard.class));
            } else {
                Notification.show("Login failed. Please try again.");
            }
        }
        }

    private void showErrorMessage(String errorMessage) {
        Notification.show(errorMessage);
    }

    public class ValidationResult {
        private boolean isValid;
        private String errorMessage;

        public ValidationResult(boolean isValid, String errorMessage) {
            this.isValid = isValid;
            this.errorMessage = errorMessage;
        }

        public boolean isValid() {
            return isValid;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

    public ValidationResult validateForm(String email) {
        // Trim input strings
        email = email.trim();

        // Check for null or empty strings
        if (email.isEmpty() || password.isEmpty()) {
            return new ValidationResult(false, "Email and password are required.");
        }

        // Email validation
        if (!isValidEmail(email)) {
            return new ValidationResult(false, "Invalid email format.");
        }

        // If all validations pass, return success
        return new ValidationResult(true, "Validation successful.");
    }

    private boolean isValidEmail(String email) {
        // Implement email validation logic (e.g., using regex)
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    }


