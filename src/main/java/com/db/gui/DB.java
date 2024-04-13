package com.db.gui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String url = "jdbc:sqlite::resource";

    private static Connection conn;
    public static Connection getConnection(){

        try{
            if(conn == null){
                conn = DriverManager.getConnection(url + DB.class.getResource("/src/main/java/com/db.gui/Tasks.db"));
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
