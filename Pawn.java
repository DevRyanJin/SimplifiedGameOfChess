// CLASS: Pawn
//
// Author: Sijin Lee, 7822352
//
// REMARKS: Implements Pawn inherited by Piece
//
//-----------------------------------------
public class Pawn extends Piece
{
    //------------------------------------------------------
    // Pawn()
    //
    // PURPOSE:  constructor for King Class
    // PARAMETERS:
    //    char, int, int
    // Returns:  Pawn Object
    protected Pawn(char col, int row, int color) throws IllegalArgumentException
    {
        super(col, row, color);
    }


    //------------------------------------------------------
    // Pawn()
    //
    // PURPOSE:  constructor for King Class
    // PARAMETERS:
    //   Location, int
    // Returns: Pawn Object
    Pawn(Location loc, int color)
    {
        super(loc,color);
    }


    //------------------------------------------------------
    // mustBeOpen(Location toSpot)
    //
    // PURPOSE:  Control the movement of Pawn check if it moves to correct direction
    // PARAMETERS:
    //   Location
    // Returns: Location[]
    @Override
    public Location[] mustBeOpen(Location toSpot) throws IllegalArgumentException
    {
        if(this.color == Piece.BLACK)
        {
            if(this.loc.getRow()-1 != toSpot.getRow())
                throw new IllegalArgumentException("Black Pawn must move just 1 step down/across the board");
            if(Math.abs(this.loc.getCol()-toSpot.getCol()) > 1)
                throw new IllegalArgumentException("Black Pawn must move just 1 step down/across the board");

            if(this.loc.getCol() == toSpot.getCol())
            {
                Location[] locs = new Location[2];
                locs[0] = new Location(toSpot.toString());
                locs[1] = new Location(toSpot.toString());
                //2 locs - 1 is dummy to counter length-1 in makeMove of Board...
                return locs;
            }
            else
                return new Location[0];
        }
        else
        {
            if(this.loc.getRow()+1 != toSpot.getRow())
                throw new IllegalArgumentException("White Pawn must move just 1 step up/across the board");
            if(Math.abs(this.loc.getCol()-toSpot.getCol()) > 1)
                throw new IllegalArgumentException("White Pawn must move just 1 step up/across the board");

            if(this.loc.getCol() == toSpot.getCol())
            {
                Location[] locs = new Location[2];
                locs[0] = new Location(toSpot.toString());
                locs[1] = new Location(toSpot.toString());
                //2 locs - 1 is dummy to counter length-1 in makeMove of Board...
                return locs;
            }
            else
                return new Location[0];
        }
    }

    //------------------------------------------------------
    // makeMove(Location toSpot)
    //
    // PURPOSE:  make Pawn move
    // PARAMETERS:
    //   Location
    // Returns: boolean
    @Override
    public boolean makeMove(Location toSpot)
    {
        //No need to check as mustBeOpen() checks for move forward/capturing conditions

        this.loc = toSpot;

        return true;
    }

    //------------------------------------------------------
    // toString()
    //
    // PURPOSE:  ToString method to return proper Pawn depending on the object
    // PARAMETERS:
    //   None
    // Returns: String
    @Override
    public String toString()
    {
        String s;
        if (color==Piece.WHITE)
            s="P";
        else
            s="p";
        return s;
    }
}
