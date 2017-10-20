package chess;

import java.util.ArrayList;


abstract public class Piece {
    public char rank, color;
    public int timesMoved = 0;
    public char getRank() {
        return rank;
    }
    public void setRank(char rank) {
        this.rank = rank;
    }
    public char getColor() {
        return color;
    }
    public void setColor(char color) {
        this.color = color;
    }
    public int[] getPosition() {
        return position;
    }
    public void setPosition(int[] position) {
        this.position = position;
    }
    public int getTimesMoved() {
        return timesMoved;
    }
    public void setTimesMoved(int timesMoved) {
        this.timesMoved = timesMoved;
    }
    public int [] position;
    //abstract public void foo ();
    public Piece (int [] setPosition)
    {
        rank = 'L';//bLank
        color = 'G';//Green
        position = setPosition;
    }
    public Piece (char setRank, char setColor, int [] setPosition)
    {
        rank = setRank;
        color = setColor;
        position = setPosition;
    }
    public Piece ()
    {

    }
    abstract public ArrayList <ArrayList<Integer>> legalMoves(Piece [][] board);
    public void increment(Piece [][]board)
    {

    }
}
