// CLASS: Queen
//
// Author: Sijin Lee, 7822352
//
// REMARKS: Implements Queen inherited by Piece
//
//-----------------------------------------
public class Queen extends Piece
{
    //------------------------------------------------------
    // Queen()
    //
    // PURPOSE:  constructor for Queen Class
    // PARAMETERS:
    //    char, int, int
    // Returns:  Queen Object
    protected Queen(char col, int row, int color) throws IllegalArgumentException
    {
        super(col, row, color);
    }

    //------------------------------------------------------
    // Queen()
    //
    // PURPOSE:  constructor for Queen Class
    // PARAMETERS:
    //   Location, int
    // Returns: Queen Object
    Queen(Location loc, int color)
    {
        super(loc,color);
    }


    //------------------------------------------------------
    // mustBeOpen(Location toSpot)
    //
    // PURPOSE:  Control the movement of Queen check if it moves to correct direction
    // PARAMETERS:
    //   Location
    // Returns: Location[]
    @Override
    public Location[] mustBeOpen(Location toSpot) throws IllegalArgumentException
    {
        if(this.loc.getRow() == toSpot.getRow() || this.loc.getCol() == toSpot.getCol())
        {
            if(this.loc.getRow() == toSpot.getRow())
                return this.loc.rowLocations(this.loc,toSpot);
            else
                return this.loc.colLocations(this.loc,toSpot);
        }
        else if(Math.abs(this.loc.getRow()-toSpot.getRow())== Math.abs(this.loc.getCol()-toSpot.getCol()))
        {
            return this.loc.diagLocations(this.loc,toSpot);
        }
        else
        {
            throw new IllegalArgumentException("Queen must move either straight or diagonally");
        }

    }

    //------------------------------------------------------
    // makeMove(Location toSpot)
    //
    // PURPOSE:  make Queen move
    // PARAMETERS:
    //   Location
    // Returns: boolean
    @Override
    public boolean makeMove(Location toSpot)
    {
        //No need to check as mustBeOpen() checks for same row/col or diagonal conditions

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
            s="Q";
        else
            s="q";
        return s;
    }
}
