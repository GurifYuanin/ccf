package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class On_2017_12_02 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		buf.close();
		
		int allNum = Integer.parseInt(arr[0]);
		int liveNum = allNum;
		int k = Integer.parseInt(arr[1]);
		int count = 1, index = 0;
		boolean[] isOut = new boolean[allNum];
		Arrays.fill(isOut, false);
		while (liveNum > 1) {
			if (!isOut[index]) {
				if (count % k == 0 || count % 10 == k) {
					isOut[index] = true;
					liveNum--;
				}
				count++;
			}
			
			index = (index + 1) % allNum;
		}
		for (int i = 0; i < allNum; i++) {
			if (!isOut[i]) {
				System.out.println(i + 1);
				break;
			}
		}
	}
}
