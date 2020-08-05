import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

	static Scanner in;
	static String[] board;
	static String turn;

	
	// to initialize the board
	static void populateEmptyBoard() {

         	for (int a = 0; a < 9; a++) {
                board[a] = String.valueOf(a+1);
                }
	}

	//to print the board back to all empty values
	static void printBoard() {

                System.out.println("/---|---|---\\");
                System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
                System.out.println("|-----------|");
                System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
                System.out.println("|-----------|");
                System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
                System.out.println("/---|---|---\\");

        }

	public static void main(String[] args) {
		in = new Scanner(System.in);
		board = new String[9];
		turn =in.nextLine();
		String winner = null;
		populateEmptyBoard();
		System.out.println("Enter a number between 0 and 1");
		int choice=in.nextInt();
		int n=(int) (Math.random() + 0.5);
		if(n==choice) {
		System.out.println("Player will proceed");
		turn="X";
		}else {
			System.out.println("Computer will proceed");
			turn="O";
		}

		System.out.println("Welcome to 2 Player Tic Tac Toe.");
		System.out.println("--------------------------------");
		//showing the board to the player
		printBoard();
	}

}
