package com.example.application.views.pages.profile;

import com.example.application.views.component.upload1.uploadSet;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;

import javax.swing.*;

@CssImport("./themes/frontend/settings.css")
public class settingsForm extends VerticalLayout {

    private final VerticalLayout topLayer = new VerticalLayout();
    private final HorizontalLayout names = new HorizontalLayout();
    private final HorizontalLayout second = new HorizontalLayout();
    private final Div form = new Div();

    private final TextField firstname = new TextField("First name");
    private final TextField secondname = new TextField("Second name");
    private final EmailField email = new EmailField("Email");

    private final DatePicker date = new DatePicker("Date of birth");
    private final RadioButtonGroup<String> gender = new RadioButtonGroup<>();
    private final NumberField phone = new NumberField("Phone");
    private final Image image = new Image();
    private final MemoryBuffer buffer = new MemoryBuffer();
    private final Upload upload = new Upload(buffer);

    public settingsForm() {
        addClassName("form");
        email.addClassName("email");
        phone.addClassName("phone");

        H2 headText = new H2("Personal Info");
        headText.addClassName("head-txt");
        H4 subText = new H4("Tell Us a bit about yourself. This information will appear on your profile");
        subText.addClassName("sub-txt");

        Div line = new Div();
        line.addClassName("line");

        topLayer.add(headText, subText, line);

        uploadSet i18n = new uploadSet();
        i18n.getAddFiles().setOne("Select image..");
        i18n.getDropFiles().setOne("Drop image here");
        i18n.getError().setIncorrectFileType(
                "The provided file does not have the correct format (PNG && JPG).");
        upload.setI18n(i18n);


        upload.setDropLabelIcon(VaadinIcon.PICTURE.create());

        upload.setAcceptedFileTypes("image/jpeg", "image/png");
        upload.addSucceededListener(event -> {
//            image.setSrc(buffer.getInputStream());
            image.setVisible(true);
        });
        upload.addClassName("upload");



        gender.setLabel("Gender");
        gender.setItems("Male", "Female");

        Button btn = new Button("Update");
        btn.addClassName("btn");
//        btn.addClickListener(event -> {
//            SettingsFormDTO settingsFormDTO = new SettingsFormDTO(
//                    firstname.getValue(),
//                    secondname.getValue(),
//                    email.getValue(),
//                    date.getValue(),
//                    gender.getValue(),
//                    phone.getValue()
//            );

        names.add(firstname, secondname, email);
        names.addClassName("firstDiv");
        second.add(date, gender, phone);
        second.addClassName("secondDiv");

//        image.setVisible(false);
        form.add(upload,image ,names, second, btn);

//        image.setVisible(false);
//        form.add(image);

        add(topLayer, form);
    }




}
