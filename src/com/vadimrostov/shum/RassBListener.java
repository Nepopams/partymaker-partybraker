package com.vadimrostov.shum;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vadim on 10.08.2016.
 */
public class RassBListener implements ActionListener{
    ShumData data;
    String[][]t;
    String []k;
    JLabel graphic;
    int degrass;
    HashMap<Double,Double> rassmap;

    public RassBListener(ShumData data, String[][] t, String[] k, JLabel graphic, int degrass) {
        this.data = data;
        this.t = t;
        this.k = k;
        this.graphic = graphic;
        this.degrass = degrass;
    }


    public void actionPerformed(ActionEvent e) {
        rassmap=data.pgaksSolution(degrass);
        int i=0;
        for(Map.Entry<Double,Double> pair :rassmap.entrySet()  ){
            String[]b={pair.getKey().toString(), pair.getValue().toString()};
            t[i]=b;
            i++;



        }
        new PShumTableCheck().createUI(t, k);
        new PlotResultsShum("pgak", "p", rassmap);
        graphic.setVisible(true);

    }
}
