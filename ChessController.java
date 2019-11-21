// CLASS: ChessController
//
// Author: Sijin Lee, 7822352
//
// REMARKS: this class will be controlling general events during chess game
//
//-----------------------------------------
import java.util.Scanner;

public class ChessController
{
    GameDisplay gameDisplay;
    Player player1; //White
    Player player2; //Black
    Board board;
    Scanner sc;

    //------------------------------------------------------
    // ChessController(Scanner sc,String player1Name,String player2Name)
    //
    // PURPOSE:  constructor for ChessController Class
    // PARAMETERS:
    //    Scanner, String, String
    // Returns:  ChessController Object
    public ChessController(Scanner sc,String player1Name,String player2Name)
    {
        gameDisplay = new SimpleDisplay();
        player1 = new Human(player1Name);

        if(player2Name != null)
            player2 = new Human(player2Name);

        board = new Board();
        this.sc = sc;
    }

    //------------------------------------------------------
    // promptForOpponentDifficulty(int maxDifficulty)
    //
    // PURPOSE: allows to choose difficulties before the game start
    // PARAMETERS:
    //  int
    // Returns: None
    public void promptForOpponentDifficulty(int maxDifficulty)
    {
        int diffLevel = gameDisplay.promptForOpponentDifficulty(sc,maxDifficulty);

        if(diffLevel == 1)
            player2 = new AI();
    }

    //------------------------------------------------------
    // isGameOver()
    //
    // PURPOSE: to check if the game is over
    // PARAMETERS:
    //  None
    // Returns: boolean
    public boolean isGameOver()
    {
        if(board.winner() != 0)
        {
            gameDisplay.displayBoard(board);

            if(board.winner() == 1)
                gameDisplay.gameOver(player1);
            else
                gameDisplay.gameOver(player2);

            return true;
        }

        return false;
    }

    //------------------------------------------------------
    // movePiece()
    //
    // PURPOSE: display the board
    //          (Print out whose turn it is and summarize the corresponding message)
    // PARAMETERS:
    //  None
    // Returns: None
    public void movePiece()
    {
        System.out.println("BOARD:");
        gameDisplay.displayBoard(board);

        Player current = player2;
        String currentColor = "BLACK";

        if(board.isWhiteTurn())
        {
            current = player1;
            currentColor = "WHITE";
        }

        System.out.println("Turn: "+ current.getName() + "(" + currentColor + ")");

        current.makeMove(sc,board);

        gameDisplay.summarizeMove(board.getPreviousMove());

    }

}
