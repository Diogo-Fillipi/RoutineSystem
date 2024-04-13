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


public class HelloApplication {
    Label labelField;
    TextArea textArea;
    TextField textField;
    Button button;

    private Map<String, Label> dayToDos;

    /*public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        HelloController helloController = fxmlLoader.getController();
        helloController.setPrimaryStage(stage);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }*/

    public static void initTable(){
        try{
            Connection conn = DB.getConnection();
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("drop table if exists Tasks");
            statement.executeUpdate("create table if not exists Tasks(id integer, name string)");
            statement.executeUpdate("insert into Tasks values(1, 'leo')");
            statement.executeUpdate("insert into Tasks values(2, 'yui')");


        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //launch();
        initTable();
        PersonDAO personDAO = new PersonDAO();
        personDAO.toRead();
    }

}