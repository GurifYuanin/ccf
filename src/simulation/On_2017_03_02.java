package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class On_2017_03_02 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(buf.readLine());
		int[] list = new int[length];
		for (int i = 0; i < length; i++) {
			list[i] = i;
		}
		int num = Integer.parseInt(buf.readLine());
		String[] arr;
		while (num > 0) {
			arr = buf.readLine().split(" ");
			int id = Integer.parseInt(arr[0]) - 1,
				move = Integer.parseInt(arr[1]),
				i = 0;
			while (i < length && list[i] != id) i++;
			if (move > 0) {
				while (i < length - 1 && move > 0) {
					list[i] = list[i + 1];
					i++;
					move--;
				}
				list[i] = id;
			} else {
				while (i > 0 && move < 0) {
					list[i] = list[i - 1];
					i--;
					move++;
				}
				list[i] = id;
			}
			num--;
		}
		buf.close();
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + 1);
			if (i != list.length - 1)
				System.out.print(" ");
		}
	}
}
