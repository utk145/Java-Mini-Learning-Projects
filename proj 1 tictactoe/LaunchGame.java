import java.util.Scanner;

class TicTacToe {
    static char[][] board;

    /**
     * Constructs a TicTacToe object and initializes the game board.
     */
    public TicTacToe() {
        board = new char[3][3];
        initBoard();
    }


    //    In Java, the default value of a char is /u0000, this is something we don't want when the board is initialized rather we want spaces

    /**
     * Initializes the game board with empty spaces.
     */
    void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Displays the current state of the game board.
     */
    static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    /**
     * Places a mark ('X' or 'O') on the specified position of the game board.
     *
     * @param row    Row index of the position.
     * @param column Column index of the position.
     * @param mark   Mark to be placed ('X' or 'O').
     */
    static void placeMark(int row, int column, char mark) {
        if (row >= 0 && row <= 2 && column >= 0 && column <= 2) {
            board[row][column] = mark;
        } else {
            System.out.println("Invalid Position");
        }
    }


    /**
     * Checks if there is a win by any player in any column of the game board.
     *
     * @return true if any player has won in any column, otherwise false.
     */
    static boolean checkColumnWin() {
        for (int j = 0; j <= 2; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is a win by any player in any row of the game board.
     *
     * @return true if any player has won in any row, otherwise false.
     */
    static boolean checkRowWin() {
        for (int i = 0; i <= 2; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there is a winning diagonal pattern on the game board.
     * A diagonal win occurs if all three cells in any diagonal (from top-left to bottom-right or top-right to bottom-left)
     * contain the same mark (either 'X' or 'O').
     *
     * @return true if there is a winning diagonal pattern, false otherwise.
     */
    static boolean checkDiagonalWin() {
        return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) || // Top-left to bottom-right diagonal
                (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
                ;   // Top-right to bottom-left diagonal
    }


}


class HumanPlayer {
    String name; // Name of the player
    char mark;   // Mark ('X' or 'O') used by the player


    /**
     * Constructs a HumanPlayer object with the specified name and mark.
     * Constructor is also a setter.
     *
     * @param name Name of the player.
     * @param mark Mark ('X' or 'O') used by the player.
     */
    HumanPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    /**
     * Allows the player to make a move by entering row and column indices.
     * Keeps prompting the player until a valid move is entered.
     */
    void makeMove() {
        Scanner sc = new Scanner(System.in);
        int row;
        int column;
        do {
            System.out.println("Enter the row and column");
            row = sc.nextInt();
            column = sc.nextInt();
        } while (!isMoveValid(row, column));

        TicTacToe.placeMark(row, column, mark);

    }

    /**
     * Checks if a move at the specified row and column is valid.
     * A move is considered valid if the specified position is within the board boundaries
     * and the position is currently empty (marked with ' ').
     *
     * @param row    The row index of the move.
     * @param column The column index of the move.
     * @return true if the move is valid, false otherwise.
     */
    boolean isMoveValid(int row, int column) {
        if (row >= 0 && row <= 2 && column >= 0 && column <= 2) {
            if (TicTacToe.board[row][column] == ' ') {
                return true;
            }
        }
        return false;
    }

}

public class LaunchGame {

    /**
     * The main method to start the Tic-Tac-Toe game.
     * It initializes the game with a new TicTacToe object and two HumanPlayer objects.
     * Then, it enters a loop where each player takes turns to make a move until one of them wins or the game ends in a draw.
     * After each move, it displays the current state of the game board.
     * If a player wins, it displays the winner and exits the loop.
     */
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        HumanPlayer p1 = new HumanPlayer("Bruce", 'X');
        HumanPlayer p2 = new HumanPlayer("Clarke", 'O');
        HumanPlayer currPlayer;

        currPlayer = p1;

        while (true) {
            System.out.println(currPlayer.name + " turn");
            currPlayer.makeMove();
            TicTacToe.displayBoard();

            if (TicTacToe.checkColumnWin() || TicTacToe.checkDiagonalWin() || TicTacToe.checkDiagonalWin()) {
                System.out.println(currPlayer.name + " is the winner");
                break;
            } else {
                if (currPlayer == p1) {
                    currPlayer = p2;
                } else {
                    currPlayer = p1;
                }
            }
        }

    }
}
