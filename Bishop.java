// CLASS: Bishop
//
// Author: Sijin Lee, 7822352
//
// REMARKS: Implements Bishop inherited by Piece
//
//-----------------------------------------

public class Bishop extends Piece
{
    //------------------------------------------------------
    // Bishop()
    //
    // PURPOSE:  constructor for Bishop Class
    // PARAMETERS:
    //    char, int, int
    // Returns:  Bishop Object
    protected Bishop(char col, int row, int color) throws IllegalArgumentException
    {
        super(col, row, color);
    }

    //------------------------------------------------------
    // Bishop()
    //
    // PURPOSE:  constructor for Bishop Class
    // PARAMETERS:
    //   Location, int
    // Returns: Bishop Object
    Bishop(Location loc, int color)
    {
        super(loc,color);
    }


    //------------------------------------------------------
    // mustBeOpen(Location toSpot)
    //
    // PURPOSE:  Control the movement of Bishop to check if it moves to correct direction
    // PARAMETERS:
    //   Location
    // Returns: Location[]
    @Override
    public Location[] mustBeOpen(Location toSpot) throws IllegalArgumentException
    {
        if (Math.abs(this.loc.getRow()-toSpot.getRow())!=
                Math.abs(this.loc.getCol()-toSpot.getCol()))
            throw new IllegalArgumentException("Bishop must move diagonally");

        return this.loc.diagLocations(this.loc,toSpot);
    }

    //------------------------------------------------------
    // makeMove(Location toSpot)
    //
    // PURPOSE:  make bishop move
    // PARAMETERS:
    //   Location
    // Returns: boolean
    @Override
    public boolean makeMove(Location toSpot)
    {
        //No need to check as mustBeOpen() checks for same diagonal conditions

        this.loc = toSpot;

        return true;
    }


    //------------------------------------------------------
    // makeMove(Location toSpot)
    //
    // PURPOSE:  ToString method to return proper Bishop depending on the object
    // PARAMETERS:
    //   None
    // Returns: String
    @Override
    public String toString()
    {
        String s;
        if (color==Piece.WHITE)
            s="B";
        else
            s="b";
        return s;
    }
}