// CLASS: Board
//
// Author: Sijin Lee, 7822352
//
// REMARKS: Set up initial chess board and update board
//
//-----------------------------------------
public class Board
{
    private Piece[][] board;
    private boolean whiteTurn;
    Move previousMove;

    //------------------------------------------------------
    // Board()
    //
    // PURPOSE:  constructor for Board Class
    // PARAMETERS:
    //    None
    // Returns:  Board Object
    public Board()
    {
        this.board = new Piece[8][8];
        this.whiteTurn = true;
        this.previousMove = null;
        setUpBoard();
    }

    //------------------------------------------------------
    // setupBoard()
    //
    // PURPOSE:  set up the initial board
    // PARAMETERS:
    //    None
    // Returns:  None
    private void setUpBoard()
    {

        board[0][0] = new Rook(new Location(0,0),Piece.WHITE);
        board[0][7] = new Rook(new Location(7,0),Piece.WHITE);
        board[0][1] = new Knight(new Location(1,0),Piece.WHITE);
        board[0][6] = new Knight(new Location(6,0),Piece.WHITE);
        board[0][2] = new Bishop(new Location(2,0),Piece.WHITE);
        board[0][5] = new Bishop(new Location(5,0),Piece.WHITE);
        board[0][3] = new Queen(new Location(3,0),Piece.WHITE);
        board[0][4] = new King(new Location(4,0),Piece.WHITE);
        for (int c = 0; c < 8; c++)
            board[1][c] = new Pawn(new Location(c,1),Piece.WHITE);

        board[7][0] = new Rook(new Location(0,7),Piece.BLACK);
        board[7][7] = new Rook(new Location(7,7),Piece.BLACK);
        board[7][1] = new Knight(new Location(1,7),Piece.BLACK);
        board[7][6] = new Knight(new Location(6,7),Piece.BLACK);
        board[7][2] = new Bishop(new Location(2,7),Piece.BLACK);
        board[7][5] = new Bishop(new Location(5,7),Piece.BLACK);
        board[7][3] = new Queen(new Location(3,7),Piece.BLACK);
        board[7][4] = new King(new Location(4,7),Piece.BLACK);
        for (int c = 0; c < 8; c++)
            board[6][c] = new Pawn(new Location(c,6),Piece.BLACK);

    }


    public Move getPreviousMove()
    {
        return this.previousMove;
    }

    public Piece getPiece(int row,int col)
    {
        return board[row][col];
    }

    public boolean isWhiteTurn()
    {
        return this.whiteTurn;
    }

    //------------------------------------------------------
    // winner()
    //
    // PURPOSE:  to determine winner
    // PARAMETERS:
    //   None
    // Returns:  int

    public int winner()
    {

        int kingCount = 0;

        for (Piece[] c : board)
            for (Piece p : c)
                if (p != null && p instanceof King)
                    if (p.getColor() == Piece.WHITE)
                        kingCount++;
                    else
                        kingCount--;


        return kingCount;
    }


    //------------------------------------------------------
    // makeMove()
    //
    // PURPOSE:  make the piece move with error checking and update board properly
    // PARAMETERS:
    //   String, String
    // Returns:  None
    public void makeMove(String from, String to) throws
            IllegalArgumentException
    {

        Location a = new Location(from);
        int ar = a.getRowIndex();
        int ac = a.getColIndex();
        if (board[ar][ac] == null)
            throw new IllegalArgumentException(from + " does not have a piece on it.");

        if ((board[ar][ac].getColor()==Piece.WHITE) != whiteTurn)
            throw new IllegalArgumentException(from +
                    " has a Piece of the wrong color.");

        Location b = new Location(to);

        int br = b.getRowIndex();
        int bc = b.getColIndex();

        // If the array has pieces at "from" and "to" that are the same color,
        //   throw an Exception.  Note this depends on Piece having a getColor()
        //   method.
        if (board[br][bc] != null &&
                (board[br][bc].getColor()==board[ar][ac].getColor()))
            throw new IllegalArgumentException(to +
                    " holds a piece the same color as " + from);

        // This code handles checking to see if there are pieces in the way of the
        // move.

        Location[] locs = board[ar][ac].mustBeOpen(b);
        for (int i = 0; i < locs.length-1; i++) {
            if (board[locs[i].getRowIndex()][locs[i].getColIndex()] != null)
                throw new IllegalArgumentException("Other pieces in the way.");
        }

        if(board[ar][ac] instanceof Pawn) //pawn cannot move diagonally if there is an empty space..
        {
            if((ac != bc) && (board[br][bc] == null))
                throw new IllegalArgumentException("Illegal move for the Piece.");
        }

        // If the Piece successfully makes the move, update the board array, and
        // change whose turn it is.

        if (board[ar][ac].makeMove(b))
        {
            this.previousMove = new Move(board[ar][ac],a,b,board[br][bc]); //Update previous move...
            board[br][bc] = board[ar][ac];
            board[ar][ac] = null;
            whiteTurn = !whiteTurn;
        }
        else
            throw new IllegalArgumentException("Illegal move for the Piece.");
    }
}