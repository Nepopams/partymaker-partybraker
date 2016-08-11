package com.vadimrostov.shum;


import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Vadim on 11.08.2016.
 */
public class PSMBListener implements  {



    String[][]kkt;
    String[] kktr;
    ShumData data;
    JButton psmm;

    public PSMBListener(String[][] kkt, String[] kktr, ShumData data, JButton psmm) {
        this.kkt = kkt;
        this.kktr = kktr;
        this.data = data;
        this.psmm=psmm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new ShumExcelParser().parsexls(data.psm, "c:/users/vadim/ideaprojects/rasschetmetodika/data/1.xls");


        psmm.addActionListener(new HNECBListener(data,kkt,kktr));
        psmm.setText("Проверить");

        //  b1.setVisible(false);
        //b2.setVisible(true);

        .setText("Данные введены верно");
        data.setHnb(true);
    }
}
