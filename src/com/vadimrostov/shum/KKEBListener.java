package com.vadimrostov.shum;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vadim on 10.08.2016.
 */
public class KKEBListener implements ActionListener{
    ShumData data;
    JButton b1,b2; JLabel label;
    String[][]kkt;
    String[]kktr;

    public KKEBListener(ShumData data, JButton b1, JLabel label,String[][]kkt, String[]kktr) {
        super();
        this.data=data;
        this.b1=b1;
        this.b2=b2;
        this.label=label;
        this.kkt=kkt;
        this.kktr=kktr;
    }

    @Override


    public void actionPerformed(ActionEvent e) {

        new ShumExcelParser().parsexls1(data.kk, "c:/users/vadim/ideaprojects/rasschetmetodika/data/kk.xls");
        b1.addActionListener(new KKECBListener(data,kkt,kktr));
        b1.setText("Проверить");
        label.setText("Данные введены верно");
        data.setKkb(true);





    }
}
