
public class StartTTT{
    private int playerNum;
	int [] tttGrid = new int[9];	

    //Appropriate getters and setters.
    public void setPlayerNum(int playerNum){
        this.playerNum = playerNum;
    }
    public int getPlayerNum(){
        return playerNum;
    }

    //Starts the Tic-Tac-Toe System
    public StartTTT() {
        initialiseBoard();
        setPlayerNum(1);
        printBoard();
        System.out.println("It's Player 1's Turn!");
    }
    
    
    //Resets the board back to empty values.
    public void initialiseBoard(){
        for (int positions: tttGrid){
            positions = 0;
        }
    }
    public void switchPlayer(){
        if (getPlayerNum() == 1){
            setPlayerNum(2);
            System.out.println("It's Player 2's turn!");
        }
        else {
            setPlayerNum(1);
            System.out.println("It's Player 1's turn!");
        }
    }
    //Parses locations of the tiles into specific integers for the array.
    public int tileNum(String location){
        
		switch (location){
            case "upperLeft": 
                return 0;
			case "upperCenter":
                return 1; 
            case "upperRight":
                return 2;
            case "middleLeft":
                return 3;
            case "middleCenter":
                return 4;
            case "middleRight":
                return 5;
            case "bottomLeft":
                return 6;
            case "bottomCenter":
                return 7;
            case "bottomRight":
                return 8;
            default:
                return 999;
        }
    }
    //Utilises tileNum method to return a array value, checks if the cell
    //has already been taken and will add the players tile to cell if not.
    public void tttSystem(String location){
        int tempNum;
        if (tileNum(location) != 999){
            tempNum = tileNum(location);
            if (tttGrid[tempNum] == 0){
                tttGrid[tempNum] = getPlayerNum();
                switchPlayer();
                System.out.println("The new board is:");
                printBoard();
            }
            else {
                System.out.println("That square is already taken.");
            }
        }
        else {
            System.out.println("Your input was not recognised.");
        }
	}
    //Prints the current board state.
    public void printBoard(){
        System.out.println("-----------------");
        //Loops 3 times to fill the 3 rows within the board.
        for (int i = 0; i < 3; i++){
            System.out.print("|");
            //Loop from 0 to 8 in array, in incriments of 3 (i.e. 0,1,2 then 3,4,5 then 6,7,8)
            for (int j = 3 * i; j < (3 * i) + 3; j++){
                //Distinguishes between players (Player 1 is x's and Player 2 is o's)
                if (tttGrid[j] == 2) {
                    System.out.print(" o |");
                }
                else if (tttGrid[j] == 1){
                    System.out.print(" x |");
                }
                else {
                    System.out.print("   |");
                }
            }
            System.out.println();
            System.out.println("-----------");
        }
    }

    public boolean boardFull(){
        for (int positions: tttGrid){
            if (positions == 0 ){
                return false;
            }
        }
        return true;
    }
    //Checks the rows, columns and diagonals for similar non-zero values to determine a win.
    public boolean checkForWin(){
        if (tttGrid[0] != 0){
            if (tttGrid[0] == tttGrid[1] && tttGrid[1] == tttGrid[2]){
                return true;
            }
            if (tttGrid[0] == tttGrid[3] && tttGrid[3] == tttGrid[6]){
                return true;
            }
		}
        if (tttGrid[4] != 0){
            if (tttGrid[0] == tttGrid[4] && tttGrid[4] == tttGrid[8]){
                return true;
            }
            if (tttGrid[2] == tttGrid[4] && tttGrid[4] == tttGrid[6]){
                return true;
            }
            if (tttGrid[3] == tttGrid[4] && tttGrid[4] == tttGrid[5]){
                return true;
            }
            if (tttGrid[1] == tttGrid[4] && tttGrid[4] == tttGrid[7]){
                return true;
			}
        }
        if (tttGrid[8] != 0){
            if (tttGrid[6] == tttGrid[7] && tttGrid[7] == tttGrid[8]){
                return true;
			}
            if (tttGrid[2] == tttGrid[5] && tttGrid[5] == tttGrid[8]){
                return true;
			}
        }
		return false;
    }
}