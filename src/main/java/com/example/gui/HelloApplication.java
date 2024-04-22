package com.example.gui;
import com.db.gui.DB;

import com.db.gui.PersonDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;



import java.io.IOException;

import static javafx.application.Application.launch;


public class HelloApplication extends Application   {
    Label labelField;
    TextArea textArea;
    TextField textField;
    Button button;

    private Map<String, Label> dayToDos;

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        HelloController helloController = fxmlLoader.getController();
        helloController.setPrimaryStage(stage);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();

    }

}