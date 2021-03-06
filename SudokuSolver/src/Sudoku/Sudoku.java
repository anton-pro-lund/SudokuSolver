package Sudoku;

import java.util.Arrays;

public class Sudoku {
	private int[][] matrix = new int[9][9];
	
	/**
	 * Grunden till sudokut
	 */
	public Sudoku() {
		resetSudoku();
		for (int[] a : matrix) {
			Arrays.fill(a, -1);
		}
	}
	

	/**
	 * returnerar värdet i sudokut på platsen [row][col]
	 * @param row
	 * @param col
	 * @return
	 */
	public int getValuexy (int row, int col){
		return matrix[row][col];
	}
	
	/**
	 * om värdet är tillåtet ändras värdet i sudokut på platsen [row][col]
	 * @param row
	 * @param col
	 * @param val
	 * @return
	 */
	public void setValuexy (int row, int col, int val){
		//kollar 
		if(checkAll(val, col, row) && val > 0 && val < 10 && col > -1 && col < 10 && row > -1 && row < 10)
			matrix[row][col] = val;
		else
			if(val != -1);
	}
	
	/**
	 * checkar så att placeringen av värdet följer sudokus regler
	 * @param value
	 * @param col
	 * @param row
	 * @return
	 */
	public boolean checkAll(int value, int col, int row) {
		if(checkRow(value, row) && checkColumn(value, col) && checkSquare(value, col, row)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * sätter ett värde till -1
	 * @param row, raden
	 * @param col, kolumnen
	 */
	public void resetValuexy(int row, int col) {
		matrix[row][col] = -1;
	}
	
	/**
	 * skriver ut matrisen i terminalen
	 */
	public void print() {
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix.length; col++) {
				System.out.print(matrix[row][col] + " ");
				if(col == 2 || col == 5) {
					System.out.print(" | ");
				}

			}
			if(row == 2 || row == 5) {
				System.out.println("\n");
				System.out.print("------------------------------");
			}
			System.out.println("\n");
		}
	}
  
	/**
	 * kollar så att raden följer sudokus regler
	 * @param number
	 * @param row
	 * @return
	 */
	public boolean checkRow(int number, int row) {
		int occ = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[row][i] == number) {
				occ++;
				if (occ >= 2) { //om samma siffra existerar på samma rad 2 gånger så returneras false
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * kollar så att kolumnen följer sudokus regler
	 * @param number, talet som ska kollas
	 * @param col, kolumnen som ska kollas 
	 * @return
	 */
	public boolean checkColumn(int number, int col) {
		int occ = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][col] == number) {
				occ++;
				if (occ >= 2) { //om samma siffra existerar på samma kolumn 2 gånger så returneras false
					return false;
				}
			}
		}
		return true;
	}
	
	 /**
	  * Return sant om numret existerar inom en kvadrat
	  * @param number värdet som ska kollas
	  * @param col vilken kolumn
	  * @param row vilken rad
	  * @return sant om det går annars falsk
	  */
	public boolean checkSquare(int number, int col, int row) {
		int occ = 0;
		int x = row / 3;
		int y = col / 3;
		for (int i = y * 3; i < 3 * (y + 1); i++) {
			for (int j = x * 3; j < 3 * (x + 1); j++) {
				if (matrix[j][i] == number) {
					occ++;
					if (occ == 2) { //om samma siffra existerar inom rutan 2 gånger så returneras false
						return false;
					}
				}
			}
		}

		return true;
	}
	
	/**
	 * fyller sudokut med -1
	 */
	public void resetSudoku() {
		for (int[] a : matrix) {
			Arrays.fill(a, -1);
		}
	}
}
