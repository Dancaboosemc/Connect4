import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;



public class GameGUI extends JFrame {

    int playerTurn = 0;
    JPanel startP = new JPanel();
    JButton startB = new JButton("2 Player");
    JButton aiEzB= new JButton("VS Easy AI");
    JButton aiNrB= new JButton("VS Normal AI");
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
    JLabel[][] space = new JLabel[8][8];

    public GameGUI(){

        super("Connect Four!");
        setSize(865, 950);
        setResizable(false);
        startP.setBackground(Color.DARK_GRAY);
        startP.add(startB);
        startP.add(aiEzB);
        startP.add(aiNrB);
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

        for(int i = 0; i < 8 ; i++){
            for(int j = 0; j < 8 ; j++){
                space[i][j] = new JLabel();
                space[i][j].setIcon(new ImageIcon("blankspace.png"));
                startP.add(space[i][j]);
                space[i][j].setVisible(false);
            }
        }

        startP.add(restart);
        startP.add(save);

        column1.setVisible(false);
        column2.setVisible(false);
        column3.setVisible(false);
        column4.setVisible(false);
        column5.setVisible(false);
        column6.setVisible(false);
        column7.setVisible(false);
        column8.setVisible(false);
        
        save.setVisible(false);
        restart.setVisible(false);

        add(startP);

        validate();

        startB.addActionListener(new StartActionListener());
        aiEzB.addActionListener(new VsEzAiActionListener());
        aiNrB.addActionListener(new VsNrAiActionListener());
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
            aiEzB.setVisible(false);
            aiNrB.setVisible(false);
            save.setVisible(true);
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
            for(int i = 0; i < 8 ; i++){
                for(int j = 0; j < 8 ; j++){
                    space[i][j].setVisible(true);
                }
            }
            //////////////////////////

            restart.setVisible(true);
        }
     }

     class VsEzAiActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            startB.setVisible(false);
            aiEzB.setVisible(false);
            aiNrB.setVisible(false);
            save.setVisible(true);
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
            for(int i = 0; i < 8 ; i++){
                for(int j = 0; j < 8 ; j++){
                    space[i][j].setVisible(true);
                }
            }
            //////////////////////////

            restart.setVisible(true);
        }
     }

     class VsNrAiActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            startB.setVisible(false);
            aiEzB.setVisible(false);
            aiNrB.setVisible(false);
            save.setVisible(true);
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
            for(int i = 0; i < 8 ; i++){
                for(int j = 0; j < 8 ; j++){
                    space[i][j].setVisible(true);
                }
            }
            //////////////////////////

            restart.setVisible(true);
        }
     }

     class RestartActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            startB.setVisible(true);
            aiEzB.setVisible(true);
            aiNrB.setVisible(true);
            save.setVisible(false);
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
            for(int i = 0; i < 8 ; i++){
                for(int j = 0; j < 8 ; j++){
                    
                    space[i][j].setVisible(false);
                    space[i][j].setIcon(new ImageIcon("blankspace.png"));
                }
            }
        }
     }

    class Column1ActionListener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            if(playerTurn == 1)
                space[7-clicks[0]][0].setIcon(new ImageIcon("blackpiece.png"));
            else
                space[7-clicks[0]][0].setIcon(new ImageIcon("redpiece.png"));
            clicks[0]++;
            if (clicks[0] >= 8)
                column1.setVisible(false);

        }
    }

    class Column2ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(playerTurn == 1)
                space[7-clicks[1]][1].setIcon(new ImageIcon("blackpiece.png"));
            else
                space[7-clicks[1]][1].setIcon(new ImageIcon("redpiece.png"));
            clicks[1]++;
            if (clicks[1] >= 8)
               column2.setVisible(false);

       }
   }
   
   class Column3ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(playerTurn == 1)
                space[7-clicks[2]][2].setIcon(new ImageIcon("blackpiece.png"));
            else
                space[7-clicks[2]][2].setIcon(new ImageIcon("redpiece.png"));
            clicks[2]++;
            if (clicks[2] >= 8)
                column3.setVisible(false);

        }
    }

    class Column4ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(playerTurn == 1)
                space[7-clicks[3]][3].setIcon(new ImageIcon("blackpiece.png"));
            else
                space[7-clicks[3]][3].setIcon(new ImageIcon("redpiece.png"));
            clicks[3]++;
            if (clicks[3] >= 8)
               column4.setVisible(false);

       }
   }
   
   class Column5ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(playerTurn == 1)
                space[7-clicks[4]][4].setIcon(new ImageIcon("blackpiece.png"));
            else
                space[7-clicks[4]][4].setIcon(new ImageIcon("redpiece.png"));
            clicks[4]++;
            if (clicks[4] >= 8)
                column5.setVisible(false);

        }
    }
    
    class Column6ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(playerTurn == 1)
                space[7-clicks[5]][5].setIcon(new ImageIcon("blackpiece.png"));
            else
                space[7-clicks[5]][5].setIcon(new ImageIcon("redpiece.png"));
            clicks[5]++;
            if (clicks[5] >= 8)
               column6.setVisible(false);

       }
   }
   
   class Column7ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(playerTurn == 1)
                space[7-clicks[6]][6].setIcon(new ImageIcon("blackpiece.png"));
            else
                space[7-clicks[6]][6].setIcon(new ImageIcon("redpiece.png"));
            clicks[6]++;
            if (clicks[6] >= 8)
                column7.setVisible(false);

        }
    }
    
    class Column8ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(playerTurn == 1)
                space[7-clicks[7]][7].setIcon(new ImageIcon("blackpiece.png"));
            else
                space[7-clicks[7]][7].setIcon(new ImageIcon("redpiece.png"));
            clicks[7]++;
            if (clicks[7] >= 8)
               column8.setVisible(false);

       }
   }

   public void setPlayerTurn(int player){
        playerTurn = player;
   }
}
