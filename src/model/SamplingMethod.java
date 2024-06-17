/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;
import java.util.List;

/**
 *
 * @author fatih
 */
public abstract class SamplingMethod {
    public int[] getRandomInt(int sampleCount, int populationCount){
        //cek jumlah angka random yang ingin didapat
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

    abstract List<String[]> getSample(List<String[]> samples, int jumlahSampel, int jumlahData);
}
