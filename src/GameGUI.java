import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame {

    JPanel startP = new JPanel();
    JButton startB = new JButton("Start Game");
    JButton column1 = new JButton("Column 1");
    JButton column2 = new JButton("Column 2");
    JButton column3 = new JButton("Column 3");
    JButton column4 = new JButton("Column 4");
    JButton column5 = new JButton("Column 5");
    JButton column6 = new JButton("Column 6");
    JButton column7 = new JButton("Column 7");
    JButton column8 = new JButton("Column 8");
    JButton restart = new JButton("Restart");
    JButton save = new JButton("Save Game");
    JButton load = new JButton("Load Game");
    JTextField winner = new JTextField("Winner");

    int clicks[] = new int[]{0,0,0,0,0,0,0,0};
    //////////////////////////////////////////////////////

    ImageIcon img = new ImageIcon("blackpiece.png");
    JLabel space = new JLabel(img);

    //////////////////////////////////////////////////////

    public GameGUI(){
        super("Connect Four!");
        setSize(800, 800);
        setResizable(true);
        startP.setBackground(Color.yellow);
        startP.add(startB);
        startP.add(save);
        startP.add(load);
        //startP.add(winner);
        startP.add(column1);
        startP.add(column2);
        startP.add(column3);
        startP.add(column4);
        startP.add(column5);
        startP.add(column6);
        startP.add(column7);
        startP.add(column8);

        //////////////////////////////////
        startP.add(space);
        /////////////////////////////////

        startP.add(restart);
        column1.setVisible(false);
        column2.setVisible(false);
        column3.setVisible(false);
        column4.setVisible(false);
        column5.setVisible(false);
        column6.setVisible(false);
        column7.setVisible(false);
        column8.setVisible(false);

        ///////////////////////////////////////
        space.setVisible(false);
        ///////////////////////////////////
        
        restart.setVisible(false);
        add(startP);
        validate();
        startB.addActionListener(new StartActionListener());
        restart.addActionListener(new RestartActionListener());
        column1.addActionListener(new Column1ActionListener());
        column2.addActionListener(new Column2ActionListener());
        column3.addActionListener(new Column3ActionListener());
        column4.addActionListener(new Column4ActionListener());
        column5.addActionListener(new Column5ActionListener());
        column6.addActionListener(new Column6ActionListener());
        column7.addActionListener(new Column7ActionListener());
        column8.addActionListener(new Column8ActionListener());

        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    class StartActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            startB.setVisible(false);
            save.setVisible(false);
            load.setVisible(false);
            column1.setVisible(true);
            column2.setVisible(true);
            column3.setVisible(true);
            column4.setVisible(true);
            column5.setVisible(true);
            column6.setVisible(true);
            column7.setVisible(true);
            column8.setVisible(true);

            //////////////////////////////
            space.setVisible(true);
            //////////////////////////

            restart.setVisible(true);
        }
     }

     class RestartActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            startB.setVisible(true);
            save.setVisible(true);
            load.setVisible(true);
            column1.setVisible(false);
            column2.setVisible(false);
            column3.setVisible(false);
            column4.setVisible(false);
            column5.setVisible(false);
            column6.setVisible(false);
            column7.setVisible(false);
            column8.setVisible(false);
            restart.setVisible(false);
            for(int i = 0; i < 8; i++){
                clicks[i] = 0;
            }
        }
     }

    class Column1ActionListener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            clicks[0]++;
            if (clicks[0] >= 8)
                column1.setVisible(false);

        }
    }

    class Column2ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           clicks[1]++;
           if (clicks[1] >= 8)
               column2.setVisible(false);

       }
   }
   
   class Column3ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        clicks[2]++;
            if (clicks[2] >= 8)
                column3.setVisible(false);

        }
    }

    class Column4ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           clicks[3]++;
           if (clicks[3] >= 8)
               column4.setVisible(false);

       }
   }
   
   class Column5ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            clicks[4]++;
            if (clicks[4] >= 8)
                column5.setVisible(false);

        }
    }
    
    class Column6ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           clicks[5]++;
           if (clicks[5] >= 8)
               column6.setVisible(false);

       }
   }
   
   class Column7ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            clicks[6]++;
            if (clicks[6] >= 8)
                column7.setVisible(false);

        }
    }
    
    class Column8ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           clicks[7]++;
           if (clicks[7] >= 8)
               column8.setVisible(false);

       }
   }
}
