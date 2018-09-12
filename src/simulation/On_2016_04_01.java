package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class On_2016_04_01 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(buf.readLine());
		String[] arr = buf.readLine().split(" ");
		int[] num = new int[length];
		int sum = 0;
		for (int i = 0; i < length; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		for (int i = 1; i < length - 1; i++) {
			if ((num[i] > num[i - 1] && num[i] > num[i + 1]) || (num[i] < num[i - 1] && num[i] < num[i + 1])) {
				sum++;
			}
		}
		buf.close();
		System.out.print(sum);
	}
}
