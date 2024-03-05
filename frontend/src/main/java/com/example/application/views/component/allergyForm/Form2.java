package com.example.application.views.component.allergyForm;

import com.example.application.views.component.formStepper.FormFields;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.TextArea;

import java.util.Set;

@CssImport("./themes/frontend/AllergyForm.css")
public class Form2 extends Div {

    private FormFields formFields;

    public Form2 (FormFields formFields) {
        this.formFields = formFields;

        H3 title = new H3("Food Allergy Form");
        Paragraph subTitle = new Paragraph("History and Current Status");
        VerticalLayout titleGroup = new VerticalLayout();
        titleGroup.add(title, subTitle);
        titleGroup.addClassName("title-group");

        Paragraph label1 = new Paragraph("Please enter all of the other foods that have caused an allergic reaction");
        TextArea courseOfReaction = new TextArea();

        courseOfReaction.addValueChangeListener(event -> {
            String newValue = event.getValue();
            formFields.setCauseOfReaction(newValue);
        });
        courseOfReaction.setWidthFull();
        courseOfReaction.setHeight("120px");
        Div verticalGroup1 = new Div();
        verticalGroup1.addClassName("vertical-group");
        verticalGroup1.add(label1, courseOfReaction);

        Paragraph label2 = new Paragraph("How many times have you had a reaction?*");
        RadioButtonGroup<String> timesOfReaction = new RadioButtonGroup<>();
        timesOfReaction.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        timesOfReaction.setItems("Never", "Once", "More than once");
        timesOfReaction.setValue("Never");

        timesOfReaction.addValueChangeListener(event -> {
            String selectedValue = event.getValue();
            formFields.setTimesOfReaction(selectedValue);
        });
        Div verticalGroup2 = new Div();
        verticalGroup2.addClassName("vertical-group");
        verticalGroup2.add(label2, timesOfReaction);

        Paragraph label3 = new Paragraph("When was the last reaction?");
        DatePicker datePicker = new DatePicker();

        datePicker.addValueChangeListener(event -> {
            String selectedDate = String.valueOf(event.getValue());
            formFields.setLastReaction(selectedDate);
        });
        Div verticalGroup3 = new Div();
        verticalGroup3.addClassName("vertical-group");
        verticalGroup3.add(label3, datePicker);

        Paragraph label4 = new Paragraph("What has to happen for you to react to the problem food(s)?");
        CheckboxGroup<String> causeOfReaction = new CheckboxGroup<>();
        causeOfReaction.setItems("Eating Foods", "Touching Foods", "Smelling Foods",
                "Others");

        causeOfReaction.addValueChangeListener(event -> {
            Set<String> selectedAllergies = event.getValue();
            formFields.setTimesOfReaction(selectedAllergies.toString());
        });
        causeOfReaction.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        Div verticalGroup4 = new Div();
        verticalGroup4.addClassName("vertical-group");
        verticalGroup4.add(label4, causeOfReaction);

        VerticalLayout form = new VerticalLayout();
        form.add(verticalGroup1, verticalGroup2, verticalGroup3, verticalGroup4);

        add(titleGroup, form);
        addClassName("form-page");
    }
}
