package com.example.application.views.pages.history;

import com.example.application.services.dashboard.UsersServices;
import com.example.application.views.MainLayout;
import com.example.application.views.component.modal.Modal;
import com.fasterxml.jackson.databind.JsonNode;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.page.WebStorage;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@PageTitle("History")
@Route(value = "history", layout = MainLayout.class)
@CssImport("./themes/frontend/History.css")
public class History extends VerticalLayout implements BeforeEnterObserver {

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        // Fetch the NAME_KEY from WebStorage
        WebStorage.getItem(NAME_KEY, value -> {
            userId = value == null ? "" : value;

            // Call fetchData() after getting the userId
            fetchData();
        });
    }
    private static final String NAME_KEY = "userId";
    private String userId;
    UsersServices usersServices = new UsersServices();

    private String date;
    private String message;
    Grid<Object[]> grid;

    List<String> messages = new ArrayList<String>();

    public History () {

        Div header = new Div();
        header.addClassName("header");
        TextField searchBox = new TextField();
        searchBox.addClassName("search-box");
        header.add(searchBox);

        // Create a Grid to display the history data
        grid = new Grid<>();
        grid.addClassName("grid");
        grid.addColumn(row -> row[0]).setHeader("Date");
        grid.addColumn(row -> row[1]).setHeader("Details");
        grid.addComponentColumn(row -> createActionButtons((String) row[1])).setHeader("Actions");


        if (grid.getColumns().isEmpty()) {
            // If grid has no items, show a message and the reload button
            Div messageDiv = new Div();
            messageDiv.addClassName("message");
            messageDiv.setText("Oops! You have no allergy yet.");
            add(header, messageDiv);
            grid.setVisible(false); // Hide the grid
        } else {
            // If grid has data, show the grid and hide the reload button
            add(header, grid);
        }

        add(header, grid);
        setWidthFull();
        addClassName("page");
    }

    // Method to create action buttons
// Method to create action buttons
    private HorizontalLayout createActionButtons(String message) {
        Button openButton = new Button("Open");
        openButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        openButton.addClassName("open-button");

        openButton.addClickListener(event -> {
            // Open the modal with the corresponding message
            Modal modal = new Modal(message);
            modal.open();
        });

        Button deleteButton = new Button("Delete");
        deleteButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_ERROR);

        // Add click listener for the button if needed
        HorizontalLayout buttonGroup = new HorizontalLayout(openButton, deleteButton);
        return buttonGroup;
    }


    private void fetchData () {
        if (userId != null) {
            List<JsonNode> response = usersServices.getAllHistory(userId);

            if (response != null) {
                List<Object[]> historyDataList = new ArrayList<>();

                // Iterate through each object in the array
                for (JsonNode node : response) {
                    // Access and print the values of properties in each object
                    date = node.get("date").asText();
                    message = node.get("response").asText();

                    messages.add(message);
                    // Add data to the list
                    Object[] rowData = {date, message, "Open", "Delete"};
                    historyDataList.add(rowData);
                }

                    grid.setItems(historyDataList);
                }
            } else {
                // Handle the case where the response is null
                System.out.println("Response is null");
            }
        }
    }

