// CLASS: AI
//
// Author: Sijin Lee, 7822352
//
// REMARKS: Implements AI.
//          This class implements an Player interface, so inheriting the abstract methods of the interface
//
//-----------------------------------------

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class AI implements Player
{
    String name = "AI-Simple";

    private String[] directions = {"N","NE","E","SE","S","SW","W","NW"}; //moving clockwise from North...


    //------------------------------------------------------
    // getAIPiecesOnBoard(Board board)
    //
    // PURPOSE:  to get AI's pieces on board
    // PARAMETERS:
    //  Board
    // Returns: Piece[]
    private Piece[] getAIPiecesOnBoard(Board board) //Considering the fact that by default, AI is BLACK...
    {
        Piece[] pieces = new Piece[0];

        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                Piece piece = board.getPiece(i, j);

                if(piece != null && piece.getColor() == Piece.BLACK)
                {
                    pieces = Arrays.copyOf(pieces, pieces.length + 1);
                    pieces[pieces.length-1] = piece;
                }
            }
        }

        return pieces;
    }

    //------------------------------------------------------
    // getLocationInDirForKnight(Location loc,String dir)
    //
    // PURPOSE:  to get particular location for Knight
    // PARAMETERS:
    //  Location , String
    // Returns: Location
    private Location getLocationInDirForKnight(Location loc,String dir)
    {
        int row = loc.getRowIndex();
        int col = loc.getColIndex();

        if(dir == "N")
        {
            row = row + 2;
            col = col + 1;
        }
        else if(dir == "NE")
        {
            row = row + 1;
            col = col + 2;
        }
        else if(dir == "E")
        {
            row = row - 1;
            col = col + 2;
        }
        else if(dir == "SE")
        {
            row = row - 2;
            col = col + 1;
        }
        else if(dir == "S")
        {
            row = row - 2;
            col = col - 1;
        }
        else if(dir == "SW")
        {
            row = row - 1;
            col = col - 2;
        }
        else if(dir == "W")
        {
            row = row + 1;
            col = col - 2;
        }
        else if(dir == "NW")
        {
            row = row + 2;
            col = col - 1;
        }
        else
            return null;

        Location returnVal;

        try
        {
            returnVal = new Location(col,row);
        }
        catch(Exception ex)
        {
            returnVal = null;
        }

        return returnVal;

    }


    //------------------------------------------------------
    // getLocationInDir(Location loc,String dir)
    //
    // PURPOSE:  to get proper location for other pieces
    // PARAMETERS:
    //  Location, String
    // Returns: Location
    private Location getLocationInDir(Location loc,String dir)
    {
        int row = loc.getRowIndex();
        int col = loc.getColIndex();

        if(dir == "N")
        {
            row++;
        }
        else if(dir == "NE")
        {
            row++;
            col++;
        }
        else if(dir == "E")
        {
            col++;
        }
        else if(dir == "SE")
        {
            row--;
            col++;
        }
        else if(dir == "S")
        {
            row--;
        }
        else if(dir == "SW")
        {
            row--;
            col--;
        }
        else if(dir == "W")
        {
            col--;
        }
        else if(dir == "NW")
        {
            row++;
            col--;
        }
        else
            return null;

        Location returnVal;

        try
        {
            returnVal = new Location(col,row);
        }
        catch(Exception ex)
        {
            returnVal = null;
        }

        return returnVal;

    }


    //------------------------------------------------------
    // makeOneMoveInAnyDirection(Board board,Piece piece)
    //
    // PURPOSE:  make the given piece move by getting proper location from location methods
    // PARAMETERS:
    //  Board, Piece
    // Returns: boolean
    private boolean makeOneMoveInAnyDirection(Board board,Piece piece)
    {
        for(String dir : directions)
        {
            Location loc = null;

            if(piece instanceof Knight)
                loc = this.getLocationInDirForKnight(piece.getLoc(), dir);
            else
                loc = this.getLocationInDir(piece.getLoc(), dir);

            if(loc != null)
            {
                try
                {
                    board.makeMove(piece.getLoc().toString(),loc.toString());
                    return true; //as soon as move done, need to break out...
                }
                catch(Exception ex)
                {
                    //System.out.println(ex.getMessage());
                }
            }
        }

        return false;
    }

    //------------------------------------------------------
    // shuffleArray(Piece[] ar)
    //
    // PURPOSE:  shuffle the given array then it allows us to move AI randomly
    // PARAMETERS:
    //  Piece[]
    // Returns: None
    private void shuffleArray(Piece[] ar)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Piece a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    //------------------------------------------------------
    // makeMove(Scanner sc, Board board)
    //
    // PURPOSE:  make the AI move
    // PARAMETERS:
    //  Scanner, Board
    // Returns: None
    @Override
    public void makeMove(Scanner sc, Board board)
    {
        Piece[] pieces = this.getAIPiecesOnBoard(board);

        this.shuffleArray(pieces); //shuffling the array randomly to make sure we are picking random AI piece to move...

        for(Piece piece : pieces)
        {
            if(this.makeOneMoveInAnyDirection(board, piece))
                break; //as soon as we make one way, our task is done...
        }

    }

    //------------------------------------------------------
    // getName()
    //
    // PURPOSE:  get the name of current object's instance member of name
    // PARAMETERS:
    //  None
    // Returns: this.name
    @Override
    public String getName()
    {
        return this.name;
    }



}
