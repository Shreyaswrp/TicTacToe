import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
	
	static String[] board = new String[9];
	private static Scanner in;
	static String playerInput;
	static String computerInput;
	static boolean toss;
	static boolean choiceLetter;
	static Random random = new Random();
	static int input;
	static String turn=null;
	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		in = new Scanner(System.in);
		int computerWinPosition=0;
		int playerWinPosition=0;
		game.createEmptyBoard(); //function call to reset the board
		chooseLetter();
		turn=game.chooseTurn();
		
		String win = null;
		System.out.println("Welcome to Tic Tac Toe Game");
		System.out.println("--------------------------------");
		
		game.displayBoard(); //function call to display board
		
		//loops till win is null 
		while (win == null) {
			if(turn.equals(playerInput)) {
				System.out.println("Enter a slot number to place "+ playerInput+ " in:");
				input = in.nextInt();
				if (!(input > 0 && input <= 9)) {
					System.out.println("Invalid input; enter slot number:");
					continue;
				}
			}
			else {
				System.out.println("Computer's turn");
				computerWinPosition=checkPosition(board,computerInput);
				playerWinPosition=checkPosition(board, playerInput);
				if(computerWinPosition == 0 && playerWinPosition == 0) {
					input=random.nextInt(10-1)+1;
				}
				else if(computerWinPosition != 0) {
					input=computerWinPosition;
				}
				else if(playerWinPosition != 0) {
					input=playerWinPosition;
				}
				System.out.println("Computer's input "+input);
			}
			if (board[input-1].equals(String.valueOf(input))) {
				board[input-1] = turn;
				game.displayBoard(); // function call to display board
				win = game.winnerCheck(); // function call to check the winner
				if (turn.equals(playerInput)) {
					turn = computerInput;
				} else {
					turn = playerInput;
				}

			} else {
				System.out.println("Slot already taken; enter slot number:");
				if(turn.equals(computerInput))
					input=random.nextInt(10-1)+1;
			}
		}
		if (win.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			String winner=(win.equals(playerInput)) ? "Player" : "Computer";
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}
	}

	/*
	 * Function to choose the letter
	 */
	static void chooseLetter() {
		System.out.println("Select X or O");
		while(true) {
		playerInput=in.next();
		
		if( playerInput.equals("X") || playerInput.equals("O")) {
			System.out.println("Player's choice "+playerInput);
			
			choiceLetter=random.nextBoolean();
			if(choiceLetter == true && playerInput.equals("O")) 
				computerInput="X";
			else
				computerInput="O";
				break;
		}
		
		else
			System.out.println("Invalid Choice !! choose X OR O");
			continue;
		}
	}
	
	/*
	  Function Displays the tic tac toe board
	 */
	
	void displayBoard() {
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
	}
	
	/*
	 * Function to create to reset board 
	 */
	void createEmptyBoard() {
		for (int i = 0; i < board.length; i++) {
			board[i] = String.valueOf(i+1);
		}
	}
	String chooseTurn() {
		boolean toss=random.nextBoolean();
		if(toss == true) {
			System.out.println("Player turn");
			return playerInput;
		}
		else
			System.out.println("Computer turn");
			System.out.println(computerInput);
			return computerInput;
	}

	static int checkPosition(String board[], String userInput) {
		String a="X";
		String b="O";
		int position=0;
		String result = null;
		int input = 0;
		for (int i = 0; i < 23; i++) {
			
			switch (i) {
			case 0:
				result = board[0] + board[1];
				position=3;
				break;
			case 1:
				result = board[3] + board[4];
				position=6;
				break;
			case 2:
				result = board[6] + board[7];
				position=9;
				break;
			case 3:
				result = board[1] + board[2];
				position=1;
				break;
			case 4:
				result = board[4] + board[5];
				position=4;
				break;
			case 5:
				result = board[7] + board[8];
				position=7;
				break;
			case 6:
				result = board[0] + board[3];
				position=7;
				break;
			case 7:
				result = board[1] + board[4];
				position=8;
				break;
			case 8:
				result = board[2] + board[5];
				position=9;
				break;
			case 9: 
				result = board[3] + board[6];
				position=1;
				break;
			case 10:
				result = board[4] + board[7];
				position=2;
				break;
			case 11: 
				result = board[5] + board[8];
				position=3;
				break;
			case 12:
				result = board[0] + board[4];
				position=9;
				break;
			case 13:
				result = board[4] + board[8];
				position=1;
				break;
			case 14:
				result = board[2] + board[4];
				position=7;
				break;
			case 15:
				result = board[4] + board[6];
				position=3;
				break;
			case 16:
				result = board[0] + board[8];
				position=5;
				break;
			case 17:
				result = board[6] + board[2];
				position=5;
				break;
			case 18:
				result = board[0] + board[2];
				position=2;
				break;
			case 19:
				result = board[3] + board[5];
				position=5;
				break;
			case 20:
				result = board[6] + board[8];
				position=8;
				break;
			case 21:
				result = board[0] + board[6];
				position=4;
				break;
			case 22:
				result = board[1] + board[7];
				position=5;
				break;
			case 23:
				result = board[2] + board[8];
				position=6;
				break;
			}
			if (result.equals("XX") && a.equals(userInput) && board[position-1].equals(String.valueOf(position))) 
					return position;
			else if (result.equals("OO") && b.equals(userInput) && board[position-1].equals(String.valueOf(position))) 
					return position;

		}
		return input;
	}
	/*
	 * Function to Check the winner
	 */
	
	String winnerCheck() {
		
		for (int i = 0; i < 8; i++) {
			String result = null;
			switch (i) {
			case 0:
				result = board[0] + board[1] + board[2];
				break;
			case 1:
				result = board[3] + board[4] + board[5];
				break;
			case 2:
				result = board[6] + board[7] + board[8];
				break;
			case 3:
				result = board[0] + board[3] + board[6];
				break;
			case 4:
				result = board[1] + board[4] + board[7];
				break;
			case 5:
				result = board[2] + board[5] + board[8];
				break;
			case 6:
				result = board[0] + board[4] + board[8];
				break;
			case 7:
				result = board[2] + board[4] + board[6];
				break;
			}
			if (result.equals("XXX")) {
				return "X";
			} else if (result.equals("OOO")) {
				return "O";
			} 
		}
		for (int i = 0; i < 9; i++) {
			if (Arrays.asList(board).contains(String.valueOf(i+1))) {
				break;
			}
			else if (i == 8) return "draw";
		}
		return null;
	}
}
