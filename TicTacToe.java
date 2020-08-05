import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

	static Scanner in;
	static String[] board;
	static String turn;


	static String checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}

		System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
		return null;
	}


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
		Scanner str= new Scanner(System.in);
		board = new String[9];
		String winner = null;
		int player=0;
		int computer=0;
		//static String turn=null;
		populateEmptyBoard();

		String computerChar= null;
		String playerChar= null;

		System.out.println("Enter a number between 0 and 1");
		int choice=in.nextInt();
		int n=(int) (Math.random() + 0.5);
		//checking if the user won the toss or not
		if(choice==n) {
		System.out.println("Player will proceed");
		player=1;
		//Letting player choose a character between X and O"
		System.out.println("Enter a character between X and O");
		playerChar=str.nextLine();
		turn=playerChar;
		String t = "X";
		if(playerChar.equals(t))
			computerChar = "O";
		else
			computerChar="X";

		}
		else {

			System.out.println("Computer will proceed");
			 computer=1;
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
			turn=computerChar;
		}

		System.out.println("Welcome to 2 Player Tic Tac Toe.");
		System.out.println("--------------------------------");
		//showing the board to the player
		printBoard();
		if( player == 1){
		System.out.println("Player  will play first. Enter a slot number to place" +turn +" in:");
		}
		if(computer == 1){
		System.out.println("Computer  will play first. Enter a slot number to place" +turn +" in:");
		}


		while (winner == null) {
			int numInput;
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println("Invalid input; re-enter slot number:");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input; re-enter slot number:");
				continue;
			}
			if (board[numInput-1].equals(String.valueOf(numInput))) {
				board[numInput-1] = turn;
				if (turn.equals("X")) {
					turn = "O";
				} else {
					turn = "X";
				}
				printBoard();
				winner = checkWinner();
			} else {
				System.out.println("Slot already taken; re-enter slot number:");
				continue;
			}
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}
	}
	}

