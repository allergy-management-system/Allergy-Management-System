package com.example.application.views.component.formStepper;

import com.example.application.views.component.allergyForm.Form1;
import com.example.application.views.component.allergyForm.Form2;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

@CssImport("./themes/frontend/AllergyForm.css")
public class FormStepperView extends VerticalLayout {

    private TextField emailField;
    private Button prevButton;
    private Button nextButton;
    private Button submitButton;
    private HorizontalLayout buttons;
    private int currentStep = 0;
    private Div[] formLayouts;

    public FormStepperView() {
        // Create form layout for each step
        Div step1Layout = new Div();
        Form1 form1 = new Form1();
        step1Layout.add(form1);

        Div step2Layout = new Div();
        Form2 form2 = new Form2();
        step2Layout.add(form2);

        Div step3Layout = new Div();
        emailField = new TextField("Email");
        step3Layout.add(emailField);

        formLayouts = new Div[]{step1Layout, step2Layout, step3Layout};

        // Create buttons for navigation
        prevButton = new Button("previous");
        prevButton.addClassName("custom-button");
        prevButton.addClickListener(event -> showPreviousStep());

        nextButton = new Button("next");
        nextButton.addClassName("custom-button");
        nextButton.addClickListener(event -> showNextStep());

        submitButton = new Button("submit");
        submitButton.addClassName("custom-button");
        submitButton.addClickListener(event -> submitForm());

        // Initially show the first step
        showStep(0);

        // Add form layout and button layout to the view
        add(formLayouts[currentStep], nextButton);
        setAlignItems(Alignment.CENTER);
    }


    private void showNextStep() {
        if (currentStep < formLayouts.length - 1) {
            currentStep++;
            showStep(currentStep);
        }
    }

    private void showPreviousStep() {
        if (currentStep > 0) {
            currentStep--;
            showStep(currentStep);
        }
    }

    private void showStep(int stepIndex) {
        removeAll();
        add(formLayouts[stepIndex]);
        if (stepIndex > 0) {
            add(prevButton);
        }
        if (stepIndex < formLayouts.length - 1) {
            add(nextButton);
        } else {
            add(submitButton);
        }
    }

    private void submitForm() {
        // Implement logic to submit form data
        Dialog dialog = new Dialog();
//        dialog.add(new Div().setText("Form submitted successfully!"));
        dialog.open();
    }
}
