package com.example.application.views.pages.dashboard;

import com.example.application.services.dashboard.UsersServices;
import com.example.application.views.MainLayout;
import com.example.application.views.component.formStepper.FormFields;
import com.example.application.views.component.formStepper.FormStepperView;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Record Allergy Form")
@Route(value = "record-allergy-form", layout = MainLayout.class)
public class RecordAllergyForm extends Div {
    FormFields currentFormFields = new FormFields();
    UsersServices usersServices = new UsersServices();
    FormStepperView formStepperView = new FormStepperView(currentFormFields, usersServices);
    public RecordAllergyForm () {

        add(formStepperView);
    }
}
