package com.example.springbootimageuploader.gui;

import com.example.springbootimageuploader.ImageUploader;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


@Route("uploadImage")  //vaadin endpoint should not have "/"
public class UploadGUI extends VerticalLayout {

    private ImageUploader imageUploader;
    private String imageFilePath;


    @Autowired
    public UploadGUI(ImageUploader imageUploader) {
        this.imageUploader = imageUploader;
        Button button = new Button("Choose file:");
        Button button1 = new Button("Upload!");
        Label label = new Label();
        Label label1 = new Label();

        button.addClickListener(buttonClickEvent -> {
            imageFilePath = imageUploader.chooseFile();
            label1.setText("Wybrałeś obrazek z: " + imageFilePath);
            add(label1);
        });


        button1.addClickListener(buttonClickEvent -> {
            String uploadedImageUrl = imageUploader.uploadFile(imageFilePath);

            Image image = new Image(uploadedImageUrl, "Nie ma obrazka!:(");

            label.setText("Udało się wrzucić obrazek!");
            add(label);
            imageUploader.saveImageToDB(uploadedImageUrl);
            add(image);
        });
        add(button, button1);
    }

}
