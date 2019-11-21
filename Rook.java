// CLASS: Rook
//
// Author: Sijin Lee, 7822352
//
// REMARKS: Implements Rook inherited by Piece
//
//-----------------------------------------
public class Rook extends Piece
{

    //------------------------------------------------------
    // Rook()
    //
    // PURPOSE:  constructor for Rook Class
    // PARAMETERS:
    //    char, int, int
    // Returns:  Rook Object
    protected Rook(char col, int row, int color) throws IllegalArgumentException
    {
        super(col, row, color);
    }

    //------------------------------------------------------
    // Rook()
    //
    // PURPOSE:  constructor for Rook Class
    // PARAMETERS:
    //   Location, int
    // Returns: Rook Object
    Rook(Location loc, int color)
    {
        super(loc,color);
    }


    //------------------------------------------------------
    // mustBeOpen(Location toSpot)
    //
    // PURPOSE:  Control the movement of Rook check if it moves to correct direction
    // PARAMETERS:
    //   Location
    // Returns: Location[]
    @Override
    public Location[] mustBeOpen(Location toSpot) throws IllegalArgumentException
    {
        if(this.loc.getRow() != toSpot.getRow() && this.loc.getCol() != toSpot.getCol())
            throw new IllegalArgumentException("Rook must move in straight lines");

        if(this.loc.getRow() == toSpot.getRow())
            return this.loc.rowLocations(this.loc,toSpot);
        else
            return this.loc.colLocations(this.loc,toSpot);
    }

    //------------------------------------------------------
    // makeMove(Location toSpot)
    //
    // PURPOSE:  make Rook move
    // PARAMETERS:
    //   Location
    // Returns: boolean
    @Override
    public boolean makeMove(Location toSpot)
    {
        //No need to check as mustBeOpen() checks for row conditions...

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
            s="R";
        else
            s="r";
        return s;
    }

}
