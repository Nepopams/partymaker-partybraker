package com.vadimrostov.shum;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vadim on 09.08.2016.
 */
public class PShumTableCheck extends JFrame{
    JPanel panel;
    JTable table;
    public PShumTableCheck() throws HeadlessException {
        super("Check data");
        this.setSize(550, 900);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
            }

    public void createUI(String[][]tabled,String[]row){

        panel=new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setLayout(null);

        table=new JTable(tabled, row);
        table.setBounds(5,5,300,400);
        panel.add(table);


        getContentPane().add(panel);

    }
}
