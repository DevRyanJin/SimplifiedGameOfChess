// CLASS: Knight
//
// Author: Sijin Lee, 7822352
//
// REMARKS: Implements Knight inherited by Piece
//
//-----------------------------------------

public class Knight extends Piece
{

    //------------------------------------------------------
    // Knight()
    //
    // PURPOSE:  constructor for King Class
    // PARAMETERS:
    //    char, int, int
    // Returns:  Knight Object
    protected Knight(char col, int row, int color) throws IllegalArgumentException
    {
        super(col, row, color);
    }

    //------------------------------------------------------
    // Knight()
    //
    // PURPOSE:  constructor for King Class
    // PARAMETERS:
    //   Location, int
    // Returns: Knight Object
    Knight(Location loc, int color)
    {
        super(loc,color);
    }


    //------------------------------------------------------
    // mustBeOpen(Location toSpot)
    //
    // PURPOSE:  Control the movement of Knight to check if it moves to correct direction
    // PARAMETERS:
    //   Location
    // Returns: Location[]
    @Override
    public Location[] mustBeOpen(Location toSpot) throws IllegalArgumentException
    {
        //Knight can jump and hence no restrictions on path...

        return new Location[0];
    }

    //------------------------------------------------------
    // makeMove(Location toSpot)
    //
    // PURPOSE:  make Knight move
    // PARAMETERS:
    //   Location
    // Returns: boolean
    @Override
    public boolean makeMove(Location toSpot)
    {
        int rowDiff = Math.abs(this.loc.getRow()-toSpot.getRow());
        int colDiff = Math.abs(this.loc.getCol()-toSpot.getCol());

        if(rowDiff + colDiff != 3)
            return false;

        this.loc = toSpot;

        return true;
    }

    //------------------------------------------------------
    // toString()
    //
    // PURPOSE:  ToString method to return proper King depending on the object
    // PARAMETERS:
    //   None
    // Returns: String
    @Override
    public String toString()
    {
        String s;
        if (color==Piece.WHITE)
            s="N";
        else
            s="n";
        return s;
    }
}