import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
    static Scanner scan = new Scanner(System.in);
    static char turn = 'X';

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        play();
    }

    public static void play() {
        boolean playing = true;
        while (playing) {
            System.out.println("C'est le tour de " + turn + " : entrer les coordonnées x y");
            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;
            if (board[x][y] == ' ') {
                board[x][y] = turn;
                printBoard();
                if (isWinner(turn)) {
                    System.out.println(turn + " a gagné!");
                    playing = false;
                }
                if (turn == 'X') {
                    turn = 'O';
                } else {
                    turn = 'X';
                }
            } else {
                System.out.println("Vous ne pouvez pas jouer ici. Veuillez en choisir un autre.");
            }
        }
    }

    public static boolean isWinner(char player) {
        // Vérifier les lignes
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // Vérifier les colonnes
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // Vérifier la première diagonale
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        // Vérifier la seconde diagonale
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}
