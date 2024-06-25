/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.DatabaseConnection;
import model.Hasher;

/**
 *
 * @author fatih
 */
public class LoginController {
    private String username_db;
    private String password_db;
    private String user_id;
    private String nama;
    private DatabaseConnection dc;

    public LoginController(){
        dc = new DatabaseConnection();
    }

    public String getUser_id() {
        return user_id;
    }

    public String getNama() {
        return nama;
    }

    public boolean isRegistered(String username, String password){
        try{
            Connection connection = dc.getConnection(System.getProperty("user.dir") + "\\src\\model\\database\\database.db");
            String sql = "SELECT * FROM user WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();
            
            if(!rs.isBeforeFirst()){
                return false;
            }

            while(rs.next()){
                username_db = rs.getString("username");
                password_db = rs.getString("password");
                user_id = rs.getString("user_id");
                nama = rs.getString("nama");
            }

            rs.close();
            preparedStatement.close();
            connection.close();

            if(username.equals(username_db) && Hasher.getHash(password).equals(password_db)){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            return false;
        }
    }

}
