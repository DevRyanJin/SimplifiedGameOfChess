// CLASS: Move
//
// Author: Sijin Lee, 7822352
//
// REMARKS: to show the proper message when piece is moved and captured
//
//-----------------------------------------
public class Move
{
    Piece pieceMoved;
    Piece pieceCaptured;
    Location fromLoc;
    Location toLoc;

    //------------------------------------------------------
    // Move()
    //
    // PURPOSE:  constructor for Move Class
    // PARAMETERS:
    //    Piece, Location, Location, Piece
    // Returns:  Move Object
    public Move(Piece pieceMoved,Location fromLoc,Location toLoc,Piece pieceCaptured)
    {
        this.pieceMoved = pieceMoved;
        this.fromLoc = fromLoc;
        this.toLoc = toLoc;
        this.pieceCaptured = pieceCaptured;
    }

    //------------------------------------------------------
    // message()
    //
    // PURPOSE:  to get corresponding message after the piece movement
    // PARAMETERS:
    //   None
    // Returns: String

    public String message()
    {
        String movedName = this.pieceMoved.getClass().getName();

        movedName = movedName + " moved from " + fromLoc + " to " + toLoc + " . ";

        if(this.pieceCaptured == null)
            movedName = movedName + "No pieces were captured";
        else
            movedName = movedName + this.pieceCaptured.getClass().getName() + " captured.";

        return movedName;
    }
}
