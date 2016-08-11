package com.vadimrostov.shum;

import org.jfree.ui.RefineryUtilities;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vadim on 08.08.2016.
 */
public class ShumFieldsFactory extends JFrame{

   JLabel area,t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, l1, l2, k1, k2, k3, k4 ,k5, k6, k7, l3, f1,f2,f3,f4,f5,f6,f7, l4, graphic;
   JPanel panel;
    JTextField tt1,tt2,tt3,tt4,tt5,tt6,tt7, tt8, tt9, tt10, tt11, tt12, tt13, tt14,kk1, kk2, kk3, kk4, kk5, kk6, kk7, sm11,sm12,sm13,sm14,sm15,sm16,sm17,sm21,sm22,sm23,sm24,sm25,sm26,sm27,sm31,sm32,sm33,sm34,sm35,sm36,sm37,sm41,sm42,sm43,sm44,sm45,sm46,sm47,sm51,sm52,sm53,sm54,sm55,sm56,sm57;
 JButton sm, sv, hn, kk, rass, psm, psmchck,kkch, psv, psvchck, kkexcel, kkechk, hnexcel, sve;

    ImageIcon graph;

    HashMap<Double,Double> rassmap;
    JTable table;
    double sm1, sm2, sm3, sm4, sm5, sm6, sm7;
    JComboBox comboBox;
    ShumData data = new ShumData(rass, comboBox);


    String[][]t=new String[15][], kkt=new String[7][];
    String[]k={"f","p"}, kktr={"Deg","kk"};
    String[] deg={"0", "30", "45","60","90","120","140"};

    int degrass=0;

    public void isAllBoolean(){
        if (data.isSvb()&&data.isSmb()&&data.isHnb()&&data.isKkb()&&data.isPsd()&&data.isPsvb()) {
            rass.setVisible(true);
            comboBox.setVisible(true);
        }
    }



    public ShumData getData() {
        return data;
    }



    public void setDegrass(int degrass) {
        this.degrass = degrass;
    }

    public ShumFieldsFactory() throws HeadlessException {
        super("Test");
        createui();

    }

    public void createui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setLayout(null);


        //параметры рассчета
        comboBox = new JComboBox(deg);
        comboBox.setBounds(100,400,366,40);
        comboBox.addActionListener(new CBActionlistener());
        comboBox.setVisible(false);
        panel.add(comboBox);


        rass = new JButton("Рассчет");
        rass.setBounds(400,365,100,20);
        rass.addActionListener(new RassBListener(data, t, k, graphic, degrass));
        panel.add(rass);
        rass.setVisible(false);

        //данные подводный шум механизмов

        psm = new JButton("Загрузить данные Подводный шум Мех");
        psm.setBounds(100, 50, 286, 20);
        psm.addActionListener(new PSMBListener(t,k,data, psm));
        panel.add(psm);

        //данные подводный шум винта
        psv = new JButton("Загрузить данные Подводный шум Винт");
        psv.setBounds(100, 25, 286, 20);
        psv.addActionListener(new PSVBListener());
        panel.add(psv);

        //excel данные кк
        kkexcel=new JButton("Загрузить excel");
        kkexcel.setBounds(391,295,200,20);
        kkexcel.addActionListener(new KKEBListener(data, kkexcel,area, kkt,kktr));
        panel.add(kkexcel);

        //excel данные хн
        hnexcel=new JButton("Загрузить excel");
        hnexcel.setBounds(391, 250, 200, 20);
        hnexcel.addActionListener(new HNEBListener(data,hnexcel,area,kkt,kktr));
        panel.add(hnexcel);

        //excel data шум винтов передаточные
        sve=new JButton("Загрузить excel");
        sve.setBounds(391,200,200,20);
        sve.addActionListener(new SVEBListener(data,sve,area,kkt,kktr));
        panel.add(sve);




        //таблица

        psvchck=new JButton("Проверить данные Подводный Шум Винт");
        psvchck.setBounds(100, 25, 286, 20);
        psvchck.addActionListener(new PSMCBListener());
        panel.add(psvchck);
        psvchck.setVisible(false);

        psmchck=new JButton("Проверить данные Подводный Шум Мех");
        psmchck.setBounds(100, 50, 286, 20);
        psmchck.addActionListener(new PSMCBListener());
        panel.add(psmchck);
        psmchck.setVisible(false);
       /* table=new JTable(t, k);
        table.setBounds(100,480,300,400);
        panel.add(table);
        table.setVisible(false);*/

        //график
        graphic=new JLabel();
        graphic.setBounds(0,450,640,480);
        graph=new ImageIcon("XYLineChart.jpeg");
        graphic.setIcon(graph);
        panel.add(graphic);
        graphic.setVisible(false);


        //шум механизмов
        createField(l4, 20,-20,70,20,"Ф1альфа");
        createField(f1, 100, -40, 40, 20, "0°");
        createField(f2, 141,-40,40,20, "30°");
        createField(f3, 182,-40,40,20, "45°");
        createField(f4, 223,-40,40,20, "60°");
        createField(f5, 264,-40,40,20, "90°");
        createField(f6, 305,-40,40,20, "120°");
        createField(f7, 346,-40,40,20, "140°");

        sm11=new JTextField();
        sm11.setBounds(100, 100, 40, 20);
        panel.add(sm11);


        sm12=new JTextField();
        sm12.setBounds(141,100,40,20);
        panel.add(sm12);

        sm13=new JTextField();
        sm13.setBounds(182, 100, 40, 20);
        panel.add(sm13);

        sm14=new JTextField();
        sm14.setBounds(223, 100, 40, 20);
        panel.add(sm14);


        sm15=new JTextField();
        sm15.setBounds(264, 100, 40, 20);
        panel.add(sm15);


        sm16=new JTextField();
        sm16.setBounds(305, 100, 40, 20);
        panel.add(sm16);

        sm17=new JTextField();
        sm17.setBounds(346, 100, 40, 20);
        panel.add(sm17);

        //createField(sm21, 100,0,40,20);
        sm21=new JTextField();
        sm21.setBounds(100, 120, 40, 20);
        panel.add(sm21);

        sm22=new JTextField();
        sm22.setBounds(141,120,40,20);
        panel.add(sm22);

        sm23=new JTextField();
        sm23.setBounds(182, 120, 40, 20);
        panel.add(sm23);

        sm24=new JTextField();
        sm24.setBounds(223, 120, 40, 20);
        panel.add(sm24);


        sm25=new JTextField();
        sm25.setBounds(264, 120, 40, 20);
        panel.add(sm25);


        sm26=new JTextField();
        sm26.setBounds(305, 120, 40, 20);
        panel.add(sm26);

        sm27=new JTextField();
        sm27.setBounds(346, 120, 40, 20);
        panel.add(sm27);

        /*createField(sm22, 141,0,40,20);
        createField(sm23, 182,0,40,20);
        createField(sm24, 223,0,40,20);
        createField(sm25, 264,0,40,20);
        createField(sm26, 305,0,40,20);
        createField(sm27, 346,0,40,20);*/


        //createField(sm31, 100,20,40,20);
        //createField(sm21, 100,0,40,20);

        sm31=new JTextField();
        sm31.setBounds(100, 140, 40, 20);
        panel.add(sm31);

        sm32=new JTextField();
        sm32.setBounds(141,140,40,20);
        panel.add(sm32);

        sm33=new JTextField();
        sm33.setBounds(182, 140, 40, 20);
        panel.add(sm33);

        sm34=new JTextField();
        sm34.setBounds(223, 140, 40, 20);
        panel.add(sm34);


        sm35=new JTextField();
        sm35.setBounds(264, 140, 40, 20);
        panel.add(sm35);


        sm36=new JTextField();
        sm36.setBounds(305, 140, 40, 20);
        panel.add(sm36);

        sm37=new JTextField();
        sm37.setBounds(346, 140, 40, 20);
        panel.add(sm37);

       /* createField(sm32, 141,20,40,20);
        createField(sm33, 182,20,40,20);
        createField(sm34, 223,20,40,20);
        createField(sm35, 264,20,40,20);
        createField(sm36, 305,20,40,20);
        createField(sm37, 346,20,40,20);*/
      /*  createField(sm41, 100,40,40,20);
        createField(sm42, 141,40,40,20);
        createField(sm43, 182,40,40,20);
        createField(sm44, 223,40,40,20);
        createField(sm45, 264,40,40,20);
        createField(sm46, 305,40,40,20);
        createField(sm47, 346,40,40,20);*/
        sm41=new JTextField();
        sm41.setBounds(100, 160, 40, 20);
        panel.add(sm41);

        sm42=new JTextField();
        sm42.setBounds(141,160,40,20);
        panel.add(sm42);

        sm43=new JTextField();
        sm43.setBounds(182, 160, 40, 20);
        panel.add(sm43);

        sm44=new JTextField();
        sm44.setBounds(223, 160, 40, 20);
        panel.add(sm44);


        sm45=new JTextField();
        sm45.setBounds(264, 160, 40, 20);
        panel.add(sm45);


        sm46=new JTextField();
        sm46.setBounds(305, 160, 40, 20);
        panel.add(sm46);

        sm47=new JTextField();
        sm47.setBounds(346, 160, 40, 20);
        panel.add(sm47);

       /* createField(sm51, 100,60,40,20);
        createField(sm52, 141,60,40,20);
        createField(sm53, 182,60,40,20);
        createField(sm54, 223,60,40,20);
        createField(sm55, 264,60,40,20);
        createField(sm56, 305,60,40,20);
        createField(sm57, 346,60,40,20);
*/
        sm51=new JTextField();
        sm51.setBounds(100, 180, 40, 20);
        panel.add(sm51);

        sm52=new JTextField();
        sm52.setBounds(141,180,40,20);
        panel.add(sm52);

        sm53=new JTextField();
        sm53.setBounds(182, 180, 40, 20);
        panel.add(sm53);

        sm54=new JTextField();
        sm54.setBounds(223, 180, 40, 20);
        panel.add(sm54);


        sm55=new JTextField();
        sm55.setBounds(264, 180, 40, 20);
        panel.add(sm55);


        sm56=new JTextField();
        sm56.setBounds(305, 180, 40, 20);
        panel.add(sm56);

        sm57=new JTextField();
        sm57.setBounds(346, 180, 40, 20);
        panel.add(sm57);
        sm=new JButton("Запомнить");
        sm.setBounds(391,180,100,20);
        sm.addActionListener(new BListener());
        panel.add(sm);






        //шум винтов
        createField(l1, 20,100,70,20,"Ф2альфа");
        createField(t1, 100, 80, 40, 20, "0°");
        createField(t2, 141,80,40,20, "30°");
        createField(t3, 182,80,40,20, "45°");
        createField(t4, 223,80,40,20, "60°");
        createField(t5, 264,80,40,20, "90°");
        createField(t6, 305,80,40,20, "120°");
        createField(t7, 346,80,40,20, "140°");

      /*  createField(tt1, 100,100,40,20);
        createField(tt2, 141,100,40,20);
        createField(tt3, 182,100,40,20);
        createField(tt4, 223,100,40,20);
        createField(tt5, 264,100,40,20);
        createField(tt6, 305,100,40,20);
        createField(tt7, 346,100,40,20);*/
        tt1=new JTextField();
        tt1.setBounds(100, 220, 40, 20);
        panel.add(tt1);

        tt2=new JTextField();
        tt2.setBounds(141,220,40,20);
        panel.add(tt2);

        tt3=new JTextField();
        tt3.setBounds(182, 220, 40, 20);
        panel.add(tt3);

        tt4=new JTextField();
        tt4.setBounds(223, 220, 40, 20);
        panel.add(tt4);


        tt5=new JTextField();
        tt5.setBounds(264, 220, 40, 20);
        panel.add(tt5);


        tt6=new JTextField();
        tt6.setBounds(305, 220, 40, 20);
        panel.add(tt6);

        tt7=new JTextField();
        tt7.setBounds(346, 220, 40, 20);
        panel.add(tt7);

        sv = new JButton("Запомнить");
        sv.setBounds(391, 220, 100, 20);
        sv.addActionListener(new SvBListener());
        panel.add(sv);



        //хар-ка направленности
        createField(l2, 20,150,70,20,"Характеристика напр.");
        createField(t8, 100, 130, 40, 20, "0°");
        createField(t9, 141,130,40,20, "30°");
        createField(t10, 182,130,40,20, "45°");
        createField(t11, 223,130,40,20, "60°");
        createField(t12, 264,130,40,20, "90°");
        createField(t13, 305,130,40,20, "120°");
        createField(t14, 346,130,40,20, "140°");

        tt8=new JTextField();
        tt8.setBounds(100, 270, 40, 20);
        panel.add(tt8);

        tt9=new JTextField();
        tt9.setBounds(141,270,40,20);
        panel.add(tt9);

        tt10=new JTextField();
        tt10.setBounds(182, 270, 40, 20);
        panel.add(tt10);

        tt11=new JTextField();
        tt11.setBounds(223, 270, 40, 20);
        panel.add(tt11);


        tt12=new JTextField();
        tt12.setBounds(264, 270, 40, 20);
        panel.add(tt12);


        tt13=new JTextField();
        tt13.setBounds(305, 270, 40, 20);
        panel.add(tt13);

        tt14=new JTextField();
        tt14.setBounds(346, 270, 40, 20);
        panel.add(tt14);

        hn = new JButton("Запомнить");
        hn.setBounds(391, 270, 100, 20);
        hn.addActionListener(new HNBListener());
        panel.add(hn);

       /* createField(tt8, 100,150,40,20);
        createField(tt9, 141,150,40,20);
        createField(tt10, 182,150,40,20);
        createField(tt11, 223,150,40,20);
        createField(tt12, 264,150,40,20);
        createField(tt13, 305,150,40,20);
        createField(tt14, 346,150,40,20);*/



//коэффициент концентрации, фреймы, кнопка.
        createField(l3, 20,200,70,20,"Коэффициент концентрации");
        createField(k1, 100, 180, 40, 20, "0°");
        createField(k2, 141,180,40,20, "30°");
        createField(k3, 182,180,40,20, "45°");
        createField(k4, 223,180,40,20, "60°");
        createField(k5, 264,180,40,20, "90°");
        createField(k6, 305,180,40,20, "120°");
        createField(k7, 346,180,40,20, "140°");

        kk1=new JTextField();
        kk1.setBounds(100, 320, 40, 20);
        panel.add(kk1);

        kk2=new JTextField();
        kk2.setBounds(141,320,40,20);
        panel.add(kk2);

        kk3=new JTextField();
        kk3.setBounds(182, 320, 40, 20);
        panel.add(kk3);

        kk4=new JTextField();
        kk4.setBounds(223, 320, 40, 20);
        panel.add(kk4);


        kk5=new JTextField();
        kk5.setBounds(264, 320, 40, 20);
        panel.add(kk5);


        kk6=new JTextField();
        kk6.setBounds(305, 320, 40, 20);
        panel.add(kk6);

        kk7=new JTextField();
        kk7.setBounds(346, 320, 40, 20);
        panel.add(kk7);

        kk=new JButton("Запомнить");
        kk.setBounds(391, 320, 100,20);
        kk.addActionListener(new KKBListener());
        panel.add(kk);

        kkch=new JButton("Проверить");
        kkch.setBounds(391, 320, 100,20);
        kkch.addActionListener(new KKCHBListener());
        panel.add(kkch);

        /*
        createField(kk1, 100, 200,40,20);
        createField(kk2, 141,200,40,20);
        createField(kk3, 182,200,40,20);
        createField(kk4, 223,200,40,20);
        createField(kk5, 264,200,40,20);
        createField(kk6, 305,200,40,20);
        createField(kk7, 346,200,40,20);
*/
        area = new JLabel("Запомните данные");
        area.setBounds(100, 365, 366, 20);
        panel.add(area);


        getContentPane().add(panel);

    }





    class BListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {



//0.4, 0.5, 0.63, 0.8, 1, 1.2, 1.6, 2, 2.5, 3.15, 4
                data.sm1.put(0, Double.parseDouble(sm11.getText()));
                data.sm1.put(30, Double.parseDouble(sm12.getText()));
                data.sm1.put(45,  Double.parseDouble(sm13.getText()));
                data.sm1.put(60,  Double.parseDouble(sm14.getText()));
                data.sm1.put(90,  Double.parseDouble(sm15.getText()));
                data.sm1.put(120,  Double.parseDouble(sm16.getText()));
                data.sm1.put(140,  Double.parseDouble(sm17.getText()));
                data.sm2.put(0, Double.parseDouble(sm21.getText()));
                data.sm2.put(30, Double.parseDouble(sm22.getText()));
                data.sm2.put(45,  Double.parseDouble(sm23.getText()));
                data.sm2.put(60,  Double.parseDouble(sm24.getText()));
                data.sm2.put(90,  Double.parseDouble(sm25.getText()));
                data.sm2.put(120,  Double.parseDouble(sm26.getText()));
                data.sm2.put(140,  Double.parseDouble(sm27.getText()));
                data.sm3.put(0, Double.parseDouble(sm31.getText()));
                data.sm3.put(30, Double.parseDouble(sm32.getText()));
                data.sm3.put(45,  Double.parseDouble(sm33.getText()));
                data.sm3.put(60,  Double.parseDouble(sm34.getText()));
                data.sm3.put(90,  Double.parseDouble(sm35.getText()));
                data.sm3.put(120,  Double.parseDouble(sm36.getText()));
                data.sm3.put(140,  Double.parseDouble(sm37.getText()));
                data.sm4.put(0, Double.parseDouble(sm41.getText()));
                data.sm4.put(30, Double.parseDouble(sm42.getText()));
                data.sm4.put(45,  Double.parseDouble(sm43.getText()));
                data.sm4.put(60,  Double.parseDouble(sm44.getText()));
                data.sm4.put(90,  Double.parseDouble(sm45.getText()));
                data.sm4.put(120,  Double.parseDouble(sm46.getText()));
                data.sm4.put(140,  Double.parseDouble(sm47.getText()));
                data.sm5.put(0, Double.parseDouble(sm51.getText()));
                data.sm5.put(30, Double.parseDouble(sm52.getText()));
                data.sm5.put(45,  Double.parseDouble(sm53.getText()));
                data.sm5.put(60,  Double.parseDouble(sm54.getText()));
                data.sm5.put(90,  Double.parseDouble(sm55.getText()));
                data.sm5.put(120,  Double.parseDouble(sm56.getText()));
                data.sm5.put(140,  Double.parseDouble(sm57.getText()));
                area.setText("Данные введены верно");
                sm.setVisible(false);
                data.setSmb(true);
                isAllBoolean();


            }
            catch (NumberFormatException c){
                area.setText("Неверно введены данные");
            }
        }
    }

    class SvBListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {




                data.sv.put(0, Double.parseDouble(tt1.getText()));
                data.sv.put(30, Double.parseDouble(tt2.getText()));
                data.sv.put(45,  Double.parseDouble(tt3.getText()));
                data.sv.put(60,  Double.parseDouble(tt4.getText()));
                data.sv.put(90,  Double.parseDouble(tt5.getText()));
                data.sv.put(120,  Double.parseDouble(tt6.getText()));
                data.sv.put(140,  Double.parseDouble(tt7.getText()));

                area.setText("Данные введены верно");
                sv.setVisible(false);
                data.setSvb(true);
                isAllBoolean();


            }
            catch (NumberFormatException c){
                area.setText("Неверно введены данные");
            }
        }
    }

    class HNBListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {



                data.hn.put(0, Double.parseDouble(tt8.getText()));
                data.hn.put(30, Double.parseDouble(tt9.getText()));
                data.hn.put(45,  Double.parseDouble(tt10.getText()));
                data.hn.put(60,  Double.parseDouble(tt11.getText()));
                data.hn.put(90,  Double.parseDouble(tt12.getText()));
                data.hn.put(120,  Double.parseDouble(tt13.getText()));
                data.hn.put(140,  Double.parseDouble(tt14.getText()));

                area.setText("Данные введены верно");
                hn.setVisible(false);
                data.setHnb(true);
                isAllBoolean();


            }
            catch (NumberFormatException c){
                area.setText("Неверно введены данные");
            }
        }
    }

    class KKBListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {



                data.kk.put(0, Double.parseDouble(kk1.getText()));
                data.kk.put(30, Double.parseDouble(kk2.getText()));
                data.kk.put(45,  Double.parseDouble(kk3.getText()));
                data.kk.put(60,  Double.parseDouble(kk4.getText()));
                data.kk.put(90,  Double.parseDouble(kk5.getText()));
                data.kk.put(120,  Double.parseDouble(kk6.getText()));
                data.kk.put(140,  Double.parseDouble(kk7.getText()));

                area.setText("Данные введены верно");
                kk.setVisible(false);
                data.setKkb(true);
                isAllBoolean();



                kkch.setVisible(true);


            }
            catch (NumberFormatException c){
                area.setText("Неверно введены данные");
            }
        }
    }

    class KKCHBListener implements ActionListener{
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



    class PSVBListener implements ActionListener{
        int i=0;
        @Override
        public void actionPerformed(ActionEvent e) {

            new ShumExcelParser().parsexls(data.psv, "c:/users/vadim/ideaprojects/rasschetmetodika/data/2.xls");


            for(Map.Entry<Double,Double> pair :data.psv.entrySet()  ){
                String[]b={pair.getKey().toString(), pair.getValue().toString()};
                t[i]=b;
                i++;



            }
            psvchck.setVisible(true);
            psv.setVisible(false);
            data.setPsvb(true);
            isAllBoolean();


        }
    }

    class PSMCBListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            new PShumTableCheck().createUI(t, k);
        }
    }

    class CBActionlistener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox box=(JComboBox)e.getSource();
            String item = (String)box.getSelectedItem();
            int c=Integer.parseInt(item);
            setDegrass(c);
        }
    }

    public void createField(JLabel object,int x, int y, int w, int h, String t){

            object = new JLabel(t);
            object.setBounds(x, y+120, w, h);

           panel.add(object);


    }

    public void createField(JTextField object,int x, int y, int w, int h){

            object = new JTextField();
            object.setBounds(x, y+120, w, h);

            panel.add(object);

        }












}
