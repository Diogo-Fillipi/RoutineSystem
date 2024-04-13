package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.EventListener;

public class HelloController {
    private Stage primaryStage;
    public void setPrimaryStage(Stage stage){
        this.primaryStage = stage;
    }

    private Stage dialogStage;
    private Scene scene;
    private Parent root;
    public void addTask(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("comment.fxml"));
        root = loader.load();
        dialogStage = new Stage();
        dialogStage.initOwner(primaryStage);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initStyle(StageStyle.UNDECORATED);
        dialogStage.setScene(new Scene(root));
        dialogStage.showAndWait();



    }

}