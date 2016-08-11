package com.vadimrostov.shum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Created by Vadim on 10.08.2016.
 */
public class KKECBListener implements ActionListener{
    ShumData data;
    String[][]kkt;
    String[]kktr;

    public KKECBListener(ShumData data, String[][] kkt, String[] kktr) {
        this.data = data;
        this.kkt = kkt;
        this.kktr = kktr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i=0;
        for(Map.Entry<Integer,Double> pair:data.kk.entrySet()){
            String[]b={pair.getKey().toString(), pair.getValue().toString()};
            kkt[i]=b;
            i++;
        }
        new PShumTableCheck().createUI(kkt, kktr);

    }
}
