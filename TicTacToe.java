import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        boolean gameOver = false;
        char player = 'X';

        // initialize board with empty cells
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // game loop
        while (!gameOver) {
            // print current board
            System.out.println("Current board:");
            printBoard(board);

            // ask player for input
            System.out.println("Player " + player + ", enter row and column (e.g. 1 2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // check if input is valid
            if (row < 1 || row > 3 || col < 1 || col > 3 || board[row - 1][col - 1] != '-') {
                System.out.println("Invalid input, try again.");
                continue;
            }

            // update board and check for win
            board[row - 1][col - 1] = player;
            if (checkWin(board, player)) {
                System.out.println("Player " + player + " wins!");
                gameOver = true;
            }

            // check for draw
            if (!gameOver && isBoardFull(board)) {
                System.out.println("It's a draw!");
                gameOver = true;
            }

            // switch player
            player = (player == 'X') ? 'O' : 'X';
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkWin(char[][] board, char player) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }

        // check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
