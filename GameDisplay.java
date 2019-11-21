// CLASS: GameDisplay
//
// Author: Sijin Lee, 7822352
//
// REMARKS: Interface for SimpleDisplay class
//
//-----------------------------------------
import java.util.Scanner;

public interface GameDisplay
{

    public int promptForOpponentDifficulty(Scanner sc,int maxDifficulty);
    public void displayBoard(Board board);
    public void summarizeMove(Move move);
    public void gameOver(Player winner);
}
