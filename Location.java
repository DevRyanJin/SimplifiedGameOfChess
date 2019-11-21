
// CLASS: Location
//
// Author: Sijin Lee, 7822352
//
// REMARKS: A Location read a row and column on a Chess board.  This is preferable
//          to storing these values separately, because it performs error checking; if
//          a Location object exists, then it corresponds to a specific spot on the
//          board.
//
//-----------------------------------------

public class Location {
    private int row;
    private char col;


    //------------------------------------------------------
    // Location()
    //
    // PURPOSE:  If the String cannot be parsed into a valid Location,
     //          or if the int and char do not correspond to a spot on
    //           the chess board, then it will throw an IllegalArgumentException
    // PARAMETERS:
    //    String
    // Returns:  Location Object
    public Location(String s) throws IllegalArgumentException {
        char col = s.charAt(0);
        int row;
        try {
            Integer i = Integer.decode(s.substring(1,2));
            row = i.intValue();
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(s + " could not be parsed into " +
                    "a Location");
        }
        checkRowCol(col, row);
        this.row = row;
        this.col = col;
    }

    //------------------------------------------------------
    // Location(char col, int row)
    //
    // PURPOSE:   If the parameters do not correspond to a spot on the chess board,
    //            then it will throw an IllegalArgumentException.
    // PARAMETERS:
    //    char, int
    // Returns:  Location Object
    public Location(char col, int row) throws IllegalArgumentException {
        checkRowCol(col, row);
        this.row = row;
        this.col = col;
    }

    //------------------------------------------------------
    // Location(int colIndex, int rowIndex)
    //
    // PURPOSE: IllegalArgumentException if the indices are out of bounds
    //
    // PARAMETERS:
    //    int, int
    // Returns:  Location Object
    public Location(int colIndex, int rowIndex) throws IllegalArgumentException {
        this((char)('a'+colIndex), rowIndex+1);
    }


    //------------------------------------------------------
    //checkRowCol(char col, int row)
    //
    // PURPOSE: Check to see if the input col and row are valid chessboard locations.
    //
    // PARAMETERS:
    //    char, int
    // Returns:  Location Object
    private void checkRowCol(char col, int row) throws IllegalArgumentException {
        if (row < 1 || row > 8)
            throw new IllegalArgumentException("Row is bad: " + row);
        if (col < 'a' || col > 'h')
            throw new IllegalArgumentException("Column is bad: " + col);
    }

    //------------------------------------------------------
    // getRow()
    //
    // PURPOSE: Returns the row of the Location.
    //
    // PARAMETERS:
    //    None
    // Returns:  int
    public int getRow() {
        return row;
    }


    //------------------------------------------------------
    // getCol()
    //
    // PURPOSE: Returns the col of the Location.
    //
    // PARAMETERS:
    //    None
    // Returns:  int
    public char getCol() {
        return col;
    }


    //------------------------------------------------------
    // getRowIndex() {

    //
    // PURPOSE: it returns 0-7.  This is helpful for putting Locations into arrays.
    //
    // PARAMETERS:
    //    None
    // Returns:  int
    public int getRowIndex() {
        return row-1;
    }


    //------------------------------------------------------
    // getColIndex() {
    //
    // PURPOSE: it returns 0-7.  This is helpful for putting Locations into arrays.
    //
    // PARAMETERS:
    //    None
    // Returns:  int
    public int getColIndex() {
        return (col-'a');
    }


    //------------------------------------------------------
    //  toString()
    //
    // PURPOSE: Returns, for example, the String "a5"
    //
    // PARAMETERS:
    //    None
    // Returns:  String
    @Override
    public String toString() {
        return ""+col+row;
    }


    //------------------------------------------------------
    // equals(Object o)
    //
    // PURPOSE: Determines if two Locations are equal.
    //
    // PARAMETERS:
    //   Object
    // Returns:  boolean
    @Override
    public boolean equals(Object o) {
        if (o.getClass()!=this.getClass())
            return false;
        Location o2 = (Location)o;
        return (row == o2.getRow() && col == o2.getCol());
    }

    //------------------------------------------------------
    // diagLocations(Location start, Location end)getColIndex() {
    //
    // PURPOSE: Given two Locations, on a diagonal, returns an array of Locations
    //         between the two, not including start, and INCLUDING end.
    //
    // PARAMETERS:
    //    Location, Location
    // Returns:  Location[]
    public static Location[] diagLocations(Location start, Location end) {
        if (Math.abs(end.getRow()-start.getRow())!=
                Math.abs(end.getCol()-start.getCol()))
            throw new IllegalArgumentException();
        Location[] array = new Location[Math.abs(end.getRow() - start.getRow())];
        int rInc;
        if (end.getRow() > start.getRow())
            rInc = 1;
        else
            rInc = -1;
        int cInc;
        if (end.getCol() > start.getCol())
            cInc = 1;
        else
            cInc = -1;
        for (int i = 0; i < array.length; i++) {
            array[i] = new Location(
                    (char)(start.getCol()+((i+1)*cInc)),
                    start.getRow()+((i+1)*rInc) );
        }
        return array;
    }


    //------------------------------------------------------
    // colLocations(Location start, Location end)
    //
    // PURPOSE:  Given two Locations, on a column, returns an array of Locations
    //           between the two, not including start, and INCLUDING end.
    // PARAMETERS:
    //    Location, Location
    // Returns:  Location[]
    public static Location[] colLocations(Location start, Location end) {
        if (start.getCol() != end.getCol())
            throw new IllegalArgumentException();
        Location[] array = new Location[Math.abs(end.getRow() - start.getRow())];
        int inc;
        if (end.getRow() > start.getRow())
            inc = 1;
        else
            inc = -1;
        for (int i = 0; i < array.length; i++) {
            array[i] = new Location( start.getCol(),
                    start.getRow()+((i+1)*inc) );
        }
        return array;
    }


    //------------------------------------------------------
    // rowLocations(Location start, Location end)
    //
    // PURPOSE:  Given two Locations, on a column, returns an array of Locations
    //           between the two, not including start, and INCLUDING end.
    // PARAMETERS:
    //    Location, Location
    // Returns:  Location[]
    public static Location[] rowLocations(Location start, Location end) {
        if (start.getRow() != end.getRow())
            throw new IllegalArgumentException();
        Location[] array = new Location[Math.abs(end.getCol() - start.getCol())];
        int inc;
        if (end.getCol() > start.getCol())
            inc = 1;
        else
            inc = -1;
        for (int i = 0; i < array.length; i++) {
            array[i] = new Location(
                    (char)(start.getCol()+((i+1)*inc)),
                    start.getRow());
        }
        return array;
    }
}
