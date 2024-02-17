package com.example.application.views.component.settingsForm;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;

@CssImport("./themes/frontend/settings.css")

public class settingsForm extends VerticalLayout {

    VerticalLayout toplayer = new VerticalLayout();
    HorizontalLayout names = new HorizontalLayout();


    HorizontalLayout second = new HorizontalLayout();
    Div form = new Div();

    TextField firstname = new TextField("First name");
    TextField secondname = new TextField("Second name ");

    EmailField email = new EmailField("Email");
    DatePicker date = new DatePicker("Date of birth");
    RadioButtonGroup gender = new RadioButtonGroup<>("Gender");
    NumberField phone = new NumberField("Phone");
    private Image image;
    private MemoryBuffer buffer;

    public settingsForm(){
        addClassName("form");

        H2 headText = new H2("Personal Info");
        headText.addClassName("head-txt");
        H4 subText = new H4("Tell Us a bit about yourself. This information will appear on your profile");
        subText.addClassName("sub-txt");

        Div line = new Div();
        line.addClassName("line");

        toplayer.add(headText,subText,line);

        Upload pic = new Upload(buffer);
        pic.addClassName("upload");
        pic.setAcceptedFileTypes("image/jpeg", "image/png");


        gender.setLabel("Gender");
        gender.setItems("Male", "Female");


        Button btn  = new Button("Update");
        btn.addClassName("btn");


       names.setDefaultVerticalComponentAlignment(Alignment.END);
       second.setDefaultVerticalComponentAlignment(Alignment.END);


       names.add(firstname,secondname, email);
       names.addClassName("firstDiv");
       second.add(date,gender,phone);
       second.addClassName("secondDiv");


        form.add(pic,names,second,btn);

        add(toplayer,form);
    }
}
