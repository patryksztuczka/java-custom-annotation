package com.application.lab5;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    ImageView imageView;

    @FXML
    TextField inputText;

    @FXML
    Button confirmButton;

    private String text;

    Test test = new Test(text);
    Class<Test> testClass = Test.class;
    MyPattern ann = testClass.getDeclaredField("beanText").getAnnotation(MyPattern.class);
    MyPatternValidator myPatternValidator = new MyPatternValidator(ann);

    public Controller() throws NoSuchFieldException {
    }

    @FXML
    public void inputValidationHandler(){
        text = inputText.getText();
        test.setBeanText(text);
        myPatternValidator.validate(test.getBeanText());
        Tooltip tooltip = new Tooltip(myPatternValidator.getMessage());
        if(myPatternValidator.isValid()){
            imageView.setImage(new Image("C:\\Users\\Patryk Sztuczka\\Documents\\PBS\\Semestr IV\\Zaawansowane programowanie obiektowe\\lab5\\src\\main\\resources\\com\\application\\lab5\\true.jpg"));
            Tooltip.uninstall(imageView, tooltip);
            confirmButton.setDisable(false);
        } else {
            imageView.setImage(new Image("C:\\Users\\Patryk Sztuczka\\Documents\\PBS\\Semestr IV\\Zaawansowane programowanie obiektowe\\lab5\\src\\main\\resources\\com\\application\\lab5\\false.jpg"));
            Tooltip.install(imageView, tooltip);
            confirmButton.setDisable(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirmButton.setDisable(true);
    }
}