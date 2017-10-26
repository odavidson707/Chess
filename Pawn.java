//package chess;

import java.util.ArrayList;


public class Pawn extends Piece {
    public Pawn (char setRank, char setColor, int [] setPosition)
    {
        rank = 'P';
        color = setColor;
        position = setPosition;
    }
    public Pawn (int [] setPosition)
    {
        rank = 'L';
        color = 'G';
        position = setPosition;
    }
    public ArrayList <ArrayList<Integer>> legalMoves(Piece [][] board)
    {
        ArrayList <ArrayList<Integer>> moves = new ArrayList <ArrayList<Integer>>();
        ArrayList <Integer> move = new ArrayList<Integer>();
        ArrayList <Integer> move2 = new ArrayList<Integer>();
        ArrayList <Integer> move3 = new ArrayList<Integer>();
        ArrayList <Integer> move4 = new ArrayList<Integer>();
        ArrayList <Integer> move5 = new ArrayList<Integer>();
        ArrayList <Integer> move6 = new ArrayList<Integer>();
        ArrayList <Integer> move7 = new ArrayList<Integer>();
        ArrayList <Integer> move8 = new ArrayList<Integer>();
        ArrayList <Integer> move9 = new ArrayList<Integer>();
        ArrayList <Integer> temp = new ArrayList <Integer>();

        int [] shadowPos = new int [2];

        if (this.getColor() == 'W')
        {
            if (position [1] == 1)//double move is allowed.
            {
                if (board[position [0]] [position [1]+2].getColor() == 'G')
                {
                    move7.add(position [0]);
                    move7.add(position [1] + 2);
                    moves.add(move7);
                }
            }

            if (position [1] == 4 && position [0] != 0)//take a black ShadowPawn that is up and to the left.
            {
                if (board [position [1] + 1][position [0] -1].getRank() =='S')
                {
                    move8.add(position [0] - 1);
                    move8.add(position [1] + 1);
                    moves.add(move8);
                    temp = new ArrayList <Integer>();
                }
            }

            if (position [1] == 4 && position [0] != 7)//take a black ShadowPawn that is up and to the right.
            {
                if (board [position [1] + 1][position [0] + 1].getRank() =='S')
                {
                    move9.add(position [0] + 1);
                    move9.add(position [1] + 1);
                    moves.add(move9);
                }
            }

            if (position [1] != 7)
            {
                if (board[position [0]] [position [1]+1].getColor() == 'G')
                {
                    move.add(position [0]);
                    move.add(position [1] + 1);
                    moves.add(move);
                }
            }
            if (position [1] != 7 && position [0] != 0)
            {
                if (board[position [0] - 1] [position [1]+1].getColor() != 'G' && board[position [0] - 1] [position [1]+1].getColor() != this.getColor())
                {//Capture diagonal left.
                    move2.add(position [0] - 1);
                    move2.add(position [1] + 1);
                    moves.add(move2);
                }
            }
            if (position [1] != 7 && position [0] != 7)
            {
                if (board[position [0] + 1] [position [1]+1].getColor() != 'G' && board[position [0] + 1] [position [1]+1].getColor() != this.getColor())
                {//Capture diagonal right.
                    move3.add(position [0] + 1);
                    move3.add(position [1] + 1);
                    moves.add(move3);
                }
            }
        }

        else
        {
            if (position [1] == 6)//en passant/double move is allowed.
            {
                if (board[position [0]] [position [1]-2].getColor() == 'G')
                {
                    move7.add(position [0]);
                    move7.add(position [1] - 2);
                    moves.add(move7);

                }
            }

            if (position [1] == 3 && position [0] != 0)//take a white ShadowPawn that is down and to the left.
            {
                if (board [position [1] - 1][position [0] - 1].getRank() =='S')
                {
                    move8.add(position [0] - 1);
                    move8.add(position [1] - 1);
                    moves.add(move8);
                }
            }

            if (position [1] == 4 && position [0] != 7)//take a white ShadowPawn that is down and to the right.
            {
                if (board [position [1] - 1][position [0] + 1].getRank() =='S')
                {
                    move9.add(position [0] + 1);
                    move9.add(position [1] - 1);
                    moves.add(move9);
                }
            }

            if (position [1] != 0)
            {
                if (board[position [0]] [position [1]-1].getColor() == 'G')
                {
                    move4.add(position [0]);
                    move4.add(position [1] - 1);
                    moves.add(move4);
                }
            }
            if (position [1] != 0 && position [0] != 0)
            {
                if (board[position [0] - 1] [position [1]-1].getColor() != 'G' && board[position [0] - 1] [position [1]-1].getColor() != this.getColor())
                {//Capture diagonal left.
                    move5.add(position [0] - 1);
                    move5.add(position [1] - 1);
                    moves.add(move5);
                }
            }
            if (position [1] != 0 && position [0] != 7)
            {
                if (board[position [0] + 1] [position [1]-1].getColor() != 'G' && board[position [0] + 1] [position [1]-1].getColor() != this.getColor())
                {//Capture diagonal right.
                    move6.add(position [0] + 1);
                    move6.add(position [1] - 1);
                    moves.add(move6);
                }
            }
        }
        return moves;
    }

	/*public void increment()
	{
	}*/
}
//pos [0] is hoz.
