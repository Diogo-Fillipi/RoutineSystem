package com.example.gui;
import com.db.gui.DB;

import com.db.gui.PersonDAO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;



import java.io.IOException;
import java.util.Optional;

import static javafx.application.Application.launch;


public class HelloApplication extends Application   {

    Tab tab;

    private Map<String, VBox> dayToDos;

    public void start(Stage stage) throws IOException {
        //Create the TabPane and the Tabs
        TabPane tabPane = new TabPane();
        String[] days={"Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta Feira", "Consultar"};
        dayToDos = new HashMap<>();


        for (String day : days) {
            VBox vbox = new VBox();
            dayToDos.put(day, vbox);

            Button button = new Button("Adicionar um comentário");
            button.setOnAction(event -> addTask(tabPane, day));
            button.setPrefHeight(35);
            button.setPrefWidth(800);

            VBox dayContent = new VBox(button);
            dayContent.setAlignment(Pos.BOTTOM_CENTER);
            tabPane.getTabs().add(new Tab(day, dayContent));
        }


        Scene scene = new Scene(tabPane, 800, 600);
        stage.setScene(scene);
        stage.show();


    }


    public void addTask(TabPane tabPane, String days){

        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Escreva um comentário");
        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType, cancelButtonType);

        TextField textField = new TextField();
        Label label = new Label("Escreva um comentário para o dia " + days);
        VBox vBox = new VBox(label, textField);

        dialog.getDialogPane().setContent(vBox);

        dialog.setResultConverter(dialogButton -> {
            if(dialogButton == okButtonType){
                return textField.getText();
            }
            return null;
        });

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(comment -> {
            // Encontre o Tab correspondente ao dia
            TextField tabContent = new TextField(comment);
            tabContent.setEditable(false);
            Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
            VBox dayContent = (VBox) selectedTab.getContent();
            dayContent.getChildren().add(tabContent);

        });
    }
    public static void main(String[] args) {
        launch();

    }

}