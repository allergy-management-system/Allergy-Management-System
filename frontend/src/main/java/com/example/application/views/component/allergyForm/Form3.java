package com.example.application.views.component.allergyForm;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

@CssImport("./themes/frontend/AllergyForm.css")
public class Form3 extends Div {

    public Form3 () {
        H3 title = new H3("Food Allergy Form");
        Paragraph subTitle = new Paragraph("History and Current Status");
        VerticalLayout titleGroup = new VerticalLayout();
        titleGroup.add(title, subTitle);
        titleGroup.addClassName("title-group");

        Paragraph label1 = new Paragraph("Please enter all of the other foods that have caused an allergic reaction");
        TextArea otherFoods = new TextArea();
        otherFoods.setWidthFull();
        otherFoods.setHeight("120px");
        Div verticalGroup1 = new Div();
        verticalGroup1.addClassName("vertical-group");
        verticalGroup1.add(label1, otherFoods);
    }
}
