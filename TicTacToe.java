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
		Scanner	str = new Scanner(System.in);
		board = new String[9];
		String winner = null;
		populateEmptyBoard();

		String playerChar = null;
		String computerChar = null;
		//Taking the choice of the user
		System.out.println("Enter a number between 0 and 1");
		int choice=in.nextInt();
		//getting the result of the toss
		int n=(int) (Math.random() + 0.5);
		//checking if the user won the toss or not
		if(choice==n) {
		System.out.println("Player will proceed");
		//Letting player choose a character between X and O"
		System.out.println("Enter a character between X and O");
		playerChar=str.nextLine();
		String turn = "X";
		if(playerChar.equals(turn))
			computerChar = "O";
		else
			computerChar="X";

		}
		else {

			System.out.println("Computer will proceed");
			//Letting the computer choose randomly X and O
			int result=(int) (Math.random() + 0.5);
			if(result == 1){
			computerChar="0";
			playerChar="X";
			}
			else{
			computerChar="X";
			playerChar="O";
			}
		}

		System.out.println("Welcome to 2 Player Tic Tac Toe.");
		System.out.println("--------------------------------");
		//showing the board to the user
		printBoard();

	}


}
