import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(int size){
        //default size of board = 3;
        gameBoard = new Board(size);

        //default playerNames are Player1 and Player2.
        String name1 = "Player1";
        String name2 = "Player2";

        PieceType piece1;
        PieceType piece2;
        System.out.println("Available PieceType Options : X, O"); // can be added in future

        System.out.print("Player1  : choose your pieceType :");

        Scanner scanner = new Scanner(System.in);
        char ch = scanner.next().charAt(0);
        switch(ch){
            case 'X' :
                piece1 = new PieceX();
                piece2 = new PieceO();
                break;
            default :  // by default player one gets O and player2 gets X
                piece1 = new PieceO();
                piece2 = new PieceX();
                break;
        }
        players = new LinkedList<>();
        players.add(new Player(name1, piece1));
        players.addLast(new Player(name2, piece2));
    }

    // main game orchestrator
    public void startGame(){
        boolean gameWon = false;
        boolean hasSpaceOnBoard = true;
        Scanner sc = new Scanner(System.in);
        Player currPlayer = players.peek();
        while(!gameWon && hasSpaceOnBoard){
            if(gameBoard.getFreeCells().isEmpty()){
                hasSpaceOnBoard = false; // no space left. restart game
                continue;
            }
            currPlayer = players.removeFirst();
            System.out.print(currPlayer.name+", Please provide row,col where you want to put your piece :");
            String input = sc.nextLine();
            input = input.replace(",", " ");
            String[] inputparts = input.trim().split("\\s+");
            int row = Integer.parseInt(inputparts[0]);
            int col = Integer.parseInt(inputparts[1]);
            if(row>=0 && row<gameBoard.size && col>=0 && col< gameBoard.size && gameBoard.board[row][col]==null ){
                gameBoard.addPiece(row, col, currPlayer.piece);
                players.addLast(currPlayer);
                gameBoard.printBoard();
                System.out.println("-------------------------------------------------------");
            }
            else{
                System.out.println("INVALID INPUT ! try again");
                players.addFirst(currPlayer);
                continue;
            }
            gameWon = checkWinner(row, col, gameBoard, currPlayer.piece);
        }
        if(gameWon){
            System.out.println(currPlayer.name+"  won the GAME !!");
        }
        else if(!hasSpaceOnBoard){
            System.out.println("GAME Ended with a DRAW, No space left.");
        }
    }
    private boolean checkWinner(int row, int col, Board gameBoard, PieceType piece){
        // horizontal
        int similar = 1;
        int size = gameBoard.size;
        for(int i=1; i<size; i++){
            if(gameBoard.board[(row+i)%size][col] == piece) similar++;
        }
        if(similar== size) return true;
        similar = 1;
        // vertical
        for(int j=1; j<size; j++){
            if(gameBoard.board[row][(col+j)%size] == piece) similar++;
        }
        if(similar== size) return true;
        similar = 1;
        // diagonal
        if(row== size/2 && col ==size/2){
            for(int i=1; i<=size; i++){
                for(int j=1; j<=size; j++){
                    if(row+i < size && col+j<size  && gameBoard.board[(row+i)%size][(col+j)%size] == piece){
                        similar++;
                    }
                    if(row-i>=0 && col-j>=0 && gameBoard.board[(row-i)%size][(col+j)%size] == piece){
                        similar++;
                    }
                }
            }
        }
        if(similar == size) return true;
        return false;
    }
}
