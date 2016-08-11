package com.vadimrostov.shum;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vadim on 08.08.2016.
 */
public class ShumData {
    JButton rass;
    JComboBox comboBox;

    public ShumData(JButton rass, JComboBox comboBox) {
        this.rass = rass;
        this.comboBox = comboBox;
    }

    private boolean hnb=false, kkb=false, svb=false, smb=false, psd=false, psvb=false;
    HashMap<Integer,Double> sm1=  new HashMap<>();
    HashMap<Integer,Double> sm2=  new HashMap<>();
    HashMap<Integer,Double> sm3=  new HashMap<>();
    HashMap<Integer,Double> sm4=  new HashMap<>();
    HashMap<Integer,Double> sm5=  new HashMap<>();
    HashMap<Integer,Double> sv=  new HashMap<>();
    HashMap<Integer,Double> hn=  new HashMap<>();
    HashMap<Integer,Double> kk=  new HashMap<>();
    HashMap<Double, Double> psm = new HashMap<>();
    HashMap<Double, Double> psv = new HashMap<>();


    public void setPsd(boolean psd) {
        this.psd = psd;
    }

    public void setPsvb(boolean psvb) {
        this.psvb = psvb;
    }

    public void setHnb(boolean hnb) {
        this.hnb = hnb;
    }

    public void setKkb(boolean kkb) {
        this.kkb = kkb;
    }

    public void setSvb(boolean svb) {
        this.svb = svb;
    }

    public void setSmb(boolean smb) {
        this.smb = smb;
    }

    public boolean isHnb() {
        return hnb;
    }

    public boolean isKkb() {
        return kkb;
    }

    public boolean isSvb() {
        return svb;
    }

    public boolean isSmb() {
        return smb;
    }

    public boolean isPsd() {
        return psd;
    }

    public boolean isPsvb() {
        return psvb;
    }

    public double plus(){

        return 0;
    }

    public HashMap<Double,Double> pgaksSolution(int deg){

        HashMap<Double,Double> pgak =new HashMap<>();




        for(Map.Entry<Double,Double> pair:psm.entrySet()){
            double c= pgaksmalj(psmalSolution(deg), deg).get(pair.getKey())+pgakvalj(pvalSolution(deg), deg).get(pair.getKey());
            pgak.put(pair.getKey(),c);
        }




        return pgak;
    }

    public HashMap<Double,Double> pgaksmalj(HashMap<Double,Double> hash,int deg) {
        HashMap<Double, Double> pgaksmalj = new HashMap<>();
        for (Map.Entry<Double, Double> pair : hash.entrySet()) {
            double c = pair.getValue() + 20 * Math.log10(Math.sqrt(400 * 8000) / Math.sqrt(900)) + 20 * Math.log10(hn.get(deg) + 10 * Math.log10(kk.get(deg)));
            pgaksmalj.put(pair.getKey(), c);
        }
        return pgaksmalj;
    }

    public HashMap<Double,Double> pgakvalj(HashMap<Double,Double> hash,int deg){
        HashMap<Double,Double>pgakvalj=new HashMap<>();
        for(Map.Entry<Double,Double>pair:hash.entrySet()){
            double c=pair.getValue()+20*Math.log10(Math.sqrt(400*8000)/Math.sqrt(900))+20*Math.log10(hn.get(deg)+10*Math.log10(kk.get(deg)));
            pgakvalj.put(pair.getKey(),c);
        }


        return pgakvalj;
    }
    public HashMap<Double,Double> psmalSolution(int deg){
        HashMap<Double, Double> psmal=new HashMap<>();
        for(Map.Entry<Double,Double> pair: psm.entrySet()){
            psmal.put(pair.getKey(), pair.getValue()-sm1.get(deg));
        }
        return psmal;
    }
    public HashMap<Double,Double> pvalSolution(int deg){
        HashMap<Double, Double> pval=new HashMap<>();
        for(Map.Entry<Double,Double> pair: psv.entrySet()){
            pval.put(pair.getKey(), pair.getValue()-sm1.get(deg));
        }
        return pval;
    }



public String pShumMeh(){
return ""+psm.get(400.0);

}
}
