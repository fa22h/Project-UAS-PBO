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
import model.User;

/**
 *
 * @author fatih
 */
public class LoginController {
    private User user;
    private DatabaseConnection dc;

    public LoginController(){
        dc = new DatabaseConnection();
        user = new User();
    }
    
    public User getUser(){
        return user;
    }

    public boolean isRegistered(String username, String password){
            String username_db = "";
            String password_db = "";
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
                user.setUserId(rs.getString("user_id"));
                user.setNama(rs.getString("nama"));
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
            System.err.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
