package chess;


import java.util.ArrayList;

public class ShadowPawn extends Piece {
    public int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

	/*public ShadowPawn (int [] setPosition)
	{
		rank = 'L';//bLank
		color = 'G';//Green
		position = setPosition;
	}*/

    /*
     * Rank should be S
     */
    public ShadowPawn (char setRank, char setColor, int [] setPosition)
    {
        rank = setRank;
        color = setColor;
        position = setPosition;
		/*
		 * put a pawn in the square in front of the ShadowPawn when it is made.
		 * Otherwise, the real pawn disappears when moves are hypothesized.
		 * Might not actually work, since I'm not sure if the constructor is called when you set the piece in square.
		 * So do this in undo move (if start is a ShadowPawn, make the appropriate Pawn.
		 */
    }

    //legal moves for ShadowPawn should never be called.
    public ArrayList <ArrayList<Integer>> legalMoves(Piece [][] board)
    {
        ArrayList <ArrayList<Integer>> empty = new ArrayList <ArrayList<Integer>>();
        return empty;
    }

    public void increment (Piece [][] board)
    {
        //System.out.println("It's incrementing.  counter is " + counter);
        if (counter == 0)
        {
            //System.out.println("First time incrementing.");
            counter++;
            return;
        }
        //System.out.println("There should be a new pawn there now.");
        board [position [0]][position [1]] = new Pawn (position);
    }
}
