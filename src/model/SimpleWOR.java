/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fatih
 */
public class SimpleWOR extends SamplingMethod{
    
    @Override
    public List<String[]> getSample(List<String[]> population, int sampleCount, int populationCount){
        //Ambil angka random unik
        int[] randNumber = super.getRandomUniqueInt(sampleCount, populationCount);
        if(randNumber == null){
            return null;
        }

        //Ambil sampel
        List<String[]> selectedSamples = new ArrayList<String[]>();
        for(int i = 0; i < sampleCount; i++){
            selectedSamples.add(population.get(randNumber[i]));
        }

        return selectedSamples;
    }
}
