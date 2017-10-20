package chess;

import java.util.ArrayList;


public class King extends Piece {
	/*public void increment()
	{
	}*/
	public King (char setRank, char setColor, int [] setPosition)
	{
		rank = 'K';
		color = setColor;
		position = setPosition;
	}
	public King (int [] setPosition)
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
		ArrayList <Integer> queenSide = new ArrayList <Integer> ();
		ArrayList <Integer> kingSide = new ArrayList <Integer> ();
		if (color == 'W')
		{
			if (timesMoved == 0 && board [0][0].getTimesMoved() == 0 && board [1][0].getColor() == 'G' && board [2][0].getColor() == 'G' && board [3][0].getColor() == 'G')
			{
				queenSide.add(2);
				queenSide.add(0);
				moves.add(queenSide);
			}
			if (timesMoved == 0 && board [7][0].getTimesMoved() == 0 && board [5][0].getColor() == 'G' && board [6][0].getColor() == 'G')
			{
				kingSide.add(6);
				kingSide.add(0);
				moves.add(kingSide);
			}
		}
		else
		{
			if (timesMoved == 0 && board [0][7].getTimesMoved() == 0 && board [1][7].getColor() == 'G' && board [2][7].getColor() == 'G' && board [3][7].getColor() == 'G')
			{
				queenSide.add(2);
				queenSide.add(7);
				moves.add(queenSide);
			}
			if (timesMoved == 0 && board [7][7].getTimesMoved() == 0 && board [5][7].getColor() == 'G' && board [6][7].getColor() == 'G')
			{
				kingSide.add(6);
				kingSide.add(7);
				moves.add(kingSide);
			}
		}
		if (this.position[1] != 7)
		{
			if (board[this.position[0]][this.position[1] + 1].getColor()!= this.color)
			{
				move.add(this.position[0]);
				move.add(this.position[1] + 1);
				moves.add(move);
			}
			if (this.position[0] != 7)
			{
				if (board[this.position[0] + 1][this.position[1] + 1].getColor()!= this.color)
				{
					move2.add(this.position[0] + 1);
					move2.add(this.position[1] + 1);
					moves.add(move2);
				}
			}
			if (this.position[0] != 0)
			{
				if (board[this.position[0] - 1][this.position[1] + 1].getColor()!= this.color)
				{
					move3.add(this.position[0] - 1);
					move3.add(this.position[1] + 1);
					moves.add(move3);
				}
			}
		}

		if (this.position[1] != 0)
		{
			if (board[this.position[0]][this.position[1] - 1].getColor()!= this.color)
			{
				move4.add(this.position[0]);
				move4.add(this.position[1] - 1);
				moves.add(move4);
			}
			if (this.position[0] != 7)
			{
				if (board[this.position[0] + 1][this.position[1] - 1].getColor()!= this.color)
				{
					move5.add(this.position[0] + 1);
					move5.add(this.position[1] - 1);
					moves.add(move5);
				}
			}
			if (this.position[0] != 0)
			{
				if (board[this.position[0] - 1][this.position[1] - 1].getColor()!= this.color)
				{
					move6.add(this.position[0] - 1);
					move6.add(this.position[1] - 1);
					moves.add(move6);
				}
			}
		}

		if (this.position [0] != 7)
		{
			if (board[this.position[0] + 1][this.position[1]].getColor()!= this.color)
			{
				move7.add(this.position[0] + 1);
				move7.add(this.position[1]);
				moves.add(move7);
			}
		}

		if (this.position [0] != 0)
		{
			if (board[this.position[0] - 1][this.position[1]].getColor()!= this.color)
			{
				move8.add(this.position[0] - 1);
				move8.add(this.position[1]);
				moves.add(move8);
			}
		}
		return moves;
	}
}
//pos [0] is hoz.
