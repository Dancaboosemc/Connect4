public class Board {
    final int boardWidth = 8;
    final int boardHeight = 8;

    int totalMoves;

    int[][] b;

    public Board(){
        b = new int[boardWidth][boardHeight];
        totalMoves = 0;
    }

    public void addToColumn(int c, int playerNum){
        int i;
        for(i = 0; i < boardHeight; i++){
            if(b[c][i] == 0){
                b[c][i] = playerNum;
                break;
            }
        }
        totalMoves++;
        /*if(totalMoves > 3)
            return isWin(c, i);
        else
            return false;
        */
    }

    public boolean isColumnPlayable(int c){
        return b[c][boardHeight-1] == 0;
    }

    public boolean isFull(){
        return totalMoves == boardHeight * boardWidth;
    }

    public int[][] getBoard(){
        return b;
    }

    public void setBoard(int [][] brd) {
        b = brd;
    }

    public boolean isWin(int c, int r){
        int boardPos = b[c][r];
        int count = 0;
        int i = c;

        //horizontal
        //while positions left and right of boardPos = playerNum and inbounds
        //left
        while(b[i][r] == boardPos && i >=0){
            count++;
            i--;
        }
        //right
        i = c+1;
        while(b[i][r] == boardPos && i < boardWidth){
            count++;
            i++;
        }
        if(count == 4)
            return true;

        //vertical
        //while positions above and below boardPos = playerNum and inbounds
        //up
        count = 0;
        int j = r;
        while(b[c][j] == boardPos && j < boardHeight){
            count++;
            j++;
        }
        //down
        j = r-1;
        while(b[c][j] == boardPos && j>=0){
            count++;
            j--;
        }
        if(count == 4)
            return true;
        
        //positive diagonal
        //while right diagonal = boardPos and inbounds
        //right
        count = 0;
        i = c;
        j = r;
        while(b[i][j] == boardPos && i < boardWidth && j < boardHeight){
            count++;
            i++;
            j++;
        }
        //left
        i = c - 1;
        j = r - 1;
        while(b[i][j] == boardPos && i >= 0 && j >= 0){
            count++;
            i--;
            j--;
        }
        if(count == 4)
            return true;
        
        //negative diagonal
        //right c++/r--
        count = 0;
        i = c;
        j = r;
        while(b[i][j] == boardPos && i < boardWidth && j >= 0){
            count++;
            i++;
            j--;
        }
        //left c--/r++
        i = c - 1;
        j = r + 1;
        while(b[i][j] == boardPos && i >= 0 && j < boardHeight){
            count++;
            i--;
            j++;
        }
        if(count == 4)
            return true;
        return false;
    }

}
