package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class On_2016_09_02 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(buf.readLine());
		boolean[][] site = new boolean[20][5];
		String[] arr = buf.readLine().split(" ");
		buf.close();
		
		for (int i = 0; i < length; i++) {
			int buy = Integer.parseInt(arr[i]);
			boolean isFinished = false;
			for (int j = 0; j < 20; j++) {
				int start = isEmpty(site[j], buy);
				if (start != -1) {
					for (int k = start; k < start + buy; k++) {
						site[j][k] = true;
						System.out.print(j * 5 + k + 1 + " ");
					}
					System.out.println();
					isFinished = true;
					break;
				}
			}
			if (!isFinished) {
				System.out.println("false");
				for (int j = 0, k; j < 100; j++) {
					k = j;
					while (k < j + buy && !site[k / 5][k % 5]) {
						k++;
					}
					if (k == j + buy) {
						while (j < k) {
							site[j / 20][j % 5] = true;
							System.out.print(j + 1 + " ");
							j++;
						}
						System.out.println();
						break;
					}
				}
			}
		}
	}
	public static int isEmpty (boolean[] arr, int num) {
		for (int i = 0, j; i <= 5 - num; i++) {
			j = i;
			while (j < i + num && !arr[j]) {
				j++;
			}
			if (j == i + num) {
				return i;
			}
		}
		return -1;
	}
}
