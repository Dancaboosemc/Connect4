

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
        for(int x = board.boardHeight-1; x >= 0; x--){
            for(int y = 0; y < board.boardWidth; y++){
                System.out.print(brd[y][x] + "  ");
            }
            System.out.print("\n");
        }
        for(int i = 0; i < board.boardWidth; i++)
            System.out.print("-");
        System.out.print("\n");
    }

    public void saveFirstC(){
        if(board.isColumnPlayable(0)){
            board.addToColumn(0,plyrTrn());
        }
        showBoard(board.getBoard());
    }

    public void saveScnd(){
        if(board.isColumnPlayable(1)){
            board.addToColumn(1,plyrTrn());
        }
        showBoard(board.getBoard());
    }
    public void saveThrd(){
        if(board.isColumnPlayable(2)){
            board.addToColumn(2,plyrTrn());
        }
        showBoard(board.getBoard());
    }

    public void saveFrth(){
        if(board.isColumnPlayable(3)){
            board.addToColumn(3,plyrTrn());
        }
        showBoard(board.getBoard());
    }
    public void saveFth(){
        if(board.isColumnPlayable(4)){
            board.addToColumn(4,plyrTrn());
        }
        showBoard(board.getBoard());
    }
    public void saveSxth(){
        if(board.isColumnPlayable(5)){
            board.addToColumn(5,plyrTrn());
        }
        showBoard(board.getBoard());
    }
    public void saveSvnth(){
        if(board.isColumnPlayable(6)){
            board.addToColumn(6,plyrTrn());
        }
        showBoard(board.getBoard());
    }
    public void saveEgth(){
        if(board.isColumnPlayable(7)){
            board.addToColumn(7,plyrTrn());
        }
        showBoard(board.getBoard());
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
