/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.CSVReader;
import model.CSVWriter;

/**
 *
 * @author fatih
 */
public class FileController {
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
}
