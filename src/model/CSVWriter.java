/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author fatih
 */
public class CSVWriter {
    public boolean writeCSV(String path, String[] headers, List<String[]> values){
        try(FileWriter fileWriter = new FileWriter(path + "\\output.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter)){
            
            //headers
            printWriter.println(String.join(",", headers));
            //Data
            for (String[] value : values) {
                printWriter.println(String.join(",", value));
            }  

        }catch(IOException e){
            return false;
        }

        return true;
    }
}
