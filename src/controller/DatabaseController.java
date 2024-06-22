/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DatabaseConnection;

/**
 *
 * @author fatih
 */
public class DatabaseController {
    public boolean saveToDatabase(String user_ID, String[] headers, List<String[]> values, String tableName){
        DatabaseConnection dc = new DatabaseConnection();
        try(Connection connection = dc.getConnection(System.getProperty("user.dir") + "\\src\\model\\database\\data_user" + user_ID  + ".db");
            Statement stmt = connection.createStatement()) {
            
            //cek apakah nama tabel sudah ada
            if(!tableIsExist(tableName, connection)){
                StringBuilder sql = new StringBuilder("CREATE TABLE ");

                sql.append(tableName).append(" (");
                for(int i = 0; i < headers.length; i++){
                    sql.append(headers[i]).append(" TEXT");
                    if(i < headers.length - 1){
                        sql.append(", ");
                    }
                }
                sql.append(");");
    
                stmt.execute(sql.toString());
            }
            else{
                return false;
            }

            StringBuilder sqlInsert = new StringBuilder("INSERT INTO ");
            sqlInsert.append(tableName).append(" VALUES ");
            for (int i = 0; i < values.size(); i++) {
                String[] strings = values.get(i);
                sqlInsert.append("(");
                for (int j = 0; j < strings.length; j++) {
                    sqlInsert.append("'").append(strings[j].replace("'", "''")).append("'");
                    if (j < strings.length - 1) {
                        sqlInsert.append(", ");
                    }
                }
                sqlInsert.append(")");
                if (i < values.size() - 1) {
                    sqlInsert.append(", ");
                }
            }
            sqlInsert.append(";");

            stmt.execute(sqlInsert.toString());
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    private boolean tableIsExist(String tableName, Connection conn){
        String query = "SELECT name FROM sqlite_master WHERE type = 'table' AND name='" + tableName + "';";

        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)){
            if(rs.next()){
                return true;
            }

            return false;
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    //Ambil tabel yang ada di dalam database user
    public List<String> getTable(String path){
        List table = new ArrayList<String>();
        DatabaseConnection dc = new DatabaseConnection();
        try(Connection connection = dc.getConnection(path);
            Statement stmt = connection.createStatement()){
            
            ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");
            while(rs.next()){
                table.add(rs.getString("name"));
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        
        return table;
    }

    //Return header dari tabel yang diinput
    public String[] getColumnName(String table, String path){
        String query = "SELECT * FROM " + table + " LIMIT 1;";
        List<String> columnList = new ArrayList<String>();
        DatabaseConnection dc = new DatabaseConnection();
        try(Connection conn = dc.getConnection(path);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);){
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int column = rsmd.getColumnCount();
            for(int i = 1; i < column; i++){
                columnList.add(rsmd.getColumnName(i));
            }

            return columnList.toArray(new String[0]);
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    //Return data dari tabel yang diinput
    public List<String[]> getData(String table, String path){
        List<String[]> data = new ArrayList<String[]>();
        String query = "SELECT * FROM " + table;
        DatabaseConnection dc = new DatabaseConnection();
        try(Connection conn = dc.getConnection(path);
            Statement stmt = conn.createStatement()){
            
            ResultSet rs = stmt.executeQuery(query);
            
            //Jumlah kolom dari data
            int column = rs.getMetaData().getColumnCount();
            
            while(rs.next()){
                List<String> row = new ArrayList<>();
                for(int i = 1; i < column; i++){
                    row.add(rs.getString(i));
                }
                data.add(row.toArray(new String[0]));
            }

            return data;
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }
}
