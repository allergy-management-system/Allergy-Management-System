package com.example.application.views.pages.dashboard;

import com.example.application.services.authentication.AuthServices;
import com.example.application.views.pages.authentication.LoginPage;
import com.vaadin.flow.component.html.Div;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.StreamResource;

@PageTitle("Dashboard")
@Route(value = "dashboard", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@CssImport("./themes/frontend/Dashboard.css")
public class Dashboard extends Div implements BeforeEnterObserver {

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        // Check if the user is authenticated
        if (AuthServices.isUserLoggedIn()) {
            event.rerouteTo(LoginPage.class); // Redirect to login page if not logged in
        }
    }
    Dashboard.Item[] items = {
            new Dashboard.Item("Understanding Triggers and Strategies for Management", "Recent studies suggest that understanding food allergies goes beyond mere avoidance. Researchers are delving into the intricate mechanisms behind allergic reactions, shedding light on potential triggers and innovative management approaches."),
            new Dashboard.Item(" Essential Tips for Safe and Enjoyable Eating", "Managing food allergies can be challenging, but with the right knowledge and precautions, it's possible to enjoy meals safely. Stay informed about label reading, cross-contamination risks, and alternative ingredients to ensure a well-rounded diet."),
            new Dashboard.Item("Breaking Down Food Allergy Myths: Separating Fact from Fiction", "As misconceptions about food allergies persist, it's crucial to dispel myths and promote accurate information. Learn about common misconceptions surrounding food allergies, such as the belief that only children are affected or that all reactions are immediate. Stay informed on the latest evidence-based insights to better understand the realities of living with food allergies.")
    };

    Dashboard.CardItem[] cardItems = {
            new Dashboard.CardItem("/assets/images/img3.png", "Peanuts: Peanut allergies are one of the most common and ... read more"),
            new Dashboard.CardItem("/assets/images/img2.png", "Eggs: Particularly the protein in egg whites, although some ... read more"),
            new Dashboard.CardItem("/assets/images/img1.png", "Fishes: Allergies to certain types of fish, such as salmon, tuna, ... read more"),
    };

    public Dashboard() {
        Div container = new Div(AllergyImage());
        container.addClassName("container");
        container.setWidthFull();

        Button recordButton = new Button("Record an allergy");
        recordButton.addClassName("record-button");
        recordButton.addClickListener(event -> UI.getCurrent().navigate("record-allergy-form"));

        container.add(recordButton);

        Div educationalContent = new Div();
        educationalContent.addClassName("educational-content");

        Div content = new Div();
        content.addClassName("content");


        Div commonFoodAllergy = new Div();
        commonFoodAllergy.addClassName("common-food-allergy");

        Div imageContent = new Div();
        imageContent.addClassName("image-content");

        for (Dashboard.Item item : items) {
            H4 title = new H4(item.getTitle());
            Paragraph description = new Paragraph(item.getDescription());
            content.add(title, description);
        }

        H3 leftCardTitle = new H3("Allergy management educational content");
        leftCardTitle.addClassName("card-title");
        educationalContent.add(leftCardTitle, content);

        for (Dashboard.CardItem cardItem : cardItems) {
            Paragraph description = new Paragraph(cardItem.getDescription());
            imageContent.add(getImage(cardItem.getImage(), "card-image"), description);
        }

        H3 rightCardTitle = new H3("Common food allergens");
        rightCardTitle.addClassName("right-card-title");
        commonFoodAllergy.add(rightCardTitle, imageContent);

        HorizontalLayout row = new HorizontalLayout();
        row.addClassName("flex-row");
        row.add(educationalContent, commonFoodAllergy);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(container, row);

        add(verticalLayout);
    }

    public Component AllergyImage() {
        StreamResource imageResource = new StreamResource("dashboard-img.png",
                () -> getClass().getResourceAsStream("/assets/images/dashboard-img.png"));

        Image image = new Image(imageResource, "image");
        image.addClassName("dashboard-image");

        return image;
    }

    public Component getImage(String src, String alt) {
        StreamResource imageResource = new StreamResource(alt,
                () -> getClass().getResourceAsStream(src));

        Image image = new Image(imageResource, "image");
        image.addClassName(alt);

        return image;
    }

    static class Item {
        private String title;
        private String description;

        public Item(String title, String description) {
            this.title = title;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }

    static class CardItem {
        private final String image;
        private final String description;

        public CardItem(String image, String description) {
            this.image = image;
            this.description = description;
        }

        public String getImage() {
            return image;
        }

        public String getDescription() {
            return description;
        }
    }
}
