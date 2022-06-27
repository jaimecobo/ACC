package edu.acc.java;

import java.util.Random;
import java.util.Scanner;

/*
 * Write a BattleShip class that uses 10 arrays (y0 – y9) of 10 elements each. 
 * 
 * Hide (2) ships by generating two random starting locations (x,y) where 
 *   y is the array and x is the element in that array. 
 *   Generate another random for the ship size which can be from 1 to 10. 
 *   Do not reveal ship locations to user.
 *   
 * Game play: allow user to enter (x,y) coordinates using Scanner 
 *   class and if it “hits” a ship print “hit”, else print “miss”. 
 *   When all coordinates of ship are hit print “sunk”. 
 *   When both ships sunk say “game over, you took “ <count> “ tries 
 *   to sink ships”. 
 *   
 */

public class BattleShip implements BattleShipIF {

        boolean debug = false;  // set true to see debug info
	// 10 arrays of 10 elements compose the game board
	final int numArrays = 10;  // descibe the playing surface
	final int arrayLength = 10;
	boolean[] y0, y1, y2, y3, y4, y5, y6, y7, y8, y9; // game board arrays

	public BattleShip() {
		// set up game board
		y0 = new boolean[arrayLength];
		y1 = new boolean[arrayLength];
		y2 = new boolean[arrayLength];
		y3 = new boolean[arrayLength];
		y4 = new boolean[arrayLength];
		y5 = new boolean[arrayLength];
		y6 = new boolean[arrayLength];
		y7 = new boolean[arrayLength];
		y8 = new boolean[arrayLength];
		y9 = new boolean[arrayLength];
	}

	/* (non-Javadoc)
	 * @see edu.acc.java.BattleShipIF#positionShips(int)
	 */
	@Override
	public void positionShips(int shipCount) {
		Random rand = new Random();

		int i = 0;
		while (i < shipCount) {
			int nextShipArray = rand.nextInt(numArrays); // select the Y array 
                                                                     // for ship randomly
			if (anyShips(nextShipArray))
				continue; // ship already present in this array?
			int nextShipStart = rand.nextInt(arrayLength); // select where in Y 
                                                                       // array ship starts
			int nextShipLength = rand.nextInt(arrayLength) + 1; // select ship 
                                                                            // length 1-10
			makeShip(nextShipArray, nextShipStart, nextShipLength); // place ship
			i++;
		}
	}

	/* (non-Javadoc)
	 * @see edu.acc.java.BattleShipIF#makeShip(int, int, int)
	 */
	@Override
	public void makeShip(int whichArray, int start, int length) {
		// places one ship in specified array
		// clip the ship if too long
		//System.out.println("whichArray=" + whichArray + // scaffolding
	        //			" start=" + start + " length=" + length);
		int end = Math.min(start + length, arrayLength); // clip ship to array 
                                                                 // size if necessary

		switch (whichArray) {
		case 0: for (int i = start; i < end; i++) y0[i] = true; break;
		case 1: for (int i = start; i < end; i++) y1[i] = true; break;
		case 2: for (int i = start; i < end; i++) y2[i] = true; break;
		case 3: for (int i = start; i < end; i++) y3[i] = true; break;
		case 4: for (int i = start; i < end; i++) y4[i] = true; break;
		case 5: for (int i = start; i < end; i++) y5[i] = true; break;
		case 6: for (int i = start; i < end; i++) y6[i] = true; break;
		case 7: for (int i = start; i < end; i++) y7[i] = true; break;
		case 8: for (int i = start; i < end; i++) y8[i] = true; break;
		case 9: for (int i = start; i < end; i++) y9[i] = true; break;
		}
	}

	/* (non-Javadoc)
	 * @see edu.acc.java.BattleShipIF#isMoreFiringRequired()
	 */
	@Override
	public boolean isMoreFiringRequired() {
		for (int i = 0; i < numArrays; i++) {
			if (anyShips(i))
				return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.acc.java.BattleShipIF#anyShips(int)
	 */
	@Override
	public boolean anyShips(int whichArray) {
		switch (whichArray) {
		case 0: return scanForTrue(y0);
		case 1: return scanForTrue(y1);
		case 2: return scanForTrue(y2);
		case 3: return scanForTrue(y3);
		case 4: return scanForTrue(y4);
		case 5: return scanForTrue(y5);
		case 6: return scanForTrue(y6);
		case 7: return scanForTrue(y7);
		case 8: return scanForTrue(y8);
		case 9: return scanForTrue(y9);
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.acc.java.BattleShipIF#printGameArray(boolean[])
	 */
	@Override
	public void printGameArray(boolean[] array) {
                if (!debug) return;  // only print game board if debugging
		System.out.println();
		for (int i = 0; i < array.length; i++) {
			if (array[i]) {
				System.out.print("S");
			} else {
				System.out.print(".");
			}
		}
	}

	/* (non-Javadoc)
	 * @see edu.acc.java.BattleShipIF#printGameBoard()
	 */
	@Override
	public void printGameBoard() {
		printGameArray(y0);
		printGameArray(y1);
		printGameArray(y2);
		printGameArray(y3);
		printGameArray(y4);
		printGameArray(y5);
		printGameArray(y6);
		printGameArray(y7);
		printGameArray(y8);
		printGameArray(y9);
	}

	/* (non-Javadoc)
	 * @see edu.acc.java.BattleShipIF#scanForTrue(boolean[])
	 */
	@Override
	public boolean scanForTrue(boolean[] array) {
		for (int i = 0; i < arrayLength; i++) {
			if (array[i])
				return true;
		}
		return false;
	}

	static public void main(String[] argv) {
		// set a new instance which initializes game board
		BattleShip game = new BattleShip();
                if (argv.length > 0 && argv[0].equals("debug")) { game.debug = true; }
		// position two ships randomly
		game.positionShips(2);
		// Ask player what coordinates they want to hit a ship until all
		// ships are sunk, then print count of coordinates tried
		Scanner keyboard = new Scanner(System.in);
		int shotCount = 0;

		prompt: 
		    while (game.isMoreFiringRequired()) {  // game over when all ships sunk
			game.printGameBoard(); // scaffolding to verify play
			// get coordinate to fire at
			System.out.print("\nEnter coordinates to fire at as row,column: ");
			int row, col = 0;
			while (true) { // ask until good coordinates entered
				String[] coordinate = keyboard.next().split(",");
				if (coordinate.length != 2) {
					sayInvalidInput();
					continue prompt;
				}
				try {
					row = Integer.parseInt(coordinate[0].trim());
					col = Integer.parseInt(coordinate[1].trim());

                                        // better to have a coordinate checker method...TODO
					if (row < 1 || row > game.arrayLength) {
						sayInvalidInput();
						continue prompt;
					}
					if (col < 1 || col > game.arrayLength) {
						sayInvalidInput();
						continue prompt;
					}
					break; // good coordinate
				}

				catch (NumberFormatException ex) {
					sayInvalidInput();
					continue prompt;
				}
			}

			// valid coordinate so bump count
			shotCount++;

			boolean hit = game.fireAtCoordinate(col - 1, row - 1); // minus one for zero indexing
			if (hit) {
				System.out.print(" hit");
				if (!game.anyShips(row - 1)) {
					System.out.println(" sunk");
				}
			} else {
				System.out.print("miss");
			}

		}
		System.out.println("Game over, you took " + shotCount
				+ " tries to sink all ships");

	}

	/* (non-Javadoc)
	 * @see edu.acc.java.BattleShipIF#fireAtCoordinate(int, int)
	 */
	@Override
	public boolean fireAtCoordinate(int x, int y) {
		// fire at given coordinate (set false)
		// and return old value

		boolean oldValue = false;

		switch (y) {
		case 0: oldValue = y0[x]; y0[x] = false; 
                        break;
		case 1: oldValue = y1[x]; y1[x] = false; 
                        break;
		case 2: oldValue = y2[x]; y2[x] = false;
                        break;
		case 3: oldValue = y3[x]; y3[x] = false; 
                        break;
		case 4: oldValue = y4[x]; y4[x] = false; 
                        break;
		case 5: oldValue = y5[x]; y5[x] = false; 
                        break;
		case 6: oldValue = y6[x]; y6[x] = false; 
                        break;
		case 7: oldValue = y7[x]; y7[x] = false; 
                        break;
		case 8: oldValue = y8[x]; y8[x] = false; 
                        break;
		case 9: oldValue = y9[x]; y9[x] = false; 
                        break;
                }
		return oldValue; // was this a hit (originally true)?

	}

	public static void sayInvalidInput() {
		System.out.println("Sorry, invalid input. Try x,y where"
				+ " x and y are from 1 to 10");
	}
}