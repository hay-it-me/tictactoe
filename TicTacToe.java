import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        //Create an object for a new TTT game.
        System.out.println("Welcome to Tic-Tac-Toe");
        System.out.println("Place your tiles by entering the locations as shown:"); 
		System.out.println("upperLeft, upperCenter, upperRight");
		System.out.println("middleLeft, middleCenter, middleRight");
		System.out.println("bottomLeft, bottomCenter, bottomRight");
		StartTTT game = new StartTTT();
        
        while (true){
            if (game.checkForWin() != true && game.boardFull() != true){
                System.out.println("Enter a location to place your tile: ");
                game.tttSystem(userInput.nextLine());
            }
            else if (game.boardFull() == true){
                System.out.println("It's a draw!");
                break;
            }
            else {
                if (game.getPlayerNum() == 1){
                	System.out.println("Player 2 has won!!")
                	break;
				}
				else {
					System.out.println("Player 1 has won!!")
                	break;
				}
            }  
        }
    }
}