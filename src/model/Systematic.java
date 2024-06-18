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
public class Systematic extends SamplingMethod{
    public Systematic(){
        super();
    }

    public List<String[]> getSample(List<String[]> population, int sampleCount, int populationCount){
        int k = populationCount/sampleCount;
        int startIndex = super.getRandomInt(1, k)[0];

        //Ambil sampel
        List<String[]> samples = new ArrayList<String[]>();
        for(int i = startIndex; i < populationCount; i +=k){
            samples.add(population.get(i));
            if(samples.size() == sampleCount){
                break;
            }
        }

        return samples;
    }
}
