package com.example.application.views.component.formStepper;

import com.example.application.components.Notifications;
import com.example.application.views.component.allergyForm.Form1;
import com.example.application.views.component.allergyForm.Form2;
import com.example.application.views.component.allergyForm.Form3;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;

import java.util.function.Supplier;

@CssImport("./themes/frontend/AllergyForm.css")
public class FormStepperView extends VerticalLayout {

    private FormFields formFields;
    private Button prevButton;
    private Button nextButton;
    private Button submitButton;
    private int currentStep = 0;
    private Div[] formLayouts;

    public FormStepperView(FormFields formFields) {
        this.formFields = formFields;

        // Create form layout for each step
        Div step1Layout = new Div();
        Form1 form1 = new Form1(formFields);
        step1Layout.add(form1);

        Div step2Layout = new Div();
        Form2 form2 = new Form2(formFields);
        step2Layout.add(form2);

        Div step3Layout = new Div();
        Form3 form3 = new Form3(formFields);
        step3Layout.add(form3);

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
        getStyle().setFlexDirection(Style.FlexDirection.COLUMN);
        getStyle().setJustifyContent(Style.JustifyContent.CENTER);
        getStyle().setAlignItems(Style.AlignItems.CENTER);
        getStyle().setMarginBottom("5rem");
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

        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setDefaultVerticalComponentAlignment(Alignment.END);
        buttonLayout.getStyle().setMarginLeft("5rem");

        if (stepIndex > 0) {
            buttonLayout.add(prevButton);
        }
        if (stepIndex < formLayouts.length - 1) {
            buttonLayout.add(nextButton);
        } else {
            buttonLayout.add(submitButton);
        }

        add(buttonLayout);
    }

    private void submitForm() {

        ConfirmDialog dialog = new ConfirmDialog();
        dialog.setHeader("Submit allergy form?");
        dialog.setText(
                " Do you want to discard or save form?");

        dialog.setCancelable(true);
        dialog.addCancelListener(event -> Notification.show("Canceled"));

        dialog.setRejectable(true);
        dialog.setRejectText("Discard");
        dialog.addRejectListener(event -> Notification.show("Discarded"));

        dialog.setConfirmText("Save");
        dialog.addConfirmListener(event -> SendDataToBackend());
        dialog.open();

    };

    public void SendDataToBackend () {

        System.out.println("*************");
        System.out.println(formFields);
        System.out.println("*************");

        show().setClassName("notification-position");

    }

    public Notification show() {
        // When creating a notification using the constructor,
        // the duration is 0-sec by default which means that
        // the notification does not close automatically.
        Notification notification = new Notification();
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notification.setDuration(5000);
        notification.setPosition(Notification.Position.TOP_END);

        Div text = new Div(
                new Text("Form submission successful."),
                new HtmlComponent("br"),
                new Text("your allergy form has successfully  been submitted")
        );

        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeButton.setAriaLabel("Close");
        closeButton.addClickListener(event -> {
            notification.close();
        });

        HorizontalLayout layout = new HorizontalLayout(text, closeButton);
        layout.setAlignItems(Alignment.CENTER);

        notification.add(layout);
        notification.open();

        notification.setPosition(Notification.Position.MIDDLE);

        return notification;
    }
}
