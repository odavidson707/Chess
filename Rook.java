//package chess;

import java.util.ArrayList;


public class Rook extends Piece {
    /*public void increment()
    {
    }*/
    public Rook (char setRank, char setColor, int [] setPosition)
    {
        rank = 'R';
        color = setColor;
        position = setPosition;
    }
    public ArrayList <ArrayList<Integer>> legalMoves(Piece [][] board)
    {
        boolean pathBreak1 = false;
        boolean pathBreak2 = false;
        boolean pathBreak3 = false;
        boolean pathBreak4 = false;
        ArrayList <ArrayList<Integer>> moves = new ArrayList <ArrayList<Integer>>();
        ArrayList <Integer> temp = new ArrayList <Integer>();
        int [] potentialMove = new int [2];
        potentialMove [0] = position [0];
        potentialMove [1] = position [1];

        while (!pathBreak1)//check to the left
        {
            potentialMove [0]--;
            if (potentialMove [0] < 0)
            {
                pathBreak1 = true;
            }
            else if ( board [potentialMove [0]] [potentialMove [1]].getColor() == this.getColor())
                pathBreak1 = true;
            else if (board [potentialMove [0]] [potentialMove [1]].getColor() != 'G')
            {
                temp.add(potentialMove[0]);
                temp.add(potentialMove[1]);
                moves.add(temp);
                temp = new ArrayList <Integer>();
                pathBreak1 = true;
            }
            else
            {
                temp.add(potentialMove[0]);
                temp.add(potentialMove[1]);
                moves.add(temp);
                temp = new ArrayList <Integer>();
            }
        }
        potentialMove [0] = position [0];
        potentialMove [1] = position [1];
        while (!pathBreak2)//check to the right
        {
            potentialMove [0]++;
            if (potentialMove [0] > 7)
            {
                pathBreak2 = true;
            }
            else if (board [potentialMove [0]] [potentialMove [1]].getColor() == this.getColor())
                pathBreak2 = true;
            else if (board [potentialMove [0]] [potentialMove [1]].getColor() != 'G')
            {
                temp.add(potentialMove[0]);
                temp.add(potentialMove[1]);
                moves.add(temp);
                temp = new ArrayList <Integer>();
                pathBreak2 = true;
            }
            else
            {
                temp.add(potentialMove[0]);
                temp.add(potentialMove[1]);
                moves.add(temp);
                temp = new ArrayList <Integer>();
            }
        }
        potentialMove [0] = position [0];
        potentialMove [1] = position [1];
        while (!pathBreak3)//check down
        {
            potentialMove [1]--;
            if (potentialMove [1] < 0)
            {
                pathBreak3 = true;
            }
            else if ( board [potentialMove [0]] [potentialMove [1]].getColor() == this.getColor())
            {
                pathBreak3 = true;
            }
            else if (board [potentialMove [0]] [potentialMove [1]].getColor() != 'G')
            {
                temp.add(potentialMove[0]);
                temp.add(potentialMove[1]);
                moves.add(temp);
                temp = new ArrayList <Integer>();
                pathBreak3 = true;
            }
            else
            {
                temp.add(potentialMove[0]);
                temp.add(potentialMove[1]);
                moves.add(temp);
                temp = new ArrayList <Integer>();
            }
        }
        potentialMove [0] = position [0];
        potentialMove [1] = position [1];
        while (!pathBreak4)//check up
        {
            potentialMove [1]++;
            if (potentialMove [1] > 7)
            {
                pathBreak4 = true;
            }
            else if (board [potentialMove [0]] [potentialMove [1]].getColor() == this.getColor())
                pathBreak4 = true;
            else if (board [potentialMove [0]] [potentialMove [1]].getColor() != 'G')
            {
                temp.add(potentialMove[0]);
                temp.add(potentialMove[1]);
                moves.add(temp);
                temp = new ArrayList <Integer>();
                pathBreak4 = true;
            }
            else
            {
                temp.add(potentialMove[0]);
                temp.add(potentialMove[1]);
                moves.add(temp);
                temp = new ArrayList <Integer>();
            }
        }
        return moves;
    }
}
//pos [0] is hoz.
