import java.io.Serializable;

public class Board implements Serializable{
    final int boardWidth = 8;
    final int boardHeight = 8;

    int totalMoves;

    int[][] b;

    int savedGamemode = 0;

    public Board(){
        b = new int[boardWidth][boardHeight];
        totalMoves = 0;
    }

    int C = 0;
    public void setChosenC(int column ){
        C = column;
    }

    int r = 0;
    public void setChosenR(int row){
        r = row;
    }

    public int getChosenC(){
        return C;
    }

    public int getChosenR(){
        return r;
    }

    public void setSavedGM(int gm){
        savedGamemode = gm;
    }

    public int getSavedGM(){
        return savedGamemode;
    }

    public boolean addToColumn(int c, int playerNum){
        int i;
        for(i = 0; i < boardHeight; i++){
            if(b[c][i] == 0){
                b[c][i] = playerNum;
                setChosenC(c);
                setChosenR(i);
                break;
            }
        }
        totalMoves++;
        if(totalMoves > 6)
        { return isWin(c, i);}
        else
            return false;

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
        //System.out.print("In is win");///////////////////////////////////////////////////////////////////////
        //horizontal
        //while positions left and right of boardPos = playerNum and inbounds
        //left

        while( (i>=0) && (b[i][r] == boardPos)){
          //  System.out.print("the value being checked in " + b[i][r]);//////////////////////////////////////////
            count++;
            i--;
        }
        //System.out.print("Back out of while loop, into 2nd while loop \n");//////////////////////////////////////
        //right
        i = c+1;
        while((i < boardWidth) && (b[i][r] == boardPos)){
            count++;
            i++;
        }
        //System.out.print("Out of 2nd while loop \n");/////////////////////////////////////////////////////////
        if(count >= 4)
            return true;

        //vertical
        //while positions above and below boardPos = playerNum and inbounds
        //up
        count = 0;
        int j = r;
        while((j < boardHeight) && (b[c][j] == boardPos)){
            count++;
            j++;
            //System.out.print("\ninside 3rd while loop\n ");///////////////////////////////////////////////////////
        }
        //down
        //System.out.print("\nexit 3rd enter 4th\n" );/////////////////////////////////////////////////////////////
        j = r-1;
        while((j>=0) && (b[c][j] == boardPos)){
            count++;
            j--;
        }

        //System.out.print("\nexit 4th while loop\n");///////////////////////////////////////////////////////////
        if(count >= 4)
            return true;
        
        //positive diagonal
        //while right diagonal = boardPos and inbounds
        //right
        count = 0;
        i = c;
        j = r;
        while((i < boardWidth) && (j < boardHeight) && (b[i][j] == boardPos)){
            count++;
            i++;
            j++;
        }
        //left
        i = c - 1;
        j = r - 1;
        while((i>=0) && (j>=0) && (b[i][j] == boardPos)){
            count++;
            i--;
            j--;
        }
        if(count >= 4)
            return true;
        
        //negative diagonal
        //right c++/r--
        count = 0;
        i = c;
        j = r;
        while((i<boardWidth) && (j>=0) && (b[i][j] == boardPos)){
            count++;
            i++;
            j--;
        }
        //left c--/r++
        i = c - 1;
        j = r + 1;
        while((i>=0) && (j < boardHeight) && (b[i][j] == boardPos)){
            count++;
            i--;
            j++;
        }
        //System.out.print("\n\nmade it through the whole method  !!!!!!!!!!\n");///////////////////////////////////
        if(count >= 4)
            return true;
        return false;

    }

}
