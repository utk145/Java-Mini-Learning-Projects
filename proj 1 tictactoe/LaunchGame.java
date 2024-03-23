class TicTacToe {
    char[][] board;

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
    void displayBoard() {
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
    void placeMark(int row, int column, char mark) {
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
    boolean checkColumnWin() {
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
    boolean checkRowWin() {
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
    boolean checkDiagonalWin() {
        return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) || // Top-left to bottom-right diagonal
                (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
                ;   // Top-right to bottom-left diagonal
    }


}


public class LaunchGame {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
//        t.displayBoard();
//        t.placeMark(0, 2, 'X');
//        t.placeMark(1, 1, 'X');
//        t.placeMark(2, 0 , 'X');
        t.displayBoard();
        System.out.println(t.checkDiagonalWin());
        System.out.println(t.checkColumnWin());
        System.out.println(t.checkRowWin());
    }
}
