package com.example.application.views.component.formStepper;

import com.example.application.services.dashboard.UsersServices;
import com.example.application.views.component.allergyForm.Form1;
import com.example.application.views.component.allergyForm.Form2;
import com.example.application.views.component.allergyForm.Form3;
import com.example.application.views.component.modal.Modal;
import com.example.application.views.component.notifications.Notifications;
import com.nimbusds.jose.shaded.gson.Gson;
import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@CssImport("./themes/frontend/AllergyForm.css")
public class FormStepperView extends VerticalLayout {

    private final UsersServices usersServices;
    Notifications alert = new Notifications();

    private RestTemplate restTemplate;

    private Modal openModal;
    private FormFields formFields;
    private Button prevButton;
    private Button nextButton;
    private Button submitButton;
    private int currentStep = 0;
    private Div[] formLayouts;

    public FormStepperView(FormFields formFields, UsersServices usersServices) {
        this.formFields = formFields;
        this.usersServices = usersServices;

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

        restTemplate = new RestTemplate();

        // Prepare request body data
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();

        requestBody.add("peanuts", formFields.getPeanuts());
        requestBody.add("fish", formFields.getFish());
        requestBody.add("eggs", formFields.getEggs());
        requestBody.add("butter", formFields.getButter());
        requestBody.add("soyProducts", formFields.getSoyProducts());
        requestBody.add("milk", formFields.getMilk());
        requestBody.add("otherNuts", formFields.getOtherNuts());
        requestBody.add("sugar", formFields.getSugar());
        requestBody.add("mushrooms", formFields.getMushroom());
        requestBody.add("gluten", formFields.getGluten());
        requestBody.add("mustard", formFields.getMustard());
//        requestBody.add("otherFoods", formFields.getOtherFoods());
        requestBody.add("timesOfReaction", formFields.getTimesOfReaction());
        requestBody.add("lastReaction", formFields.getLastReaction());
        requestBody.add("causeOfReaction", formFields.getCauseOfReaction());
        requestBody.add("symptomExperienced", formFields.getSymptomsExperienced());
        requestBody.add("medicationAllergy", formFields.getMedicationAllergy());
        requestBody.add("additionalNotes", formFields.getAdditionalNotes());


        String response = usersServices.sendMessageParams(requestBody);

        System.out.println("Response: " + response);

        if(response != null){
            alert.success("Form Submitted Successfully!", "Please go to your history...");

            openModal = new Modal(response);
            openModal.open();
        } else {
            alert.error("Failed to send request.", "Please check your internet connection or your network and try again.");
        }

    }
}
