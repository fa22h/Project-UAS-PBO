/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;

import model.CSVReader;
import model.CSVWriter;

/**
 *
 * @author fatih
 */
public class FileController {
    private String[] headers;
    private List<String[]> values;

    public String[] getHeaders() {
        return headers;
    }

    public List<String[]> getValues() {
        return values;
    }

    public boolean saveFileCSV(List<String[]> values, String[] headers){
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("Pilih lokasi untuk menyimpan output");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            CSVWriter cw = new CSVWriter();
            if(cw.writeCSV(chooser.getSelectedFile().toString(), headers, values)){
                return true;
            }
        }
        return false;
    }

    public boolean readFileCSV(String path){
        //Baca file csv, lalu simpan datanya
        try {
            CSVReader ch = new CSVReader(path);
            headers = ch.getHeaders();
            values = ch.getValues();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
