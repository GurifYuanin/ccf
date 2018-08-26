package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class On_2017_09_01 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(buf.readLine());
		buf.close();
		
		int sum = 0;
		while (money >= 50) {
			sum += 7;
			money -= 50;
		}
		while (money >= 30) {
			sum += 4;
			money -= 30;
		}
		while (money >= 10) {
			sum++;
			money -= 10;
		}
		System.out.println(sum);
	}
}
