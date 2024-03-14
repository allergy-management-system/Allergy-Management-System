package com.example.application.views.component.allergyForm;

import com.example.application.views.component.formStepper.FormFields;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.dom.Style;

@CssImport("./themes/frontend/AllergyForm.css")
public class Form1 extends Div {

    private FormFields formFields;
    private RadioButtonGroup<String> riskLevel;

    Reaction[] reactions = {
            new Reaction("Peanuts"),
            new Reaction("Fish/Shellfish"),
            new Reaction("Peanut or nut butter"),
            new Reaction("Soy products"),
            new Reaction("Tree nuts (Walnuts, almonds, pecans etc.)"),
            new Reaction("Sugar"),
            new Reaction("Mushroom"),
            new Reaction("Gluten"),
            new Reaction("Mustard"),
            new Reaction("Other"),
    };
    public Form1 (FormFields formFields) {
        this.formFields = formFields;

        H3 title = new H3("Food Allergy Form");
        Paragraph subTitle = new Paragraph("History and Current Status");
        VerticalLayout titleGroup = new VerticalLayout();
        titleGroup.add(title, subTitle);
        titleGroup.addClassName("title-group");

        Paragraph formTitle = new Paragraph("Check the foods that have caused an allergic reaction:");

        HorizontalLayout risksColoum = new HorizontalLayout();
        risksColoum.getStyle().setDisplay(Style.Display.FLEX);
        risksColoum.getStyle().setFlexDirection(Style.FlexDirection.COLUMN);
        risksColoum.getStyle().setJustifyContent(Style.JustifyContent.SPACE_BETWEEN);

        for (Reaction reaction: reactions) {
            Span label = new Span(reaction.getLabel());
            riskLevel = new RadioButtonGroup<>();
            riskLevel.setItems("Low", "High");
            riskLevel.setValue("Low");

            riskLevel.addValueChangeListener(event -> {
                String selectedValue = event.getValue();
                if (selectedValue == "High") {
                    formFields.setReactionRiskLevel(reaction.getLabel(), reaction.getLabel());
                }
            });

            riskLevel.getStyle().setMarginLeft("5rem");

            HorizontalLayout risksRow = new HorizontalLayout(label, riskLevel);
            risksRow.getStyle().setDisplay(Style.Display.FLEX);
            risksRow.getStyle().setFlexDirection(Style.FlexDirection.ROW);
            risksRow.getStyle().setJustifyContent(Style.JustifyContent.SPACE_BETWEEN);
            risksColoum.add(risksRow);
        }

        VerticalLayout form = new VerticalLayout();
        form.add(formTitle, risksColoum);

        add(titleGroup, form);
        addClassName("form-page");
    }

    class Reaction {
        private String label;

        public Reaction(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

}
