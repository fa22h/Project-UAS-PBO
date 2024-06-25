/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;

import model.ProportionToSize;
import model.SamplingMethod;
import model.SimpleWOR;
import model.SimpleWR;
import model.Systematic;
/**
 *
 * @author fatih
 */
public class SamplingController {
    private List<String[]> population;
    private int sampleCount;
    private SamplingMethod sm;

    public SamplingController(List<String[]> population, String samplingMethod, int sampleCount){
        this.population = population;
        this.sampleCount = sampleCount;
        if(samplingMethod.equalsIgnoreCase("srs wr")){
            sm = new SimpleWR();
        }
        else if(samplingMethod.equalsIgnoreCase("srs wor")){
            sm = new SimpleWOR();
        }
        else if(samplingMethod.equalsIgnoreCase("systematic")){
            sm = new Systematic();
        }
        else if(samplingMethod.equalsIgnoreCase("pps")){
            sm = new ProportionToSize();
        }
    }

    public void setSizeIndex(int size) {
        sm.setSizeIndex(size);
    }
    
    public List<String[]> getSamples(){
        List<String[]> samples = sm.getSample(population, sampleCount, population.size());
        return samples;
    }
}
