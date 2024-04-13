package com.db.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO{
    public void toRead(){
        Connection conn = DB.getConnection();
        String sql = "SELECT * FROM Tasks";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
