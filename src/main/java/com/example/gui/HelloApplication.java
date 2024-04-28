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

    private Map<String, Label> dayToDos;

    public void start(Stage stage) throws IOException {
        //Create the TabPane and the Tabs
        TabPane tabPane = new TabPane();
        String[] days={"Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta Feira", "Consultar"};

        for(int i = 0; i<days.length; i++ ){
            VBox vbox = new VBox();
            Button button = new Button("Adicionar um comentário");
            button.setOnAction(event -> {
                addTask(tabPane, days[0]);
            });
            button.setPrefHeight(35);
            button.setPrefWidth(800);

            vbox.setAlignment(Pos.BOTTOM_CENTER);
            vbox.getChildren().add(button);

            tab = new Tab(days[i]);
            tab.setClosable(false);
            tab.setContent(vbox);
            tabPane.getTabs().add(tab);
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
            for (Tab tab : tabPane.getTabs()) {
                if (tab.getText().equals(days)) {
                    TextArea tabContent = new TextArea();
                    tabContent.setText(comment);
                    tab.setContent(tabContent);
                    break;
                }
            }
        });
    }
    public static void main(String[] args) {
        launch();

    }

}