public class Main {
    public static void main(String[] args){
        GameGUI gui = new GameGUI();
        Board board = new Board();
        gameMGR g = new gameMGR(gui, board);
        g.initController();
    }
}
