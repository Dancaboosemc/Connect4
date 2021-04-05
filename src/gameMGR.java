

public class gameMGR {
private GameGUI gui;
private Board board;

    public gameMGR(GameGUI g, Board b){
        gui = g;
        board = b;
    }

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

    public void showBoard(int [][] brd){
        for(int i = 0; i < board.boardWidth; i++)
            System.out.print("-");
        System.out.print("\n");
        for(int x = 0; x < board.boardHeight; x++){
            for(int y = 0; y < board.boardWidth; y++){
                System.out.print(brd[x][y]);
            }
            System.out.print("\n");
        }
        for(int i = 0; i < board.boardWidth; i++)
            System.out.print("-");
        System.out.print("\n");
    }

    public void saveFirstC(){

    }

    public void saveScnd(){

    }
    public void saveThrd(){

    }

    public void saveFrth(){

    }
    public void saveFth(){

    }
    public void saveSxth(){

    }
    public void saveSvnth(){

    }
    public void saveEgth(){

    }

    public int plyrTrn(){
        int playerNum = board.totalMoves;
        if(playerNum % 2 == 0)
            playerNum = 1;
        else
            playerNum = 2;
        return playerNum;
    }

}
