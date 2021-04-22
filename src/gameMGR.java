
import javax.swing.*;
import java.util.Random;
public class gameMGR {
    private GameGUI gui;
    private Board board;
    public boolean cpu = true;
    public boolean cpuNrml = false;
    public boolean won = false;

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
        gui.startB.addActionListener(e -> startGame());
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


    }

    /*
    singlePlayer() sets the easy ai mode single player
     */
    public void singlePlayer() { setCPU(true); setCPUNrml(false); }

    /*
    singlePlayerNormal() sets the normal ai mode single player
     */
    public void singlePlayerNormal() { setCPU(false); setCPUNrml(true); }

    /*
    mltPlayer() sets the game for 2 players
     */
    public void mltPlayer() { setCPU(false); setCPUNrml(false); }

    public void setCPU(boolean ai) { cpu = ai; }

    public void setCPUNrml(boolean aI) { cpuNrml = aI;}

    public boolean getCPU() { return cpu; }

    public boolean getCPUNrml() { return cpuNrml; }

    /*
    startGame():
    -Sets board up
    -Shows board to user
     */
    public void startGame() {
        int[][] brd = board.getBoard();
        for (int i = 0; i < board.boardHeight; i++) {
            for (int y = 0; y < board.boardWidth; y++) {
                brd[i][y] = 0;
            }
        }

        /*for(int j = 0; j < 2; j++){
            for(int x = 0; x < 8; x++){
                brd[x][j] = 3;
            }
        }*/
        board.setBoard(brd);
        showBoard(board.getBoard());
        board.totalMoves = 0;
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
        if(plyrTrn() == 1) {
            gui.space[7 - gui.clicks[0]][0].setIcon(new ImageIcon("blackpiece.png"));
            gui.winner.setText("Player 1's Turn");
        }
        else {
            gui.space[7 - gui.clicks[0]][0].setIcon(new ImageIcon("redpiece.png"));
            gui.winner.setText("Player 2's Turn");
        }
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
        resetButtons();
    }


    /*
    hides column buttons
     */
    public void resetButtons() {
        gui.column1.setVisible(false);
        gui.column2.setVisible(false);
        gui.column3.setVisible(false);
        gui.column4.setVisible(false);
        gui.column5.setVisible(false);
        gui.column6.setVisible(false);
        gui.column7.setVisible(false);
        gui.column8.setVisible(false);
        gui.aiEzB.setVisible(false);
    }

    /*
    checks if game is at a stalemate by cheking if maximum amount of moves have been played
     */
    public void checkIfStale() {
        if (board.isFull()) {
            System.out.print("\nGame is at a stalemate\n");
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
                    //clickChecker(aiMove);
                    //System.out.print(gui.playerTurn);
                    //gui.clicks[aiMove]++;
                    //clickChecker(aiMove);
                    if(plyrTrn() == 1)
                        gui.space[7-gui.clicks[aiMove]][aiMove].setIcon(new ImageIcon("blackpiece.png"));
                    else
                        gui.space[7-gui.clicks[aiMove]][aiMove].setIcon(new ImageIcon("redpiece.png"));
                    gui.clicks[aiMove]++;
                    //gui.clicks[aiMove]++;
                    showBoard(board.getBoard());
                    clickChecker(aiMove);
                    checkIfStale();
                    play = true;

                }
            }
        }
        else if(getCPUNrml()){
            boolean playable = false;

        }
    }

    /*
    clickChecker: takes in int variable to check if the column that was chosen is not full.
    if it is full, set the "setVisible" to false for whatever button increments the column.
     */
    private void clickChecker(int check){
        switch(check){
            case 0 :{
                //gui.clicks[0]++;

                    //gui.space[5-gui.clicks[0]][0].setIcon(new ImageIcon("redpiece.png"));
                if(gui.clicks[0] == 8)
                    gui.column1.setVisible(false);
                //gui.clicks[0]++;
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
            }
            case 4 :{
                if(gui.clicks[4] == 8)
                    gui.column5.setVisible(false);
            }
            case 5 :{
                if(gui.clicks[5] == 8)
                    gui.column6.setVisible(false);
            }
            case 6 :{
                if(gui.clicks[6] == 8)
                    gui.column7.setVisible(false);
            }
            case 7 :{
                if(gui.clicks[7] == 8)
                    gui.column8.setVisible(false);
            }
        }
    }

    public void nrmlDfclty(){
        int horizontal = 0, vertical = 0, dL = 0, dR = 0;

        int count = 0, boardPos = 0;
        int i = 0, c = 0;
        int r = 0;
        //horizontal
        //while positions left and right of boardPos = playerNum and inbounds
        //left

        while( (i>=0) && (board.b[i][r] == boardPos)){
            count++;
            i--;
        }

        //right
        i = c+1;
        while((i < board.boardWidth) && (board.b[i][r] == boardPos)){
            count++;
            i++;
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
        while((j>=0) && (board.b[c][j] == boardPos)){
            count++;
            j--;
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

    }


}
