package com.db.gui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static Connection conn;
    public static Connection getConnection(){

        try{
            if(conn == null){
                conn = DriverManager.getConnection("jdbc:sqlite::resource:" + "src/main/java/com/db/gui/Tasks.db");
                return conn;
            }else{
                return conn;
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

}
