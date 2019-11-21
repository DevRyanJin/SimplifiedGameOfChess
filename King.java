// CLASS: King
//
// Author: Sijin Lee, 7822352
//
// REMARKS: Implements King inherited by Piece
//
//-----------------------------------------
public class King extends Piece
{
    //------------------------------------------------------
    // King()
    //
    // PURPOSE:  constructor for King Class
    // PARAMETERS:
    //    char, int, int
    // Returns:  King Object
    protected King(char col, int row, int color) throws IllegalArgumentException
    {
        super(col, row, color);
    }

    //------------------------------------------------------
    // King()
    //
    // PURPOSE:  constructor for King Class
    // PARAMETERS:
    //   Location, int
    // Returns: King Object
    King(Location loc, int color)
    {
        super(loc,color);
    }


    //------------------------------------------------------
    // mustBeOpen(Location toSpot)
    //
    // PURPOSE:  Control the movement of King to check if it moves to correct direction
    // PARAMETERS:
    //   Location
    // Returns: Location[]
    @Override
    public Location[] mustBeOpen(Location toSpot) throws IllegalArgumentException
    {
        if(this.loc.getRow() == toSpot.getRow() || this.loc.getCol() == toSpot.getCol())
        {
            if(this.loc.getRow() == toSpot.getRow())
            {
                if(Math.abs(this.loc.getCol()-toSpot.getCol()) != 1)
                    throw new IllegalArgumentException("King must move 1 step at a time");
                else
                    return new Location[0];
            }
            else
            {
                if(Math.abs(this.loc.getRow()-toSpot.getRow()) != 1)
                    throw new IllegalArgumentException("King must move 1 step at a time");
                else
                    return new Location[0];
            }
        }
        else
        {
            int rowDiff = Math.abs(this.loc.getRow()-toSpot.getRow());
            int colDiff = Math.abs(this.loc.getCol()-toSpot.getCol());

            if(rowDiff + colDiff != 2)
                throw new IllegalArgumentException("King must move 1 step at a time");
            else
                return new Location[0];
        }
    }

    //------------------------------------------------------
    // makeMove(Location toSpot)
    //
    // PURPOSE:  make King move
    // PARAMETERS:
    //   Location
    // Returns: boolean
    @Override
    public boolean makeMove(Location toSpot)
    {
        //No need to check as mustBeOpen() checks for same row/col conditions

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
            s="K";
        else
            s="k";
        return s;
    }
}


