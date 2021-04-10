import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class gameMGR {
private GameGUI gui;
private Board board;

    public gameMGR(GameGUI g, Board b){
        gui = g;
        board = b;
    }

    //Connects gui buttons to the methods in this class
    public void initController(){
        gui.startB.addActionListener(e -> startGame());
        gui.column1.addActionListener(e -> saveFirstC());
        gui.column2.addActionListener(e -> saveScnd());
        gui.column3.addActionListener(e -> saveThrd());
        gui.column4.addActionListener(e -> saveFrth());
        gui.column5.addActionListener(e -> saveFth());
        gui.column6.addActionListener(e -> saveSxth());
        gui.column7.addActionListener(e -> saveSvnth());
        gui.column8.addActionListener(e -> saveEgth());
        gui.restart.addActionListener(e -> startGame());
    }

    /*
    startGame():
    -Sets board up
    -Shows board to user
     */
    public void startGame(){
        int [][] brd = board.getBoard();
        for(int i = 0; i < board.boardHeight; i++){
            for(int y = 0; y < board.boardWidth; y++){
                brd[i][y] = 0;
            }
        }
        board.setBoard(brd);
        showBoard(board.getBoard());
        board.totalMoves = 0;
    }

    /*
    saveGame():
    -Saves board in board.txt
    -Saves gui in gui.txt
    */
    public static void saveGame(Board b, GameGUI g)throws IOException{
        String gfn = "gui.txt";
        String bfn = "board.txt";

        FileOutputStream fos = new FileOutputStream(gfn);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(g);
        oos.close();
        fos.close();

        fos = new FileOutputStream(bfn);
        oos = new ObjectOutputStream(fos);

        oos.writeObject(b);
        oos.close();
        fos.close();
    }

    /*
    savedBoardIn():
    -returns the previously saved board
    */
    public static Board savedBoardIn()throws FileNotFoundException, IOException, ClassNotFoundException{
        String bfn = "board.txt";
        FileInputStream fin = new FileInputStream(bfn);
        ObjectInputStream ois = new ObjectInputStream(fin);
        Board loadedBoard = (Board)ois.readObject();
        ois.close();
        fin.close();
        return loadedBoard;
    }

    /*
    savedGUIIn():
    -returns the previously saved gui
    */
    public static GameGUI savedGUIIn()throws FileNotFoundException, IOException, ClassNotFoundException{
        String gfn = "gui.txt";
        FileInputStream fin = new FileInputStream(gfn);
        ObjectInputStream ois = new ObjectInputStream(fin);
        GameGUI loadedGUI = (GameGUI)ois.readObject();
        ois.close();
        fin.close();
        return loadedGUI;
    }

    /*
    showBoard():
    -two for loops (1st & 4th) to set dividers
    -two for loops (one nested) to show the info in 2D array
     */
    public void showBoard(int [][] brd){
        for(int i = 0; i < board.boardWidth; i++)
            System.out.print("-");
        System.out.print("\n");
        for(int x = board.boardHeight-1; x >= 0; x--){
            for(int y = 0; y < board.boardWidth; y++){
                System.out.print(brd[y][x] + "  ");
            }
            System.out.print("\n");
        }/*
        for(int x = 0; x < board.boardHeight; x++){
            for(int y = 0; y < board.boardWidth; y++){
                System.out.print(brd[x][y]);
            }
            System.out.print("\n");
        }
        */
        for(int i = 0; i < board.boardWidth; i++)
            System.out.print("-");
        System.out.print("\n");
    }
    /*
    saveFirstC()-saveEgth():
    -checks if the column selected is playable
    -checks calls board.addToColumn to enter players move, then checks if player won
    -if player won, display winner, only display reset button
     */
    public void saveFirstC(){
        if(board.isColumnPlayable(0)){
           if(board.addToColumn(0,plyrTrn())){
               System.out.print("Winner");
               resetButtons();
           }
        }
        showBoard(board.getBoard());
        checkIfStale();
    }

    public void saveScnd() {
        if (board.isColumnPlayable(1)) {
            if (board.addToColumn(1, plyrTrn())) {
                System.out.print("Winner");
                resetButtons();
                checkIfStale();
            }
        }
        showBoard(board.getBoard());
        checkIfStale();
    }
    public void saveThrd(){
        if (board.isColumnPlayable(2)) {
            if (board.addToColumn(2, plyrTrn())) {
                System.out.print("Winner");
                resetButtons();
            }
        }
        showBoard(board.getBoard());
        checkIfStale();
    }

    public void saveFrth(){
        if (board.isColumnPlayable(3)) {
            if (board.addToColumn(3, plyrTrn())) {
                System.out.print("Winner");
                resetButtons();
            }
        }
        showBoard(board.getBoard());
        checkIfStale();
    }
    public void saveFth(){
        if (board.isColumnPlayable(4)) {
            if (board.addToColumn(4, plyrTrn())) {
                System.out.print("Winner");
                resetButtons();
            }
        }
        showBoard(board.getBoard());
        checkIfStale();
    }
    public void saveSxth(){
        if (board.isColumnPlayable(5)) {
            if (board.addToColumn(5, plyrTrn())) {
                System.out.print("Winner");
                resetButtons();
            }
        }
        showBoard(board.getBoard());
        checkIfStale();
    }
    public void saveSvnth(){
        if (board.isColumnPlayable(6)) {
            if (board.addToColumn(6, plyrTrn())) {
                System.out.print("Winner");
                resetButtons();
            }
        }
        showBoard(board.getBoard());
        checkIfStale();
    }
    public void saveEgth(){
        if (board.isColumnPlayable(7)) {
            if (board.addToColumn(7, plyrTrn())) {
                System.out.print("Winner");
                resetButtons();
            }
        }
        showBoard(board.getBoard());
        checkIfStale();
    }

    /*
    plyrTrn():
    keeps track of who's turn it is
     */
    public int plyrTrn(){
        int playerNum = board.totalMoves;
        if(playerNum % 2 == 0)
            playerNum = 1;
        else
            playerNum = 2;
        return playerNum;
    }

    /*
    hides column buttons
     */
    public void resetButtons(){
        gui.column1.setVisible(false);
        gui.column2.setVisible(false);
        gui.column3.setVisible(false);
        gui.column4.setVisible(false);
        gui.column5.setVisible(false);
        gui.column6.setVisible(false);
        gui.column7.setVisible(false);
        gui.column8.setVisible(false);
    }

    /*
    checks if game is at a stalemate by cheking if maximum amount of moves have been played
     */
    public void checkIfStale(){
        if(board.isFull()){
            System.out.print("\nGame is at a stalemate\n");
        }
    }
}
