public class Main {
    public static void main() {
        System.out.println("TIC TAC TOE GAME : ");
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame(3); // default size
        game.gameBoard.printBoard();
        game.startGame();
    }
}