package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class On_2016_04_02 {
	static int[][] grid, rect;
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		grid = new int[15][10];
		for (int i = 0; i < 15; i++) {
			String[] arr = buf.readLine().split(" ");
			for (int j = 0; j < 10; j++) {
				grid[i][j] = Integer.parseInt(arr[j]);
			}
		}
		rect = new int[4][4];
		for (int i = 0; i < 4; i++) {
			String[] arr = buf.readLine().split(" ");
			for (int j  = 0; j < 4; j++) {
				rect[i][j] = Integer.parseInt(arr[j]);
			}
		}
		int col  = Integer.parseInt(buf.readLine()) - 1;
		buf.close();
		
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				grid[i][col + j] += rect[i][j];
			}
		}
		int row = 0;
		do {
			del(row, col);
			row++;
			add(row, col);
		} while (!isBoom() && row < 11);
		if (row == 11) {
			int inc = 0;
			while (rect[3 - inc][0] == 0 && rect[3 - inc][1] == 0 && rect[3 - inc][2] == 0 && rect[3 - inc][3] == 0) {
				inc++;
			}
			del(row, col);
			row += inc;
			for (int i = 0; i < 4 - inc; i++) {
				for (int j = 0; j < 4; j++) {
					grid[row + i][col + j] += rect[i][j];
				}
			}
		} else {
			del(row, col);
			row--;
			add(row, col);
		}
		print();
	}
	static boolean isBoom () {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 10; j++) {
				if (grid[i][j] == 2) {
					return true;
				}
			}
		}
		return false;
	}
	static void print () {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void del (int row, int col) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				grid[row + i][col + j] -= rect[i][j];
			}
		}
	}
	static void add (int row, int col) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				grid[row + i][col + j] += rect[i][j];
			}
		}
	}
}
