import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vadim on 04.08.2016.
 */
public class Shum extends JFrame{

        private JTextField t1,t2,t3,t4,t5,t6,t7;
        JPanel panel;
    JLabel miss;
    private double f20, f230, f245, f260, f290, f2120, f2140;
        public Shum() throws HeadlessException {
            super("Шумовая составляющая");
            createui();

        }



        public void createui(){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel = new JPanel();
            panel.setLayout(new FlowLayout());
            panel.setLayout(null);

            JLabel g1 = new JLabel("0°");
            g1.setBounds(100,80,40,20);
            panel.add(g1);
            JLabel g2 = new JLabel("30°");
            g2.setBounds(141,80,40,20);
            panel.add(g2);
            JLabel g3 = new JLabel("45°");
            g3.setBounds(182,80,40,20);
            panel.add(g3);
            JLabel g4 = new JLabel("60°");
            g4.setBounds(223,80,40,20);
            panel.add(g4);
            JLabel g5 = new JLabel("90°");
            g5.setBounds(264,80,40,20);
            panel.add(g5);
            JLabel g6 = new JLabel("120°");
            g6.setBounds(305,80,40,20);
            panel.add(g6);
            JLabel g7 = new JLabel("140°");
            g7.setBounds(346,80,40,20);
            panel.add(g7);

            t1=new JTextField(6);
            t1.setBounds(100,100,40,20);
            panel.add(t1);
            t2=new JTextField(6);
            t2.setBounds(141,100,40,20);
            panel.add(t2);
            t3=new JTextField(6);
            t3.setBounds(182,100,40,20);
            panel.add(t3);
            t4=new JTextField(6);
            t4.setBounds(223,100,40,20);
            panel.add(t4);
            t5=new JTextField(6);
            t5.setBounds(264,100,40,20);
            panel.add(t5);
            t6=new JTextField(6);
            t6.setBounds(305,100,40,20);
            panel.add(t6);
            t7=new JTextField(6);
            t7.setBounds(346,100,40,20);
            panel.add(t7);

            //плюс 7*5 для механизмов, 7кк, 7хн
            JButton rass = new JButton("GO!");
            rass.setBounds(305,125,81,20);
            rass.addActionListener(new BListener());
            panel.add(rass);

            miss = new JLabel();
            miss.setBounds(100,60,250,20);
            panel.add(miss);



            getContentPane().add(panel);



        }


    class BListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                f20 = Double.parseDouble(t1.getText());
                f230 = Double.parseDouble(t2.getText());
                f245 = Double.parseDouble(t3.getText());
                f260 = Double.parseDouble(t4.getText());
                f290 = Double.parseDouble(t5.getText());
                f2120 = Double.parseDouble(t6.getText());
                f2140 = Double.parseDouble(t7.getText());
                miss.setText(f20+" "+f230+" "+f245+" "+f260+" "+f290+" "+f2120+" "+f2140);

            }
            catch (NumberFormatException s){
                miss.setText("Double plz!");
            }
        }
    }
    public static void main(String[] args){
        Shum frame = new Shum();

        frame.setSize(450, 450);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
