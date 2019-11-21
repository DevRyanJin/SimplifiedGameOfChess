// CLASS: Piece
//
// Author: Sijin Lee, 7822352
//
// REMARKS: abstract class Piece to be overwritten by any of subclass
//
//-----------------------------------------
public abstract class Piece
{
    // static member variables
    public static final int WHITE = 1;
    public static final int BLACK = 2;

    protected Location loc;
    protected final int color;

    //------------------------------------------------------
    // Piece()
    //
    // PURPOSE:  constructor for Piece abstract Class
    // PARAMETERS:
    //    char, int, int
    // Returns:  Piece Object
    protected Piece(char col,int row,int color)throws IllegalArgumentException
    {
        this.loc = new Location(col,row);
        this.color = color;
    }

    //------------------------------------------------------
    // Piece(Location loc, int color)
    //
    // PURPOSE:  constructor for Piece abstract Class
    // PARAMETERS:
    //    Location, int
    // Returns:  Piece Object
    Piece(Location loc, int color)
    {
        this.loc = new Location(loc.toString());
        this.color = color;
    }


    //------------------------------------------------------
    // setLocation(int col,int row)
    //
    // PURPOSE:  set the corresponding object
    // PARAMETERS:
    //  int, int
    // Returns: None
    public void setLocation(int col,int row)
    {
        this.loc = new Location(col,row);
    }

    //------------------------------------------------------
    // getter methods
    //
    // PURPOSE:  get Location and Color of the object
    // PARAMETERS:
    //   None
    // Returns: loc, color (static variables)
    public Location getLoc()
    {
        return loc;
    }

    public int getColor()
    {
        return color;
    }


    //------------------------------------------------------
    // abstract methods
    //
    // PURPOSE:  These methods must be implemented in subclasses to overwrite
    // PARAMETERS:
    //   None
    // Returns: loc, color (static variables)
    public abstract Location[] mustBeOpen(Location toSpot) throws IllegalArgumentException;

    public abstract boolean makeMove(Location toSpot);

    public abstract String toString();

}
