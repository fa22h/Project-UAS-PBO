/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fatih
 */
public class CSVReader {
    private String path;
    private String delimiter = ",";
    private String[] headers;
    private List<String[]> values = new ArrayList<String[]>();

    public CSVReader(String path){
        this.path = path;
        readFile();
    }

    public String[] getHeaders() {
        return headers;
    }

    public List<String[]> getValues() {
        return values;
    }

    private void readFile(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));){
            //Skip Byte Order Mark kalau ada
            if(br.ready() && br.markSupported()){
                br.mark(1);
                if(br.read() != '\uFEFF'){
                    br.reset();
                }
            }

            String headerLine = br.readLine();

            if(headerLine != null){
                //Simpan header
                headers = headerLine.split(delimiter);
                //Simpan value
                String row;
                while((row = br.readLine()) != null){
                    values.add(row.split(delimiter));
                }
            }
/*
            //TODO: Hapus test
            for (String string : headers) {
                System.out.print(string + " ");
            }
            for (String[] string : values) {
                for (String string2 : string) {
                    System.out.print(string2 + " ");
                }
                System.out.println();                
            }
*/
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        
    }
}
