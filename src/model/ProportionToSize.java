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
public class ProportionToSize extends SamplingMethod{
    private int cummulative = 0;
    private List<Integer> size = new ArrayList<Integer>();
    private int[] cummulativeIndex;

    public ProportionToSize(){
    }

    public List<String[]> getSample(List<String[]> population, int sampleCount, int populationCount){
        cummulativeIndex = new int[population.size()];
        setCummulative(population);
        
        int[] randInts = getRandomInt(sampleCount, cummulative);

        List<String[]> selectedSamples = new ArrayList<String[]>();
        for(int i = 0; i < sampleCount; i++){
            int j = 0;
            while(randInts[i] > cummulativeIndex[j]){
                j++;
            }
            selectedSamples.add(population.get(j));

        }

        return selectedSamples;
    }

    private void setCummulative(List<String[]> population){
        setSize(population);
        int i = 0;
        if(size != null){
            for (Integer integer : size) {
                cummulative += integer;
                cummulativeIndex[i] = cummulative;
                i++;
            }
        }
    }

    private void setSize(List<String[]> population){
        try {
            for (String[] strings : population) {
                size.add(Integer.parseInt(strings[super.getSizeIndex()]));
            }
        } catch (NumberFormatException e) {
            size = null;
        }
    }
}
