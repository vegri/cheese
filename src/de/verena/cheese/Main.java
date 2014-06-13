package de.verena.cheese;

import java.util.Random;

public class Main {

	public static boolean[][] generateRandomCheese(int size) {

		Random rnd = new Random();

		rnd.nextBoolean();

		boolean[][] cheese = new boolean[size][size];

		for (int row = 0; row != size; row++) {
			for (int column = 0; column != size; column++) {
				cheese[row][column] = rnd.nextBoolean();
			}
		}
		return cheese;
	}

	public static void printCheese(boolean[][] cheese) {
		for (int row = 0; row != cheese.length; row++) {
			for (int column = 0; column != cheese[row].length; column++) {
				if (cheese[column][row]) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}

			}
			System.out.println();
		}

	}

	/**
	 * 
	 * @param row
	 * @param column
	 * @param cheese
	 * @return <true>
	 */
	public static boolean checkNeighbourHoles(int row, int column,
			boolean[][] cheese) {
		
		if (row == cheese.length-1) {
			// we've reached bottom-> the cheese leaks
			System.out.println("reached hole at column "+column+1);
			return true;
		}
		// fill current hole to avoid running in circles
		cheese[column][row] = true;

		if (column > 0 && !cheese[column - 1][row]) { // west
			if (checkNeighbourHoles(row, column - 1, cheese)) {
				return true;
			}
		}
		if (column < cheese.length - 1 && !cheese[column + 1][row]) { // east
			if (checkNeighbourHoles(row, column + 1, cheese)) {
				return true;
			}
		}
		if (row > 0 && !cheese[column][row - 1]) { // north
			if (checkNeighbourHoles(row - 1, column, cheese)) {
				return true;
			}
		}
		if (row < cheese.length - 1 && !cheese[column][row + 1]) { // south
			if (checkNeighbourHoles(row + 1, column, cheese)) {
				return true;
			}
		}
		return false;
	}
	
	public static int bla(int i){
		if(i==3){
			return 5;
		}
		
		if(i==4){
			System.out.println();
		}
		
		if(i==7){
			return 5;
		}
		
		return 6;
	}

	public static void findWaysThroughHoles(boolean[][] cheese) {

		for (int column = 0; column != cheese[0].length; column++) {
			if (!cheese[column][0]) {
				if(				checkNeighbourHoles(0, column, cheese)){
					System.out.println("found hole at column "+column+" reaching bottom");
				}
			}
		}
	}

	public static void main(String[] args) {

		boolean[][] cheese = generateRandomCheese(3);
		printCheese(cheese);
		findWaysThroughHoles(cheese);
		System.out.println("####################");
		printCheese(cheese);
	}

}
