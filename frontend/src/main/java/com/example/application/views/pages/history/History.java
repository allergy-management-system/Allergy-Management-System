package com.example.application.views.pages.history;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.model.Buttons;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("History")
@Route(value = "history", layout = MainLayout.class)
@CssImport("./themes/frontend/History.css")
public class History extends VerticalLayout {

    public History () {
        Div header = new Div();
        header.addClassName("header");
        TextField searchBox = new TextField();
        searchBox.addClassName("search-box");
        header.add(searchBox);


        // Create an array of date, details, and action with action buttons
        Object[][] historyData = {
                {"2024-03-10", "Details 1", "Open", "Delete"},
                {"2024-03-11", "Details 2", "Open", "Delete"},
                {"2024-03-12", "Details 3", "Open", "Delete"}
        };

        // Create a Grid to display the history data
        Grid<Object[]> grid = new Grid<>();
        grid.setItems(historyData);
        grid.addClassName("grid");
        grid.addColumn(row -> row[0]).setHeader("Date");
        grid.addColumn(row -> row[1]).setHeader("Details");
        grid.addComponentColumn(row -> createActionButtons()).setHeader("Actions");


        add(header, grid);
        setWidthFull();
        addClassName("page");
    }

    // Method to create action buttons
    private HorizontalLayout createActionButtons() {
        Button openButton = new Button("Open");
        openButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        openButton.addClassName("open-button");

        Button deleteButton = new Button("Delete");
        deleteButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_ERROR);

        // Add click listener for the button if needed
        HorizontalLayout buttonGroup = new HorizontalLayout(openButton, deleteButton);
        return buttonGroup;
    }
}
