/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author fatih
 */
public class DatabaseConnection {

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\model\\database.db");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
