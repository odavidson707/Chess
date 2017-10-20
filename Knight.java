package chess;

import java.util.ArrayList;


public class Knight extends Piece {
/*	public void increment()
	{
	}*/
	public Knight (char setRank, char setColor, int [] setPosition)
	{
		rank = 'N';
		color = setColor;
		position = setPosition;
	}
	public ArrayList <ArrayList<Integer>> legalMoves(Piece [][] board)
	{
		ArrayList <ArrayList<Integer>> moves = new ArrayList <ArrayList<Integer>>();
		ArrayList <Integer> temp = new ArrayList <Integer>();
		int [] potentialMove = new int [2];
		potentialMove [0] = position [0];
		potentialMove [1] = position [1];
		if (position[0] - 2 >= 0)//check left
		{
			if (position [1] -1 >=  0)//check left down
			{
				if (board [position[0] -2][position [1] - 1].getColor()!= color)
				{
					temp.add(position[0] - 2);
					temp.add(position[1] - 1);
					moves.add(temp);
					temp = new ArrayList <Integer>();
				}
			}
			if (position [1] + 1 <=  7)//check left up
			{
				if (board [position[0] -2][position [1] + 1].getColor()!= color)
				{
					temp.add(position[0] - 2);
					temp.add(position[1] + 1);
					moves.add(temp);
					temp = new ArrayList <Integer>();
				}
			}
		}

		if (position[0] + 2 <= 7)//check right
		{
			if (position [1] -1 >=  0)//check right down
			{
				if (board [position[0] + 2][position [1] - 1].getColor()!= color)
				{
					temp.add(position[0] + 2);
					temp.add(position[1] - 1);
					moves.add(temp);
					temp = new ArrayList <Integer>();
				}
			}
			if (position [1] + 1 <=  7)//check left up
			{
				if (board [position[0] + 2][position [1] + 1].getColor()!= color)
				{
					temp.add(position[0] + 2);
					temp.add(position[1] + 1);
					moves.add(temp);
					temp = new ArrayList <Integer>();
				}
			}
		}

		if (position[1] - 2 >= 0)//check down
		{
			if (position [0] -1 >=  0)//check down left
			{
				if (board [position[0] - 1][position [1] - 2].getColor()!= color)
				{
					temp.add(position[0] - 1);
					temp.add(position[1] - 2);
					moves.add(temp);
					temp = new ArrayList <Integer>();
				}
			}
			if (position [0] + 1 <=  7)//check down right
			{
				if (board [position[0] + 1][position [1] - 2].getColor()!= color)
				{
					temp.add(position[0] + 1);
					temp.add(position[1] - 2);
					moves.add(temp);
					temp = new ArrayList <Integer>();
				}
			}
		}

		if (position[1] + 2 <= 7)//check up
		{
			if (position [0] - 1 >=  0)//check up left
			{
				if (board [position[0] - 1][position [1] + 2].getColor()!= color)
				{
					temp.add(position[0] - 1);
					temp.add(position[1] + 2);
					moves.add(temp);
					temp = new ArrayList <Integer>();
				}
			}
			if (position [0] + 1 <=  7)//check down right
			{
				if (board [position[0] + 1][position [1] + 2].getColor()!= color)
				{
					temp.add(position[0] + 1);
					temp.add(position[1] + 2);
					moves.add(temp);
					temp = new ArrayList <Integer>();
				}
			}
		}
		return moves;
	}
}
//pos [0] is hoz.
