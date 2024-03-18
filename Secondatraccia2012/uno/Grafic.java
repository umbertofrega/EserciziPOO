package Secondatraccia2012.uno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grafic{

    public static void main(String[] args) {
        FrontEnd fe = new FrontEnd();
        fe.setVisible(true);

    }

    private static class FrontEnd extends JFrame {
        public FrontEnd() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Calcolatrice");
            setSize(400, 400);
            setLocation(500, 200);
            //...
            JPanel q = new JPanel();
            JLabel l = new JLabel("", JLabel.RIGHT);
            JTextField jtf = new JTextField("", 12);
            q.add(l);
            q.add(jtf);
            //...
            JPanel p = new JPanel();
            p.setLayout(new GridLayout(4, 4, 3, 3));
            JButton sette = new JButton("7");
            JButton otto = new JButton("8");
            JButton nove = new JButton("9");
            JButton diviso = new JButton("/");
            JButton quattro = new JButton("4");
            JButton cinque = new JButton("5");
            JButton sei = new JButton("6");
            JButton per = new JButton("*");
            JButton uno = new JButton("1");
            JButton due = new JButton("2");
            JButton tre = new JButton("3");
            JButton meno = new JButton("-");
            JButton zero = new JButton("0");
            JButton punto = new JButton(".");
            JButton uguale = new JButton("=");
            JButton piu = new JButton("+");

            //...
            p.add(sette);
            p.add(otto);
            p.add(nove);
            p.add(diviso);
            p.add(quattro);
            p.add(cinque);
            p.add(sei);
            p.add(per);
            p.add(uno);
            p.add(due);
            p.add(tre);
            p.add(meno);
            p.add(zero);
            p.add(punto);
            p.add(uguale);
            p.add(piu);
            //...
            add(q, BorderLayout.NORTH); //aggiunta del pannello p alla JFrame
            add(p, BorderLayout.CENTER);


            class Ascoltatore implements ActionListener {
                public void actionPerformed(ActionEvent e) {

                    if (e.getSource()==piu){
                        jtf.setText(jtf.getText()+piu.getText());

                    }
                }
            }//Ascoltatore



            uguale.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    RPN mat = new RPN(jtf.getText());
                    jtf.setText((mat.valuta()));
                }
            });

        }
    }
}