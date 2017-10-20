package chess;

import java.util.Scanner;
import java.lang.*;
import java.util.ArrayList;




public class ChessGame {
	public Piece [][] board = new Piece [8][8];
	private Piece [] white = new Piece [16];
	private Piece [] black = new Piece [16];
	private Scanner input = new Scanner (System.in);
	private char toPlay = 'W';
	private boolean CPU = false;
	//private int movesMade = 2;

	public ChessGame ()
	{
		int [] boardFiller = {0,0};
		for (int i = 0; i <8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				boardFiller = new int [] {i,j};
				board [i][j] = new Pawn(boardFiller);
			}
		}
		boolean end = false;

		int [] WK = {4,0};
		int [][] WP = new int [8][2];
		int [] WB = {2,0};
		int [] WB2 = {5,0};
		int [] WR = {0,0};
		int [] WR2 = {7,0};
		int [] WN = {1,0};
		int [] WN2 = {6,0};
		int [] WQ = {3,0};
		for (int j = 0; j <8; j++)
		{
			WP[j][0] = j;
			WP[j][1] = 1;
		}

		int [] pawns = {0,0};

		white[0] = new King ('K', 'W', WK);
		for (int i = 1; i <= 8; i++)
		{
			white [i] = new Pawn ('P', 'W', WP[i-1]);
		}
		white [9] = new Queen ('Q', 'W', WQ);
		white [10] = new Bishop('B', 'W', WB);
		white [11] = new Bishop ('B', 'W',WB2);
		white [12] = new Rook ('R', 'W', WR);
		white [13] = new Rook ('R', 'W', WR2);
		white [14] = new Knight ('N','W', WN);
		white [15] = new Knight ('N','W', WN2);

		int [] BK = {4,7};
		int [] testBK = {7,7};
		int [][] BP = new int [8][2];
		int [] BQ = {3,7};
		int [] BB = {2,7};
		int [] BB2 = {5,7};
		int [] BR = {0,7};
		int [] BR2 = {7,7};
		int [] BN = {1,7};
		int [] BN2 = {6,7};
		for (int j = 0; j <8; j++)
		{
			BP[j][0] = j;
			BP[j][1] = 6;
		}

		black [0] = new King ('K', 'B', BK);
		for (int i = 1; i <= 8; i++)
		{
			black [i] = new Pawn ('P', 'B', BP[i-1]);
		}
		black [9] = new Queen ('Q', 'B', BQ);
		black [10] = new Bishop('B', 'B', BB);
		black [11] = new Bishop ('B', 'B',BB2);
		black [12] = new Rook ('R', 'B', BR);
		black [13] = new Rook ('R', 'B', BR2);
		black [14] = new Knight ('N','B', BN);
		black [15] = new Knight ('N','B', BN2);

		for (Piece p: white)
		{
			if (p.getRank() == 'P')
			{
				board [p.getPosition()[0]][p.getPosition()[1]] = new Pawn ('P','W', p.getPosition());
			}
			if (p.getRank() == 'N')
				board [p.getPosition()[0]][p.getPosition()[1]] = new Knight ('N','W', p.getPosition());
			if (p.getRank() == 'R')
				board [p.getPosition()[0]][p.getPosition()[1]] = new Rook ('R','W', p.getPosition());
			if (p.getRank() == 'B')
				board [p.getPosition()[0]][p.getPosition()[1]] = new Bishop ('B','W', p.getPosition());
			if (p.getRank() == 'K')
				board [p.getPosition()[0]][p.getPosition()[1]] = new King ('K','W', p.getPosition());
			if (p.getRank() == 'Q')
				board [p.getPosition()[0]][p.getPosition()[1]] = new Queen ('Q','W', p.getPosition());
		}

		for (Piece p: black)
		{
			if (p.getRank() == 'P')
				board [p.getPosition()[0]][p.getPosition()[1]] = new Pawn ('P','B', p.getPosition());
			if (p.getRank() == 'N')
				board [p.getPosition()[0]][p.getPosition()[1]] = new Knight ('N','B', p.getPosition());
			if (p.getRank() == 'R')
				board [p.getPosition()[0]][p.getPosition()[1]] = new Rook ('R','B', p.getPosition());
			if (p.getRank() == 'B')
				board [p.getPosition()[0]][p.getPosition()[1]] = new Bishop ('B','B', p.getPosition());
			if (p.getRank() == 'K')
				board [p.getPosition()[0]][p.getPosition()[1]] = new King ('K','B', p.getPosition());
			if (p.getRank() == 'Q')
				board [p.getPosition()[0]][p.getPosition()[1]] = new Queen ('Q','B', p.getPosition());
		}


		boolean repeat = false;
		System.out.println("Welcome to chess.");
		System.out.println("If you would like to play against the AI, please enter '1'.  Otherwise, enter '0'");
		int choice = input.nextInt();
		do
		{
			repeat = false;
			if (choice == 1)
			{
				CPU = true;
				System.out.println("The AI does not work.  You can give it a shot, but it just deletes all the white pieces for some reason.");
				System.out.println("If you want to take a look at the code that should drive the AI, see methods 'hypothesize' and 'assessBoard'");
				System.out.println("Otherwise, feel free to play a game of chess against yourself.  That bit works.");
				System.out.println("What follows is the faulty AI.  To play against yourself, press Q and then restart.\n");
			}
			else if (choice != 0)
			{
				repeat = true;
				System.out.println("Please enter a valid choice.");
			}
		}while (repeat == true);
		while (end == false)
		{
			if(stalemate())
			{
				end = true;
				outBoard();
				if (check())
				{
					System.out.println("Checkmate!  You lose!  Good day, sir!");
				}
				else
					System.out.println("Stalemate!  The game is a draw.");
			}

			else
			{
			outToPlay();
			outBoard();
			if (CPU)
			{
				if (toPlay == 'W')
				{
					System.out.println ("Enter the coordinates of the piece you want to move.");
					ArrayList<Integer> startPos = new ArrayList<Integer>();
					ArrayList<Integer> endPos = new ArrayList<Integer>();
					boolean legal = false;
					do
					{
					    String coord = inCoordinates();
					    if (coord.equals("Q"))
                        {

                            end = true;
                            System.out.println("Thank you for playing my game.  Have a nice day!");
                            break;
                        }
                        else
                            startPos = coordinateConverter(coord);
						if (checkColor(startPos))
						{
							System.out.println ("Enter the coordinates of the square you wish to move to.");
							coord = inCoordinates();
							if (coord.equals("Q"))
                            {

                                end = true;
                                System.out.println("Thank you for playing my game.  Have a nice day!");
                                break;
                            }
                            else
                                endPos = coordinateConverter(coord);
							if (legalMove(startPos,endPos))
							{
								legal = true;
								Piece start = executeMove (startPos, endPos);
								//this is done to save the Piece in the target square
								//in case the move is illegal.
								if (check())
								{
									System.out.println("That move places your king at risk.  Pick another piece to move.");
									undo (startPos, endPos, start);
								}
								else
								{
									endMove();
									if (check())
									{
										System.out.println("Looks like you're in check.");
									}
								}
								//endMove();
							}
							else
							{
								System.out.println("Illegal move.  Please choose a piece to move again.  Please note that castling is technically a king move, and cannot be done by moving a rook.");
								//outBoard();
							}
						}
						else
						{
							System.out.println("Select a square occupied by your color.");
						}
					}while (!legal);

					}
				else //it is the CPU's turn
				{
					ArrayList <ArrayList <Integer>> move = hypothesize (board);
					executeMove(move.get(0),move.get(1));
					endMove();
				}
				}
			else//they don't want CPU
			{
					System.out.println ("Enter the coordinates of the piece you want to move.");
					ArrayList<Integer> startPos = new ArrayList<Integer>();
					ArrayList<Integer> endPos = new ArrayList<Integer>();
					boolean legal = false;
					do
					{
					    String coord1 = inCoordinates();
					    if (coord1.equals("Q"))
                        {

                            end = true;
                            System.out.println("Thank you for playing my game.  Have a nice day!");
                            break;
                        }
                        else
                            startPos = coordinateConverter(coord1);
						if (checkColor(startPos))
						{
							System.out.println ("Enter the coordinates of the square you wish to move to.");
							coord1 = inCoordinates();
                            if (coord1.equals("Q"))
                            {

                                end = true;
                                System.out.println("Thank you for playing my game.  Have a nice day!");
                                break;
                            }
                            else
                                endPos = coordinateConverter(coord1);
							if (legalMove(startPos,endPos))
							{
								legal = true;
								Piece start = executeMove (startPos, endPos);
								//this is done to save the Piece in the target square
								//in case the move is illegal.
								if (check())
								{
									System.out.println("That move places your king at risk.  Pick another piece to move.");
									undo (startPos, endPos, start);
								}
								else
								{
									endMove();
									if (check())
									{
										System.out.println("Looks like you're in check.");
									}
								}
								//endMove();
							}
							else
							{
								System.out.println("Illegal move.  Please choose a piece to move again.  Please note that castling is technically a king move, and cannot be done by moving a rook.");
								//outBoard();
							}
						}
						else
						{
							System.out.println("Select a square occupied by your color.");
						}
					}while (!legal);
			}

		}
	}
	}

	/*
	 * assessBoard evaluates the board position for the CPU, black, and returns an integer.
	 * The higher the integer, the more favorable the board position.
	 * assessBoard currently subtracts the number of points controlled by black from those of white.
	 */
	private int assessBoard()
	{
			int rtn = 0;
			for (Piece [] i :board)
			{
				for (Piece j : i)
				{
					if (j.getColor() == 'B')
					{
						switch (j.getRank())
						{
						case 'S':
							break;
						case 'P':
						{
							rtn ++;
						}
							break;
						case 'N':
						{
							rtn = rtn + 3;
						}
						break;
						case 'B':
							rtn = rtn + 3;
							break;
						case 'R':
							rtn = rtn + 5;
						break;
						case 'Q':
							rtn = rtn + 9;
						break;
						}
					}
					else
					{
						switch (j.getRank())
						{
						case 'S':
							break;
						case 'P':
						{
							rtn --;
						}
							break;
						case 'N':
						{
							rtn = rtn - 3;
						}
						break;
						case 'B':
							rtn = rtn - 3;
							break;
						case 'R':
							rtn = rtn - 5;
						break;
						case 'Q':
							rtn = rtn - 9;
						break;
						}
					}
				}
			}
		return rtn;
	}

	private boolean check ()
	{
		ArrayList <Integer> kingPos = new ArrayList <Integer>();
		if (toPlay == 'W')
		{

			for (Piece[] i: board)
			{
				for (Piece j: i)
				{
					if (j.getRank()== 'K' && j.getColor() == 'W')
					{
						kingPos.add(j.getPosition()[0]);
						kingPos.add(j.getPosition()[1]);
					}
				}
			}
			for (Piece[] i: board)
			{
				for (Piece j: i)
				{
					if (j.getColor()== 'B')
						if(j.legalMoves(board).contains(kingPos))
							return true;
				}
			}
		}
		else
		{
			for (Piece[] i: board)
			{
				for (Piece j: i)
				{
					if (j.getRank()== 'K' && j.getColor() == 'B')
					{
						kingPos.add(j.getPosition()[0]);
						kingPos.add(j.getPosition()[1]);
					}
				}
			}
			for (Piece[] i: board)
			{
				for (Piece j: i)
				{
					if (j.getColor()== 'W')
						if (j.legalMoves(board).contains(kingPos))
							return true;
				}
			}
		}
		return false;
	}

	private boolean checkColor (ArrayList <Integer> coord)
	{//return true if piece is same color as toPlay
		return board [coord.get(0)][coord.get(1)].getColor() == toPlay;
	}

	private ArrayList <Integer> coordinateConverter (String chessNotation)
	{
		ArrayList <Integer> rtn = new ArrayList <Integer>();
		if (chessNotation.length() >= 2)
		{
            rtn.add((int) chessNotation.charAt(0) - 97);
            rtn.add((int) chessNotation.charAt(1) - 49);
		}
		else
        {
            rtn.add(0);
            rtn.add(0);
        }
		return rtn;
	}

	public void endMove ()
	{
		String replacement = "";
		boolean typo = false;
		if (toPlay == 'W')
		{

			toPlay = 'B';
		}
		else
		{
			toPlay = 'W';
		}
		for (int i = 0; i < 8; i++)
		{
			if (board[i][2].getRank() == 'S')
			{
			//	System.out.println ("Endmove should be incrementing the SP");
				board[i][2].increment(board);
			}
		}

		for (int j = 0; j < 8; j++)
		{
			if (board [j][5].getRank() == 'S')
			{
		//		System.out.println ("Endmove should be incrementing the SP");
				board[j][5].increment(board);
			}
		}

		for (int q = 0; q < 8; q++)
		{
			if (board[q][7].getRank() == 'P')
			{
			//	System.out.println ("Endmove should be incrementing the SP");
				do
				{
				typo  = false;
				System.out.println("Select the piece you which to replace your pawn with: Q, B, R, N (Knight)");
				replacement = input.next();
				switch (replacement)
				{
				case "Q":
				{
					board [q][7] = new Queen ('Q', 'W', board[q][7].getPosition());
				}
				break;
				case "B":
				{
					board [q][7] = new Bishop ('B', 'W', board[q][7].getPosition());
				}
				break;
				case "R":
				{
					board [q][7] = new Rook ('R', 'W', board[q][7].getPosition());
				}
				break;
				case "N":
				{
					board [q][7] = new Knight ('N', 'W', board[q][7].getPosition());
				}
				break;
				default:
				{
					System.out.println("Enter a valid piece.");
					typo = true;
				}
				break;
				}
				}while (typo);
			}
			if (board[q][0].getRank() == 'P')
			{
			//	System.out.println ("Endmove should be incrementing the SP");
				do
				{
				typo = false;
				System.out.println("Select the piece you which to replace your pawn with: Q, B, R, N (Knight)");
				replacement = input.next();
				switch (replacement)
				{
				case "Q":
				{
					board [q][7] = new Queen ('Q', 'B', board[q][7].getPosition());
				}
				break;
				case "B":
				{
					board [q][7] = new Bishop ('B', 'B', board[q][7].getPosition());
				}
				break;
				case "R":
				{
					board [q][7] = new Rook ('R', 'B', board[q][7].getPosition());
				}
				break;
				case "N":
				{
					board [q][7] = new Knight ('N', 'B', board[q][7].getPosition());
				}
				break;
				default:
				{
					System.out.println("Enter a valid piece.");
					typo = true;
				}
				break;
				}
				}while (typo);

			}
			if (check() && stalemate())
			{
				System.out.println("Checkmate! You lose! Good day, sir!");
			}
		}
	}

	private Piece executeMove (ArrayList<Integer> pos, ArrayList<Integer> target)
	{
			Piece rtn = board[target.get(0)][target.get(1)];

			int [] toPos = {target.get(0), target.get(1)};
			int [] fromPos = {pos.get(0), pos.get(1)};
			int [] shadowPos = {target.get(0), (target.get(1) + pos.get(1))/2};
			int [] pawnPos = {target.get(0),target.get(1)};
			//check for castling
			if (board [pos.get(0)][pos.get(1)].getRank() == 'K' && (pos.get(0) - target.get(0) == 2 || pos.get(0) - target.get(0) == -2))
			{//if kingside
				if (pos.get(0) - target.get(0) == -2)
				{
					board[target.get(0)][target.get(1)] = board[pos.get(0)][pos.get(1)];
					board[target.get(0)][target.get(1)].setPosition(toPos);
					board[pos.get(0)][pos.get(1)] = new Pawn (fromPos);
					board [target.get(0) - 1][target.get(1)] = board [7][target.get(1)];
					toPos [0] --;
					board [target.get(0) -1][target.get(1)].setPosition(toPos);
					toPos [0] = toPos[0] +2;
					board [7][target.get(1)] = new Pawn (toPos);
				}
				//if queenside
				if (pos.get(0) - target.get(0) == 2)
				{
					board[target.get(0)][target.get(1)] = board[pos.get(0)][pos.get(1)];
					board[target.get(0)][target.get(1)].setPosition(toPos);
					board[pos.get(0)][pos.get(1)] = new Pawn (fromPos);
					board [target.get(0) +1][target.get(1)] = board [0][target.get(1)];
					toPos [0] ++;
					board [target.get(0) +1][target.get(1)].setPosition(toPos);
					toPos [0] = toPos[0] -3;
					board [7][target.get(1)] = new Pawn (toPos);
				}
			}
			else
			{
				if (board [pos.get(0)][pos.get(1)].getRank() == 'P')//this captures the pawn associated with the shadowpawn.
				{
					if (board[target.get(0)][target.get(1)].getRank() == 'S')
					{
						if (board[target.get(0)][target.get(1)].getColor() == 'W')
						{
							//System.out.println("The piece being replaced is at " + board[target.get(0)][3].getPosition()[1] + "," + board[target.get(0)][3].getPosition()[1]);
							pawnPos[1]--;
							//System.out.println("Pawnpos is " + pawnPos[0] + "," + pawnPos [1]);
							board[target.get(0)][3] = new Pawn (pawnPos);
						}
						else
						{
						//	System.out.println("The piece being replaced is at " + board[target.get(0)][3].getPosition()[1] + "," + board[target.get(0)][3].getPosition()[1]);
							pawnPos[1]++;
					//		System.out.println("Pawnpos is " + pawnPos[0] + "," + pawnPos [1]);
							board[target.get(0)][4] = new Pawn (pawnPos);
						}
					}
				}
				board[target.get(0)][target.get(1)] = board[pos.get(0)][pos.get(1)];
				board[target.get(0)][target.get(1)].setPosition(toPos);
				//System.out.println("The target row is " +board[target.get(0)][target.get(1)].getPosition()[1] +" the original row is " + rtn.getPosition()[1]);
				if (board[target.get(0)][target.get(1)].getRank() == 'P' && toPos[1]-fromPos[1] == 2)
				{
				//	System.out.println("A sp is being made.");
					board [target.get(0)][target.get(1)-1] = new ShadowPawn('S', board[target.get(0)][target.get(1)].getColor(), shadowPos);
				}
				if (board[target.get(0)][target.get(1)].getRank() == 'P' && toPos[1]-fromPos[1] == -2)
				{
				//	System.out.println("A sp is being made.");
					board [target.get(0)][target.get(1)+1] = new ShadowPawn('S', board[target.get(0)][target.get(1)].getColor(), shadowPos);
				}
				board [pos.get(0)] [pos.get(1)] = new Pawn (fromPos);
				board [pos.get(0)] [pos.get(1)] = new Pawn (fromPos);
				board [target.get(0)][target.get(1)].setTimesMoved(board [target.get(0)][target.get(1)].getTimesMoved() + 1);
			}
			return rtn;
			//endMove();
	}

	/*
	 * I think this can be done better recursively, but for now I just have it look 2 moves out.
	 * */
	private ArrayList<ArrayList<Integer>> hypothesize(Piece [][] board)//returns a set of coordinates pos and target which represent a move to be taken by CPU
	{
		ArrayList<ArrayList <Integer>> move = new ArrayList <ArrayList <Integer>>();
		int max = Integer.MIN_VALUE;
		for (Piece [] j : board)
		{
			for (Piece i : j)
			{
				if (i.getColor() == 'B')//loops through the legal moves for black
				{
					ArrayList <Integer> pos = new ArrayList <Integer>();
					pos.add(i.getPosition()[0]);
					pos.add(i.getPosition()[1]);
					for (ArrayList<Integer> possibleMove : i.legalMoves(board))
					{
						Piece start = executeMove (pos, possibleMove);
						outBoard();
						System.out.println();
						int temp = 0;
						for (Piece [] q : board)
						{
							for (Piece p : q)
							{
								if (p.getColor () == 'W')//loops through white pieces after hypothesizing black's move, then assesses board.
								{
									for (ArrayList<Integer> potentialMove : p.legalMoves(board))
									{
										ArrayList <Integer> pos2 = new ArrayList <Integer>();
										pos2.add(p.getPosition()[0]);
										pos2.add(p.getPosition()[1]);
										Piece start2 = executeMove (pos2, potentialMove);
										temp += assessBoard();
										undo (pos, potentialMove, start2);
									}
								}
							}
						}
						if (temp > max)
						{
							System.out.println("Should be choosing an optimal move.");
							max = temp;
							if (!move.isEmpty())
							{
								move.remove(0);
								move.remove(0);
							}
							move.add(pos);
							move.add(possibleMove);
						}
						undo(pos, possibleMove, start);
					}
				}
			}
		}
		return move;
	}

	private String inCoordinates ()
	{
		boolean typo = false;
		String rtn = "";
		do
		{
		rtn = input.next();
		if ((rtn.length() == 1 && (int)rtn.charAt(0) != 81) || rtn.length() > 2)//The input string is of improper size
        {
            System.out.println("Please enter coordinates in the format 'a1'.");
            typo = true;
        }
        else if (rtn.equals("Q")) //the input string is Q
        {
            typo = false;
        }
		else if ((((int)rtn.charAt(0) <97 || (int)rtn.charAt(0) > 104)) || (int)rtn.charAt(1) > 56 || (int)rtn.charAt(1) < 49)
		{
			System.out.println("Please enter coordinates in the format 'a1'.");
			typo = true;
		}
		else
			typo = false;
		}while (typo == true);
		return rtn;
	}

	private boolean legalMove (ArrayList<Integer> pos, ArrayList<Integer> target) //determine if selected move is legal.
	{
		/*System.out.println("There is a " + board [pos.get(0)][pos.get(1)].getClass() + "In the starting position.");
		System.out.println("There is a " + board [target.get(0)][target.get(1)].getClass() + "In the ending position.  It is of color" + board [target.get(0)][target.get(1)].getColor());
		*/ArrayList<ArrayList<Integer>> moves = new ArrayList<ArrayList<Integer>>();
		moves = board [pos.get(0)] [pos.get(1)].legalMoves(board);
		return (moves.contains (target));
	}

	public void outBoard ()
	{
		char rank;
		for (int j = 7; j>-1; j--)
		{
			for (int i = 0; i <8; i++)
			{
				rank = board [i][j].getRank();
				if (board [i][j].getColor() == 'B')
					rank = Character.toLowerCase(rank);
				if (rank != 'S' && rank != 's')
					System.out.print (rank);
			}
			System.out.println();
		}
		/*for (int j = 7; j>-1; j--)
		{
			for (int i = 0; i <8; i++)
			{
				System.out.print (board [i][j].getClass() + "   " + board[i][j].getPosition()[0] + "," + board[i][j].getPosition()[1]);
			}
			System.out.println();
		}*/

	}


	private void outToPlay ()
	{
		if (toPlay == 'W')
			System.out.print ("White");
		else
			System.out.print ("Black");
		System.out.println ( " to play. White pieces are capital letters. Press Q to quit");
	}

	private boolean stalemate ()
	{
		ArrayList <Integer> startPos = new ArrayList <Integer> ();
		int [] coords = {0,0};
		Piece temp = new Pawn (coords);
		for (Piece[] i: board)
		{
			for (Piece j: i)
			{
				ArrayList<ArrayList<Integer>> moves = j.legalMoves(board);
				if (j.getColor()== toPlay && (!moves.isEmpty()))
				{
					for (ArrayList<Integer> move: moves)
					{
						startPos.add(j.getPosition()[0]);
						startPos.add(j.getPosition()[1]);
						temp = executeMove (startPos, move);
						if (!check())
						{
							//System.out.println("Here's the board after check.  If it's unchanged, the problem is with undo:");
							//outBoard();
						//	System.out.println("Here is the first piece that has a legal, noncheck move.");
							this.undo(startPos, move, temp);
							return false;
						}
					//	System.out.println("This legal move would put to play in check.");
						this.undo(startPos, move, temp);
					}
				}
			}
		}
		return true;
	}

	private void undo (ArrayList<Integer> pos, ArrayList<Integer> target, Piece start)
	{

		int [] originalPos = board [pos.get(0)][pos.get(1)].getPosition();
		int [] pawnPos = board [target.get(0)][target.get(1)].getPosition();//pawn pos is used for replacing pawns when ShadowPawns are used.

		board [pos.get(0)][pos.get(1)] = board [target.get(0)][target.get(1)];
		board [pos.get(0)][pos.get(1)].setPosition(originalPos);

		if (board [target.get(0)][target.get(1)].getRank() == 'P')//this gets rid of the shadowpawn made when the pawn is moved.
		{
			if (board [target.get(0)][target.get(1)].getColor() == 'W' )
			{
				if (target.get(1) == 3 && board[target.get(0)][2].getRank() == 'S')
				{
					board[target.get(0)][2].increment(board);
					board[target.get(0)][2].increment(board);
				}
			}
			else if (target.get(1) == 4 && board [target.get(0)][5].getRank() == 'S')
			{
				board [target.get(0)][5].increment(board);
				board [target.get(0)][5].increment(board);
			}
		}
		board [target.get(0)][target.get(1)] = start;
		if (start.getRank() == 'S')//this is restoring the pawn that is taken when shadowPawn is taken
		{
			if (start.getColor() == 'W')
			{
				pawnPos[1]++;
				board [target.get(0)][target.get(1)+1] = new Pawn ('P', 'W', pawnPos);
			}
			else
			{
				pawnPos [1]--;
				board [target.get(0)][target.get(1)-1] = new Pawn ('P', 'B', pawnPos);
			}
		}
		//check for castling and undo it by moving the rook back to its original square
		if (board [target.get(0)][target.get(1)].getRank()== 'K' && (target.get(0) - pos.get(0) == 2 ||target.get(0) - pos.get(0) == -2))
		{
			//if kingside
			if (target.get(0) - pos.get(0) == 2)
			{
				int [] rookPos = {target.get(0) + 1,target.get(0)};
				board [target.get(0) + 1][target.get(0)] = new Pawn (rookPos);
				rookPos [0] = 7;
				board [7][target.get(0)] = new Rook ('R', board [target.get(0)][target.get(1)].getColor(), rookPos);
			}
			//if queenside
			if (target.get(0) - pos.get(0) == -2)
			{
				int [] rookPos = {target.get(0) - 1,target.get(0)};
				board [target.get(0) - 1][target.get(0)] = new Pawn (rookPos);
				rookPos [0] = 0;
				board [0][target.get(0)] = new Rook ('R', board [target.get(0)][target.get(1)].getColor(), rookPos);
			}
		}

		board [pos.get(0)][pos.get(1)].setTimesMoved(board [pos.get(0)][pos.get(1)].getTimesMoved() - 1);
	}
}
