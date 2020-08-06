
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class TicTacToe {

	//defining the board
	static String[] board = new String[9];
	private static Scanner in;

	//characters both player and computer will take
	static String playerChar;
	static String computerChar;

	static Random random = new Random();
	static int input;
	static String turn = null;
	static String win = null;
	static int computerWinPosition;
	static int playerWinPosition = 0;
 
	/*
	 * Function to get the characters
         */
        static void getCharacters() {
                String choice;
                System.out.println("Select X or O");
                while (true) {
                        choice = in.next();

                        if (choice.equals("X") || choice.equals("O") || choice.equals("x") || choice.equals("o")) {
                                if(choice.equals("x"))
                                        playerChar="X";
                                else if(choice.equals("o"))
                                        playerChar="O";
                                else
                                        playerChar=choice;
                                System.out.println("Player's choice " + playerChar);

                                boolean computerChoice = random.nextBoolean();
                                if (computerChoice == true && playerChar.equals("O"))
                                        computerChar = "X";
                                else
                                        computerChar = "O";
                                break;
                        }

                        else
                                System.out.println("Invalid Choice !! choose X OR O");
                        continue;
                }
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


	public static void main(String[] args) {

		TicTacToe tictacgame = new TicTacToe();
		in = new Scanner(System.in);
		String result=null;
		populateEmptyBoard(); // function call to reset the board
		getCharacters();
		turn = chooseTurn();


		System.out.println("Welcome to Tic Tac Toe Game");
		System.out.println("--------------------------------");

		printBoard(); // function call to display board
		result=playGame(tictacgame); //function call to play game

		if (result.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw!");
		} else {
			String winner = (result.equals(playerChar)) ? "Player" : "Computer";
			System.out.println("Congratulations! " + winner + " has won! ");
		}
	}
   
	/*
	 * Function to play tic tac toe game.
	 */
	static String playGame(TicTacToe tictacgame) {
		// playing untill we have a winner
		while (win == null) {
			if (turn.equals(playerChar)) {
				System.out.println("Enter a slot number to place " + playerChar + " in:");
				input = in.nextInt();
				if (!(input > 0 && input <= 9)) {
					System.out.println("Invalid input; enter slot number:");
					continue;
				}
			} else {
				System.out.println("Computer's turn");
				computerWinPosition = checkPosition(board, computerChar);
				playerWinPosition = checkPosition(board, playerChar);
				input=computerPosition(computerWinPosition, playerWinPosition);
				System.out.println("Computer's input " + input);
			}
			if (board[input - 1].equals(String.valueOf(input))) {
				board[input - 1] = turn;
				printBoard(); // function call to display board
				win = winnerCheck(); // function call to check the winner
				if (turn.equals(playerChar)) {
					turn = computerChar;
				} else {
					turn = playerChar;
				}

			} else {
				System.out.println("Slot already taken; enter slot number:");
				if (turn.equals(computerChar))
					input = random.nextInt(10 - 1) + 1;
			}
		}
		return win;
	}
	static int computerPosition(int computerPosition, int playerPosition) {
		if (computerWinPosition == 0 && playerWinPosition == 0) {
			input = checkOtherPosition();
			System.out.println(input);
		}

		else if (computerWinPosition != 0) {
			input = computerWinPosition;
		}

		else if (playerWinPosition != 0) {
			input = playerWinPosition;
		}
		return input;
		
	}

	

	/*
	 * Function to display the board
	 */

	static void printBoard() {
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
	}

	/*
	 * Function to reset the  board
	 */
	static void populateEmptyBoard() {
		for (int i = 0; i < board.length; i++) {
			board[i] = String.valueOf(i + 1);
		}
	}

	/*
	 * Function to choose who plays first
	 */
	static String chooseTurn() {
		boolean toss = random.nextBoolean();
		if (toss == true) {
			System.out.println("Player turn");
			return playerChar;
		} else
			System.out.println("Computer turn");
		System.out.println(computerChar);
		return computerChar;
	}

	/*
	 * Function to get corner position or center position
	 */
	static int checkOtherPosition() {
		if (board[0].equals(String.valueOf(1)))
			return 1;
		else if (board[2].equals(String.valueOf(3)))
			return 3;
		else if (board[6].equals(String.valueOf(7)))
			return 7;
		else if (board[8].equals(String.valueOf(9)))
			return 9;
		else if (board[4].equals(String.valueOf(5)))
			return 5;
		else if (board[3].equals(String.valueOf(4)))
			return 4;
		else if (board[5].equals(String.valueOf(6)))
			return 6;
		else
			return random.nextInt(10 - 1) + 1;

	}

	/*
	 * Function to Check the winner
	 */
	static String winnerCheck() {

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
			if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
				break;
			} else if (i == 8)
				return "draw";
		}
		return null;
	}
}
