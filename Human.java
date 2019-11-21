// CLASS: Human
//
// Author: Sijin Lee, 7822352
//
// REMARKS:  Implements Human player.
//           This class implements an Player interface, so inheriting the abstract methods of the interface
//
//-----------------------------------------
import java.util.Scanner;

public class Human implements Player
{
    String name;

    //------------------------------------------------------
    // Human(String name)
    //
    // PURPOSE:  constructor for King Class
    // PARAMETERS:
    //    String
    // Returns:  Human Object
    public Human(String name)
    {
        this.name = name;
    }

    //------------------------------------------------------
    // getMove(Scanner sc)
    //
    // PURPOSE:  to get where to move the piece from user input
    // PARAMETERS:
    //  Scanner
    // Returns: String
    private String getMove(Scanner sc)
    {

        String s;
        System.out.println("Please enter a move (e.g. \"b1 to c3\"): ");
        String from = sc.next();
        String word = sc.next();
        String to = sc.next();

        return from + " " + word + " " + to;
    }

    //------------------------------------------------------
    // checkInputValid(String s)
    //
    // PURPOSE: check if the user put correct format
    // PARAMETERS:
    //  String
    // Returns: None
    private void checkInputValid(String s) throws IllegalArgumentException
    {
        if(s.length() != 8)
            throw new IllegalArgumentException("Invalid Input.Try again.");
        String[] tokens = s.split(" ");

        if(!this.checkBounds(tokens[0]) || !this.checkBounds(tokens[2]))
            throw new IllegalArgumentException("Invalid Input.Try again.");

        if(!tokens[1].equals("to"))
            throw new IllegalArgumentException("Invalid Input.Try again.");

    }

    //------------------------------------------------------
    // checkBounds(String s)
    //
    // PURPOSE: check if the
    // PARAMETERS:
    //  String
    // Returns: None

    private boolean checkBounds(String s)
    {
        if(s == null || s.isEmpty() || s.length() != 2)
            return false;

        char col = s.charAt(0);
        char row = s.charAt(1);

        if(col < 'a' || col > 'h')
            return false;

        if(row < '1' || row > '8')
            return false;

        return true;
    }



    @Override
    public void makeMove(Scanner sc, Board board)
    {
        Exception currEx = null;

        do
        {
            try
            {
                String s = getMove(sc);
                this.checkInputValid(s);
                String[] tokens = s.split(" ");
                board.makeMove(tokens[0],tokens[2]);
                currEx = null;
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
                currEx = ex;
            }

        }while(currEx != null);


    }

    @Override
    public String getName()
    {
        return this.name;
    }

}
