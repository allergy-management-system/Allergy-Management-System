package com.example.application.views.component.allergyForm;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

@CssImport("./themes/frontend/AllergyForm.css")
public class Form1 extends Div {


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
    public Form1 () {
        H3 title = new H3("Food Allergy Form");
        Paragraph subTitle = new Paragraph("History and Current Status");
        VerticalLayout titleGroup = new VerticalLayout();
        titleGroup.add(title, subTitle);
        titleGroup.addClassName("title-group");

        Paragraph formTitle = new Paragraph("Check the foods that have caused an allergic reaction:");

        Div riskLabel = new Div();
        riskLabel.addClassName("risks-flex-row");

        Div riskLevelGroup = new Div();
        riskLevelGroup.addClassName("risks-flex-row");

        for (Reaction reaction: reactions) {
            Span label = new Span(reaction.getLabel());
            RadioButtonGroup<String> riskLevel = new RadioButtonGroup<>();
            riskLevel.setItems("Low", "High");
            riskLevel.setValue("Low");

            riskLabel.add(label);
            riskLevelGroup.add(riskLevel);
        }

        HorizontalLayout risks = new HorizontalLayout();
        risks.add(riskLabel, riskLevelGroup);

        VerticalLayout form = new VerticalLayout();
        form.add(formTitle, risks);

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
