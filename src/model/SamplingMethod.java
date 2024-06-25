/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author fatih
 */
public abstract class SamplingMethod {
    private int sizeIndex;
    public int[] getRandomInt(int sampleCount, int populationCount){
        if(sampleCount < 1){
            return null;
        }

        int[] randomNumber = new int[sampleCount];
        Random rand = new Random();
        
        for(int i = 0; i < sampleCount; i++){
            randomNumber[i] = rand.nextInt(populationCount);
        }

        return randomNumber;
    }

    public int[] getRandomUniqueInt(int sampleCount, int populationCount){
        if(sampleCount < 1){
            return null;
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        while(uniqueNumbers.size() < sampleCount){
            uniqueNumbers.add(new Random().nextInt(populationCount));
        }

        Integer[] samplesInteger = uniqueNumbers.toArray(new Integer[sampleCount]);
        int[] samplesInt = new int[sampleCount];
        for(int i = 0; i < sampleCount; i++){
            samplesInt[i] = samplesInteger[i].intValue();
        }

        return samplesInt;
    }

    public void setSizeIndex(int sizeIndex){
        this.sizeIndex = sizeIndex;
    }

    public int getSizeIndex(){
        return sizeIndex;
    }

    public abstract List<String[]> getSample(List<String[]> samples, int jumlahSampel, int jumlahData);
}
