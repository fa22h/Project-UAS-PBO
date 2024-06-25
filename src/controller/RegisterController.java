/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DatabaseConnection;
import model.Hasher;

/**
 *
 * @author fatih
 */
public class RegisterController {
    private DatabaseConnection dc;

    public RegisterController(){
        dc = new DatabaseConnection();
    }

    public boolean register(String username, String password, String nama){

        String sql = "INSERT INTO user (username, password, nama) " +
                     "VALUES (?, ?, ?)";
        try(Connection conn = dc.getConnection(System.getProperty("user.dir") + "\\src\\model\\database\\database.db");
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, username);
            pstmt.setString(2, Hasher.getHash(password));
            pstmt.setString(3, nama);
            
            int i = pstmt.executeUpdate();

            if(i == 0){
                return false;
            }
            else{
                return true;
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }
}
