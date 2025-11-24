import java.util.*;
public class Board {
    int size; // size*size types board
    PieceType[][] board;
    public Board(int size){ // initializing board
        this.size = size;
        board = new PieceType[size][size];
    }
    public boolean addPiece(int r, int c, PieceType piece){
        if(board[r][c] != null) return false;
        board[r][c] = piece;
        return true;
    }
    public List<Pair> getFreeCells(){
        List<Pair> freeCellsList = new ArrayList<>();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] == null){
                    freeCellsList.add(new Pair(i,j));
                }
            }
        }
        return freeCellsList;
    }
    public void printBoard(){
        System.out.println("-------------");
        for(int i=0; i<size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print("   |");
                } else System.out.print(" "+board[i][j].ch + " |");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}
