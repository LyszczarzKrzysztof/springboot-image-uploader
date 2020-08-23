package com.example.springbootimageuploader;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.sun.deploy.appcontext.AppContext;
import javafx.application.Application;
import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.ApplicationContextFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class ImageTest {



    public static List<String> getStrings() {
        {

            List<String> listOfStrings = new ArrayList<>();

            Stream<String> stream;
            try {

                stream = Files.lines(Paths.get("cloudinary.txt"));
                stream.forEach(listOfStrings::add);

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return listOfStrings;
        }
    }

    public static void main(String[] args) throws IOException {

      List<String> list = getStrings();

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", list.get(0),
                "api_key", list.get(1),
                "api_secret", list.get(2)));

        File file = new File("image2.png");
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

    }


}
