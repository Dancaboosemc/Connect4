import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame{

    int playerTurn = 0;
    JPanel startP = new JPanel();
    JPanel columnBP = new JPanel();
    JPanel boardP = new JPanel();
    JPanel bottomP = new JPanel();


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

    JTextField winner = new JTextField("Player 1's Turn");

    int clicks[] = new int[]{0,0,0,0,0,0,0,0};
    JLabel[][] space = new JLabel[8][8];
    JLabel background;


    public GameGUI(){

        super("Connect Four!");
        setSize(865, 950);
        setResizable(false);
        columnBP.setBackground(Color.DARK_GRAY);
        startP.setLayout(new GridLayout(1,4));
        columnBP.setLayout(new GridLayout(1,8));
        boardP.setBackground(Color.DARK_GRAY);
        background = new JLabel();
        background.setIcon(new ImageIcon("connect4.png"));
        bottomP.setBackground(Color.DARK_GRAY);
        startP.add(startB);
        startP.add(aiEzB);
        startP.add(aiNrB);
        startP.add(load);
        columnBP.add(column1);
        columnBP.add(column2);
        columnBP.add(column3);
        columnBP.add(column4);
        columnBP.add(column5);
        columnBP.add(column6);
        columnBP.add(column7);
        columnBP.add(column8);

        boardP.add(background);

        for(int i = 0; i < 8 ; i++){
            for(int j = 0; j < 8 ; j++){
                space[i][j] = new JLabel();
                space[i][j].setIcon(new ImageIcon("blankspace.png"));
                boardP.add(space[i][j]);
                space[i][j].setVisible(false);
            }
        }

        bottomP.add(restart);
        bottomP.add(save);
        bottomP.add(winner);

        save.setVisible(false);
        restart.setVisible(false);
        winner.setVisible(false);

        add(startP, BorderLayout.NORTH);
        add(boardP, BorderLayout.CENTER);
        add(bottomP, BorderLayout.SOUTH);

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
        load.addActionListener(new LoadActionListener());
        save.addActionListener(new SaveActionListener());


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    class StartActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            startB.setVisible(false);
            aiEzB.setVisible(false);
            aiNrB.setVisible(false);
            load.setVisible(false);
            remove(startP);
            add(columnBP, BorderLayout.NORTH);
            column1.setVisible(true);
            column2.setVisible(true);
            column3.setVisible(true);
            column4.setVisible(true);
            column5.setVisible(true);
            column6.setVisible(true);
            column7.setVisible(true);
            column8.setVisible(true);

            for(int i = 0; i < 8 ; i++){
                for(int j = 0; j < 8 ; j++){
                    space[i][j].setVisible(true);
                }
            }
            save.setVisible(true);
            restart.setVisible(true);
            winner.setVisible(true);
            background.setVisible(false);
        }
    }

    class VsEzAiActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            startB.setVisible(false);
            aiEzB.setVisible(false);
            aiNrB.setVisible(false);
            load.setVisible(false);
            remove(startP);
            add(columnBP, BorderLayout.NORTH);
            column1.setVisible(true);
            column2.setVisible(true);
            column3.setVisible(true);
            column4.setVisible(true);
            column5.setVisible(true);
            column6.setVisible(true);
            column7.setVisible(true);
            column8.setVisible(true);
            for(int i = 0; i < 8 ; i++){
                for(int j = 0; j < 8 ; j++){
                    space[i][j].setVisible(true);
                }
            }
            save.setVisible(true);
            restart.setVisible(true);
            winner.setVisible(true);
            background.setVisible(false);
        }
    }

    class VsNrAiActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            startB.setVisible(false);
            aiEzB.setVisible(false);
            aiNrB.setVisible(false);
            load.setVisible(false);
            remove(startP);
            add(columnBP, BorderLayout.NORTH);
            column1.setVisible(true);
            column2.setVisible(true);
            column3.setVisible(true);
            column4.setVisible(true);
            column5.setVisible(true);
            column6.setVisible(true);
            column7.setVisible(true);
            column8.setVisible(true);

            for(int i = 0; i < 8 ; i++){
                for(int j = 0; j < 8 ; j++){
                    space[i][j].setVisible(true);
                }
            }
            save.setVisible(true);
            restart.setVisible(true);
            winner.setVisible(true);
            background.setVisible(false);
        }
    }

    class RestartActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            column1.setVisible(false);
            column2.setVisible(false);
            column3.setVisible(false);
            column4.setVisible(false);
            column5.setVisible(false);
            column6.setVisible(false);
            column7.setVisible(false);
            column8.setVisible(false);
            remove(columnBP);
            add(startP, BorderLayout.NORTH);
            startB.setVisible(true);
            aiEzB.setVisible(true);
            aiNrB.setVisible(true);
            load.setVisible(true);

            save.setVisible(false);
            restart.setVisible(false);
            winner.setVisible(false);
            winner.setText("Player 1's Turn");

            background.setVisible(true);
            for(int i = 0; i < 8 ; i++){
                clicks[i] = 0;
                for(int j = 0; j < 8 ; j++){

                    space[i][j].setVisible(false);
                    space[i][j].setIcon(new ImageIcon("blankspace.png"));
                }
            }
        }
    }

    class Column1ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            
            if (clicks[0] >= 8)
                column1.setVisible(false);

        }
    }

    class Column2ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            
            if (clicks[1] >= 8)
                column2.setVisible(false);

        }
    }

    class Column3ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            
            if (clicks[2] >= 8)
                column3.setVisible(false);

        }
    }

    class Column4ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           
            if (clicks[3] >= 8)
                column4.setVisible(false);

        }
    }

    class Column5ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           
            if (clicks[4] >= 8)
                column5.setVisible(false);

        }
    }

    class Column6ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            
            if (clicks[5] >= 8)
                column6.setVisible(false);

        }
    }

    class Column7ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            
            if (clicks[6] >= 8)
                column7.setVisible(false);

        }
    }

    class Column8ActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            
            if (clicks[7] >= 8)
                column8.setVisible(false);

        }
    }

    class LoadActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            background.setVisible(false);
            startB.setVisible(false);
            aiEzB.setVisible(false);
            aiNrB.setVisible(false);
            load.setVisible(false);
            remove(startP);
            add(columnBP, BorderLayout.NORTH);
            if(clicks[0] < 8){
                column1.setVisible(true);
            }
            if(clicks[1] < 8){
                column2.setVisible(true);
            }
            if(clicks[2] < 8){
                column3.setVisible(true);
            }
            if(clicks[3] < 8){
                column4.setVisible(true);
            }
            if(clicks[4] < 8){
                column5.setVisible(true);
            }
            if(clicks[5] < 8){
                column6.setVisible(true);
            }
            if(clicks[6] < 8){
                column7.setVisible(true);
            }
            if(clicks[7] < 8){
                column8.setVisible(true);
            }

            for(int i = 0; i < 8 ; i++){
                for(int j = 0; j < 8 ; j++){
                    space[i][j].setVisible(true);
                }
            }
            save.setVisible(true);
            restart.setVisible(true);
            winner.setVisible(true);
            winner.setText("Player " + playerTurn + "'s Turn");
        }
    }
    class SaveActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {

        }
    }

    public void setPlayerTurn(int player){
        playerTurn = player;
    }
    
    public void setClicks(int[] c){
        for(int i = 0; i < 8; i++){
            clicks[i] = c[i];
        }
    }
}
