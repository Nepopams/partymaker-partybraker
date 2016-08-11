package com.vadimrostov.shum;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vadim on 10.08.2016.
 */
public class SVEBListener implements ActionListener {
    ShumData data;
    JButton b1; JLabel label;
    String[][]kkt;
    String[]kktr;

    public SVEBListener(ShumData data, JButton b1, JLabel label, String[][] kkt, String[] kktr) {
        this.data = data;
        this.b1 = b1;
        this.label = label;
        this.kkt = kkt;
        this.kktr = kktr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new ShumExcelParser().parsexls1(data.sv, "c:/users/vadim/ideaprojects/rasschetmetodika/data/f2.xls");
        b1.addActionListener(new SVECBListener(data,kkt,kktr));
        b1.setText("Проверить");
        label.setText("Данные введены верно");
        data.setSvb(true);


    }
}
