// CLASS: SimpleDisplay
//
// Author: Sijin Lee, 7822352
//
// REMARKS: Implements GameDisplay.
//           This class implements an GameDisplay interface, so inheriting the abstract methods of the interface
//
//-----------------------------------------
import java.util.Scanner;

public class SimpleDisplay implements GameDisplay
{
    //------------------------------------------------------
    // promptForOpponentDifficulty(Scanner sc, int maxDifficulty)
    //
    // PURPOSE: allows to choose difficulties before the game start
    // PARAMETERS:
    //  Scanner, int
    // Returns: int
    @Override
    public int promptForOpponentDifficulty(Scanner sc, int maxDifficulty)
    {
        int value;
        do
        {
            System.out.printf("\nEnter the difficulty : (Min=1,Max=%d)",maxDifficulty);
            value = sc.nextInt();

            if(value < 1 || value > maxDifficulty)
                System.out.println("Incorrect Value. Enter again.");

        }while(value < 1 || value > maxDifficulty);

        return value;
    }


    //------------------------------------------------------
    // displayBoard(Board board)
    //
    // PURPOSE: display the board
    //          (Print out whose turn it is and summarize the corresponding message)
    // PARAMETERS:
    //  None
    // Returns: None
    @Override
    public void displayBoard(Board board)
    {
        String value = "\n  ";

        for (int c = 0; c < 8; c++)
            value = value + (char)(c+'a')+ " ";

        value = value + "\n";

        for (int r = 7; r >= 0; r--)
        {
            value = value + (r+1) + " ";

            for (int c = 0; c < 8; c++)
            {
                Piece piece = board.getPiece(r,c);

                if (piece != null)
                    value = value + piece + " ";
                else
                    value = value + "- ";
            }
            value = value + "\n";
        }

        System.out.println(value+"\n");

    }

    //------------------------------------------------------
    // summarizeMove(Move move)
    //
    // PURPOSE: summarize the movement after player or Ai make decision where to move
    //
    // PARAMETERS:
    //  Move
    // Returns: None
    @Override
    public void summarizeMove(Move move)
    {
        if(move == null)
            System.out.println("\nNo move made.");
        else
            System.out.println("\nMove Made:"+"\n"+move.message());

    }

    //------------------------------------------------------
    // gameOver(Player winner)
    //
    // PURPOSE: print out the Game over message and winner
    //
    // PARAMETERS:
    //  Player
    // Returns: None
    @Override
    public void gameOver(Player winner)
    {
        System.out.println("Game Over...");
        System.out.println(winner.getName()+" Wins!");

    }

}
