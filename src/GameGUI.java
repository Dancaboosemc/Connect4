import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class GameGUI extends JFrame {

    JPanel p = new JPanel();
    JButton startB = new JButton("Start Game");

    public static void main (String[] args){
        new GameGUI();
    }

    public GameGUI(){
        super("Connect Four!");
        setSize(800, 800);
        setResizable(true);
        p.add(startB);
        add(p);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}
