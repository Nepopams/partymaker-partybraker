package com.vadimrostov.shum;

import java.util.HashMap;

/**
 * Created by Vadim on 08.08.2016.
 */
public class ShumData {
    HashMap<Integer,Double> sm1=  new HashMap<>();
    HashMap<Integer,Double> sm2=  new HashMap<>();
    HashMap<Integer,Double> sm3=  new HashMap<>();
    HashMap<Integer,Double> sm4=  new HashMap<>();
    HashMap<Integer,Double> sm5=  new HashMap<>();
    HashMap<Integer,Double> sv=  new HashMap<>();
    HashMap<Integer,Double> hn=  new HashMap<>();
    HashMap<Integer,Double> kk=  new HashMap<>();
    HashMap<Integer, Double> psm1 = new HashMap<>();
    HashMap<Integer, Double> psm2 = new HashMap<>();
    HashMap<Integer, Double> psm3 = new HashMap<>();
    HashMap<Integer, Double> psm4 = new HashMap<>();
    HashMap<Integer, Double> psm5 = new HashMap<>();


    public double plus(){
        return kk.get(120)-sm2.get(0);
    }
public void pShumMeh(int deg, double pol){
psm1.put(deg, 45-sm1.get(deg));
    psm2.put(deg, 45-sm2.get(deg));
    psm3.put(deg, 45-sm3.get(deg));
    psm4.put(deg, 45-sm4.get(deg));
    psm5.put(deg, 45-sm5.get(deg));

}
}
