
package com.vadimrostov.shum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Vadim on 04.08.2016.
 */


public class Shum {


    ShumFieldsFactory frame;
    public Shum() {
frame=new ShumFieldsFactory();
        frame.setSize(640,1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public ShumFieldsFactory getFrame() {
        return frame;
    }

    public static void main(String[] args){

        Shum frame=new Shum();





    }

}

