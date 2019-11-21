// CLASS: Player
//
// Author: Sijin Lee, 7822352
//
// REMARKS: interface for AI and Human class
//
//
//-----------------------------------------
import java.util.Scanner;

public interface Player
{
    public void makeMove(Scanner sc,Board board);

    public String getName();
}
