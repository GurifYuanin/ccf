package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class On_2017_12_01 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(buf.readLine());
		int[] num = new int[length];
		String[] arr = buf.readLine().split(" ");
		buf.close();
		for (int i = 0; i < length; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		
		int min = Integer.MAX_VALUE, tmp;
		for (int i = 0; i < length; i++) {
			for (int j = 1; j < length; j++) {
				if (i != j) {
					tmp = Math.abs(num[i] - num[j]);
					if (tmp < min) min = tmp;
				}
			}
		}
		System.out.print(min);
	}
}
