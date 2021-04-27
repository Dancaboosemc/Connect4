
import javax.swing.*;
import java.util.Random;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class gameMGR {
    private GameGUI gui;
    private Board board;
    public boolean cpu = true;
    public boolean cpuNrml = false;
    public boolean won = false;
    public int columnSaver = 0;

    public gameMGR(GameGUI g, Board b) {
        gui = g;
        board = b;
    }

    //Connects gui buttons to the methods in this class
    public void initController() {
        gui.startB.addActionListener(e -> startGame());
        gui.startB.addActionListener(e -> mltPlayer());
        gui.aiEzB.addActionListener(e -> startGame());
        gui.aiEzB.addActionListener(e -> singlePlayer());
        gui.aiNrB.addActionListener(e -> startGame());
        gui.aiNrB.addActionListener(e -> singlePlayerNormal());
        gui.column1.addActionListener(e -> saveFirstC());
        gui.column2.addActionListener(e -> saveScnd());
        gui.column3.addActionListener(e -> saveThrd());
        gui.column4.addActionListener(e -> saveFrth());
        gui.column5.addActionListener(e -> saveFth());
        gui.column6.addActionListener(e -> saveSxth());
        gui.column7.addActionListener(e -> saveSvnth());
        gui.column8.addActionListener(e -> saveEgth());
        gui.restart.addActionListener(e -> startGame());
        gui.save.addActionListener(e -> {
            try{
                board.setBoardClicks(gui.clicks);
                saveGame(board);
            } catch(IOException er){
                er.printStackTrace();
            }
        });
        gui.load.addActionListener(e -> loadGame());

    }

    /*
    singlePlayer() sets the easy ai mode single player
     */
    public void singlePlayer() { setCPU(true); setCPUNrml(false); board.setSavedGM(1); }

    /*
    singlePlayerNormal() sets the normal ai mode single player
     */
    public void singlePlayerNormal() { setCPU(false); setCPUNrml(true); board.setSavedGM(2); }

    /*
    mltPlayer() sets the game for 2 players
     */
    public void mltPlayer() { setCPU(false); setCPUNrml(false); board.setSavedGM(0); }

    public void setCPU(boolean ai) { cpu = ai; }

    public void setCPUNrml(boolean aI) { cpuNrml = aI;}

    public boolean getCPU() { return cpu; }


    public boolean getCPUNrml() { return cpuNrml; }

    public void setSaver(int save){ columnSaver = save; }

    public int getSaver() { return columnSaver; }

    /*
    startGame():
    -Sets board up
    -Shows board to user
     */
    public void startGame() {
        int[][] brd = board.getBoard();
        won = false;
        for (int i = 0; i < board.boardHeight; i++) {
            for (int y = 0; y < board.boardWidth; y++) {
                brd[i][y] = 0;
            }
        }

        //gui.background.setVisible(false);

        /*for(int j = 0; j < 2; j++){     
            for(int x = 0; x < 8; x++){
                brd[x][j] = 3;   
            }
        }*/ 
        board.setBoard(brd);
        showBoard(board.getBoard());
        board.totalMoves = 0;
        gui.save.setEnabled(true);
    }

    /*
    saveGame():
    -Saves board in board.txt
    */
    public static void saveGame(Board b)throws IOException{
        String bfn = "board.txt";

        FileOutputStream fos = new FileOutputStream(bfn);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

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
    loadGame():
    -starts a game that was saved previously
    */
    public void loadGame(){
        try{
            board = savedBoardIn();
            gui.setClicks(board.blicks);
            gui.setPlayerTurn(board.getPlayerTurn());
            gui.save.setEnabled(true);

            won = false;
            
            showBoard(board.getBoard());
            System.out.println("total moves: " + board.totalMoves);
            System.out.println("player turn: " + board.getPlayerTurn());
            System.out.println("clicks: ");
            for(int i =0; i < 8; i++){
                System.out.print(gui.clicks[i] +", ");
            }
            System.out.println();
            for(int c = 0; c < 8; c++){
                for(int i = 0; i < board.blicks[c]; i++){
                    
                    if(board.b[c][i] == 1){
                        //System.out.println("board at " + c + ", " + i + ": " + board.b[c][i]);
                        gui.space[7 - i][c].setIcon(new ImageIcon("redpiece.png"));
                    } else if(board.b[c][i] == 2){
                        //System.out.println("board at " + c + ", " + i + ": " + board.b[c][i]);
                        gui.space[7 - i][c].setIcon(new ImageIcon("blackpiece.png"));
                    }
                }
            }

            for(int i = 0; i < 8; i++){
                clickChecker(i);
            }
            
            switch(board.getSavedGM()){
                case 0 :{
                    mltPlayer();
                    //System.out.println("2 player");
                    break;
                }
                case 1 :{
                    singlePlayer();
                    //System.out.println("ez ai");
                    break;
                }
                case 2 :{
                    singlePlayerNormal();
                    //System.out.println("normal ai");
                    break;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
    showBoard():
    -two for loops (1st & 4th) to set dividers
    -two for loops (one nested) to show the info in 2D array
     */
    public void showBoard(int[][] brd) {
        for (int i = 0; i < board.boardWidth; i++)
            System.out.print("-");
        System.out.print("\n");
        ///*
        for (int x = board.boardHeight - 1; x >= 0; x--) {
            for (int y = 0; y < board.boardWidth; y++) {
                System.out.print(brd[y][x] + "  ");
            }
            System.out.print("\n");
        }


        //*/
        /*
        for(int x = 0; x < board.boardHeight; x++){
            for(int y = 0; y < board.boardWidth; y++){
                System.out.print(brd[x][y]);
            }
            System.out.print("\n");
        }
        */
        for (int i = 0; i < board.boardWidth; i++)
            System.out.print("-");
        System.out.print("\n");
    }

    /*
    saveFirstC()..->..saveEgth():
    -checks if the column selected is playable
    -checks calls board.addToColumn to enter players move, then checks if player won
    -if player won, display winner, only display reset button
     */
    public void saveFirstC() {
        //System.out.print("\n in gameMGR : \n");
        if (board.isColumnPlayable(0)) {
            if (board.addToColumn(0, plyrTrn())) {
                winner();
                won = true;
            }
        }
        System.out.print("Player Turn : " + plyrTrn());
        if(plyrTrn() == 1) {
            gui.space[7 - gui.clicks[0]][0].setIcon(new ImageIcon("blackpiece.png"));
            gui.winner.setText("Player 1's Turn");
        }
        else {
            gui.space[7 - gui.clicks[0]][0].setIcon(new ImageIcon("redpiece.png"));
            gui.winner.setText("Player 2's Turn");
        }
        if(won && gui.playerTurn == 1){
            gui.winner.setText("Player 2 Won");
        }
        if(won && gui.playerTurn == 2){
            gui.winner.setText("Player 1 Won");
        }
        setSaver(0);
        gui.clicks[0]++;
        showBoard(board.getBoard());
        checkIfStale();
        if(!won) {ai();}
    }

    public void saveScnd() {
        if (board.isColumnPlayable(1)) {
            if (board.addToColumn(1, plyrTrn())) {
                winner();
                won = true;
            }
        }
        if(plyrTrn() == 1) {
            gui.space[7 - gui.clicks[1]][1].setIcon(new ImageIcon("blackpiece.png"));
            gui.winner.setText("Player 1's Turn");
        }
        else {
            gui.space[7 - gui.clicks[1]][1].setIcon(new ImageIcon("redpiece.png"));
            gui.winner.setText("Player 2's Turn");
        }
        if(won && gui.playerTurn == 1){
            gui.winner.setText("Player 2 Won");
        }
        if(won && gui.playerTurn == 2){
            gui.winner.setText("Player 1 Won");
        }
        setSaver(1);
        gui.clicks[1]++;
        showBoard(board.getBoard());
        checkIfStale();
        if(!won) {ai();}
    }

    public void saveThrd() {
        if (board.isColumnPlayable(2)) {
            if (board.addToColumn(2, plyrTrn())) {
                winner();
                won = true;
            }
        }
        if(plyrTrn() == 1) {
            gui.space[7 - gui.clicks[2]][2].setIcon(new ImageIcon("blackpiece.png"));
            gui.winner.setText("Player 1's Turn");
        }
        else {
            gui.space[7 - gui.clicks[2]][2].setIcon(new ImageIcon("redpiece.png"));
            gui.winner.setText("Player 2's Turn");
        }
        if(won && gui.playerTurn == 1){
            gui.winner.setText("Player 2 Won");
        }
        if(won && gui.playerTurn == 2){
            gui.winner.setText("Player 1 Won");
        }
        setSaver(2);
        gui.clicks[2]++;
        showBoard(board.getBoard());
        checkIfStale();
        if(!won) {ai();}
    }

    public void saveFrth() {
        if (board.isColumnPlayable(3)) {
            if (board.addToColumn(3, plyrTrn())) {
                winner();
                won = true;
            }
        }
        if(plyrTrn() == 1) {
            gui.space[7 - gui.clicks[3]][3].setIcon(new ImageIcon("blackpiece.png"));
            gui.winner.setText("Player 1's Turn");
        }
        else {
            gui.space[7 - gui.clicks[3]][3].setIcon(new ImageIcon("redpiece.png"));
            gui.winner.setText("Player 2's Turn");
        }
        if(won && gui.playerTurn == 1){
            gui.winner.setText("Player 2 Won");
        }
        if(won && gui.playerTurn == 2){
            gui.winner.setText("Player 1 Won");
        }
        setSaver(3);
        gui.clicks[3]++;
        showBoard(board.getBoard());
        checkIfStale();
        if(!won) {ai();}
    }

    public void saveFth() {
        if (board.isColumnPlayable(4)) {
            if (board.addToColumn(4, plyrTrn())) {
                winner();
                won = true;
            }
        }
        if(plyrTrn() == 1) {
            gui.space[7 - gui.clicks[4]][4].setIcon(new ImageIcon("blackpiece.png"));
            gui.winner.setText("Player 1's Turn");
        }
        else {
            gui.space[7 - gui.clicks[4]][4].setIcon(new ImageIcon("redpiece.png"));
            gui.winner.setText("Player 2's Turn");
        }
        if(won && gui.playerTurn == 1){
            gui.winner.setText("Player 2 Won");
        }
        if(won && gui.playerTurn == 2){
            gui.winner.setText("Player 1 Won");
        }
        setSaver(4);
        gui.clicks[4]++;
        showBoard(board.getBoard());
        checkIfStale();
        if(!won) {ai();}
    }

    public void saveSxth() {
        if (board.isColumnPlayable(5)) {
            if (board.addToColumn(5, plyrTrn())) {
                winner();
                won = true;
            }
        }
        if(plyrTrn() == 1) {
            gui.space[7 - gui.clicks[5]][5].setIcon(new ImageIcon("blackpiece.png"));
            gui.winner.setText("Player 1's Turn");
        }
        else {
            gui.space[7 - gui.clicks[5]][5].setIcon(new ImageIcon("redpiece.png"));
            gui.winner.setText("Player 2's Turn");
        }
        if(won && gui.playerTurn == 1){
            gui.winner.setText("Player 2 Won");
        }
        if(won && gui.playerTurn == 2){
            gui.winner.setText("Player 1 Won");
        }
        setSaver(5);
        gui.clicks[5]++;
        showBoard(board.getBoard());
        checkIfStale();
        if(!won) {ai();}
    }

    public void saveSvnth() {
        if (board.isColumnPlayable(6)) {
            if (board.addToColumn(6, plyrTrn())) {
                winner();
                won = true;
            }
        }
        if(plyrTrn() == 1) {
            gui.space[7 - gui.clicks[6]][6].setIcon(new ImageIcon("blackpiece.png"));
            gui.winner.setText("Player 1's Turn");
        }
        else {
            gui.space[7 - gui.clicks[6]][6].setIcon(new ImageIcon("redpiece.png"));
            gui.winner.setText("Player 2's Turn");
        }
        if(won && gui.playerTurn == 1){
            gui.winner.setText("Player 2 Won");
        }
        if(won && gui.playerTurn == 2){
            gui.winner.setText("Player 1 Won");
        }
        setSaver(6);
        gui.clicks[6]++;
        showBoard(board.getBoard());
        checkIfStale();
        if(!won) {ai();}
    }

    public void saveEgth() {
        if (board.isColumnPlayable(7)) {
            if (board.addToColumn(7, plyrTrn())) {
                winner();
                won = true;
            }
        }
        if(plyrTrn() == 1) {
            gui.space[7 - gui.clicks[7]][7].setIcon(new ImageIcon("blackpiece.png"));
            gui.winner.setText("Player 1's Turn");
        }
        else {
            gui.space[7 - gui.clicks[7]][7].setIcon(new ImageIcon("redpiece.png"));
            gui.winner.setText("Player 2's Turn");
        }
        if(won && gui.playerTurn == 1){
            gui.winner.setText("Player 2 Won");
        }
        if(won && gui.playerTurn == 2){
            gui.winner.setText("Player 1 Won");
        }
        setSaver(7);
        gui.clicks[7]++;
        showBoard(board.getBoard());
        checkIfStale();
        if(!won) {ai();}
    }

    /*
    plyrTrn():
    keeps track of who's turn it is
     */
    public int plyrTrn() {
        int playerNum = board.totalMoves;
        if (playerNum % 2 == 0)
            playerNum = 1;
        else
            playerNum = 2;
        gui.setPlayerTurn(playerNum);
        return playerNum;
    }

    /*
     winner(): Displays "winner" and leaves only reset button as visible
    */
    public void winner(){
        System.out.print("winner");
        if(plyrTrn() != 1) {
            gui.winner.setText("Player 1 Wins");
            System.out.print("Player 1 Wins");
        }
        else {
            gui.winner.setText("Player 2 Wins");
            System.out.print("Player 2 Wins");
        }
        resetButtons();
        gui.save.setEnabled(false);
    }


    /*
    hides column buttons
     */
    public void resetButtons() {
        won = false;
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
    public void checkIfStale() {
        if (board.isFull()) {
            System.out.print("\nGame is at a stalemate\n");
            gui.winner.setText("StaleMate!");
            gui.save.setEnabled(false);
        }
    }


    /*
    ai is a method for player to play against the console
    ai method checks if CPU is true/false to see if the user wants to play the game with ai
    - boolean play: is so the console knows if the number it chose is playable
    - int aiMove: is the variable used to get console random number

    public void ai
        if user plays ai
            (bool play) for the while loop
            (int aiMove) to save int number
            while console is playing
                set aiMove to random number
                if number chosen is playable
                    if number chosen is winning choice , (method also inserts player number in slot chosen)
                        call winner method (which displays winner, and resets buttons)
                    else
                        increment clicks for column chosen
                        display board
                        call clickChecker to check if column chosen by ai is not full, if so setVisible to false
                        call checkIfStale to check if it is a stalemate
                        set play to true to confirm ai number is playable
                else
                    do nothing to reset the while loop and make ai choose another number

     */
    public void ai(){
        if(getCPU()){
            boolean play = false;
            int aiMove;
            while(play == false){
                Random turn = new Random();
                aiMove = turn.nextInt(8);
                if(board.isColumnPlayable(aiMove)){
                    if(board.addToColumn(aiMove, plyrTrn())){
                        winner();
                    }
                    
                    if(plyrTrn() == 1)
                        gui.space[7-gui.clicks[aiMove]][aiMove].setIcon(new ImageIcon("blackpiece.png"));
                    else
                        gui.space[7-gui.clicks[aiMove]][aiMove].setIcon(new ImageIcon("redpiece.png"));
                    gui.clicks[aiMove]++;
                    showBoard(board.getBoard());
                    clickChecker(aiMove);
                    checkIfStale();
                    play = true;

                }
            }
        }
        else if(getCPUNrml()){

            nrmlDfclty(board.getChosenC(), board.getChosenR());
            if(board.isColumnPlayable(getSaver()))
                    if(board.addToColumn(getSaver(), plyrTrn()))
                        winner();
            if(plyrTrn() == 1)
                gui.space[7-gui.clicks[getSaver()]][getSaver()].setIcon(new ImageIcon("blackpiece.png"));
            else
                gui.space[7-gui.clicks[getSaver()]][getSaver()].setIcon(new ImageIcon("redpiece.png"));
            gui.clicks[getSaver()]++;
            showBoard(board.getBoard());
            clickChecker(getSaver());
            checkIfStale();

        }
    }

    /*
    clickChecker: takes in int variable to check if the column that was chosen is not full.
    if it is full, set the "setVisible" to false for whatever button increments the column.
     */
    private void clickChecker(int check){
        switch(check){
            case 0 :{
                
                if(gui.clicks[0] == 8)
                    gui.column1.setVisible(false);
                
                break;
            }
            case 1 :{
                if(gui.clicks[1] == 8)
                    gui.column2.setVisible(false);
                break;
            }
            case 2 :{
                if(gui.clicks[2] == 8)
                    gui.column3.setVisible(false);
                break;
            }
            case 3 :{
                if(gui.clicks[3] == 8)
                    gui.column4.setVisible(false);
                break;
            }
            case 4 :{
                if(gui.clicks[4] == 8)
                    gui.column5.setVisible(false);
                break;
            }
            case 5 :{
                if(gui.clicks[5] == 8)
                    gui.column6.setVisible(false);
                break;
            }
            case 6 :{
                if(gui.clicks[6] == 8)
                    gui.column7.setVisible(false);
                break;
            }
            case 7 :{
                if(gui.clicks[7] == 8)
                    gui.column8.setVisible(false);
                break;
            }
        }
    }

    public void nrmlDfclty(int c, int r){
        int horizontal = 0, vertical = 0, dL = 0, dR = 0;
        boolean move = false;
        int count = 0;
        int boardPos = 1; //
        System.out.print( "This is player: " + board.b[c][r]);
        int i = c;
        //horizontal
        //while positions left and right of boardPos = playerNum and inbounds
        //left
        int Lv = i, Rv = -1;
        while( (i>=0) && (board.b[i][r] == boardPos)){
            count++;
            Lv = i;
            i--;
        }

        //right
        i = c+1;
        if(i < 8) {
            Rv = i;
            System.out.print("\nCheck RV : " + Rv + "\n");
        }
        while((i < board.boardWidth) && (board.b[i][r] == boardPos)){
            count++;
            Rv = i;
            i++;
        }

            if((move == false) && (count == 3)){
                if((Lv-1) >= 0){
                    if (board.b[Lv-1][r] == 0) {
                        setSaver(Lv-1);
                        move = true;
                        //System.out.print("\nJust chekcing in\n ");
                    }
                }
                //System.out.print("getSaver : " + getSaver() + "move : " + move +"\n");

                if(((Rv) < 8) && (Rv >= 0) && (!move)){
                    System.out.print("Rv+1: "  + ":\n");
                    if(board.b[Rv][r] == 0) {
                        setSaver(Rv);
                        move = true;
                    }
                }
            }

        horizontal = count;

        //vertical
        //while positions above and below boardPos = playerNum and inbounds
        //up
        count = 0;
        int j = r;
        while((j < board.boardHeight) && (board.b[c][j] == boardPos)){
            count++;
            j++;
        }
        //down
        j = r-1;
        int Dwn = -1;
        if(j >= 0){
            Dwn = j;
        }
        while((j>=0) && (board.b[c][j] == boardPos)){
            count++;
            j--;
        }
        if((!move) && (count == 3)){
            if ((r+1) < 8) {
                setSaver(c);
                move = true;
            }

        }
        else{
            //setSaver(1);///////////////////////////////
        }
        vertical = count;



        //positive diagonal
        //while right diagonal = boardPos and inbounds
        //right
        count = 0;
        i = c;
        j = r;
        while((i < board.boardWidth) && (j < board.boardHeight) && (board.b[i][j] == boardPos)){
            count++;
            i++;
            j++;
        }
        //left
        i = c - 1;
        j = r - 1;
        while((i>=0) && (j>=0) && (board.b[i][j] == boardPos)){
            count++;
            i--;
            j--;
        }

        dR = count;

        //negative diagonal
        //right c++/r--
        count = 0;
        i = c;
        j = r;
        while((i<board.boardWidth) && (j>=0) && (board.b[i][j] == boardPos)){
            count++;
            i++;
            j--;
        }
        //left c--/r++
        i = c - 1;
        j = r + 1;
        while((i>=0) && (j < board.boardHeight) && (board.b[i][j] == boardPos)){
            count++;
            i--;
            j++;
        }
        dL = count;

        if((move == false) && (horizontal == 2)){
            if((Lv-1) >= 0){
                if (board.b[Lv-1][r] == 0) {
                    setSaver(Lv-1);
                    move = true;
                    //System.out.print("\nJust chekcing in\n ");
                }
            }
            //System.out.print("getSaver : " + getSaver() + "move : " + move +"\n");
            System.out.print("\n Bottom Rv is : " + Rv + "\n");
            if((Rv < 8) && (Rv >= 0) && (!move)){
                System.out.print("Rv+1: " + Rv + ":\n");
                if(board.b[Rv][r] == 0) {
                    setSaver(Rv);
                    move = true;
                }
            }
        }
        if((move == false) && (vertical == 2)){
            if ((r+1) < 8) {
                setSaver(c);
                move = true;
            }
        }

        int rand;
        //int mover;
       if(move == false) {
           boolean play = false;
           while (play == false) {
               Random mover = new Random();
               rand = mover.nextInt(8);
               if (board.isColumnPlayable(rand)) {
                   setSaver(rand);
                   play = true;
               }
           }
       }

    }


}
