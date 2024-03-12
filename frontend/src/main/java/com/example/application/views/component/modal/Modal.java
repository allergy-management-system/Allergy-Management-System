package com.example.application.views.component.modal;

import com.example.application.views.pages.history.History;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Modal extends Dialog {
    public Modal(String message) {
        getElement().setAttribute("aria-label", "System maintenance hint");

        // Create dialog layout
        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(true);

        // Create dialog content
        H2 headline = new H2("Allergy Response");
        Paragraph content = new Paragraph(message);

        // Close button
        Button closeButton = new Button("Go to History", event -> closeBtn());

        // Add components to layout
        layout.add(headline, content, closeButton);

        // Set layout properties
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);
        layout.setWidth("700px");
        layout.setMaxWidth("100%");

        // Add layout to dialog
        add(layout);
    }

    private void closeBtn () {
        close();
        UI.getCurrent().navigate(History.class);
    }
}
