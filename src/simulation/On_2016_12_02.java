package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class On_2016_12_02 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(buf.readLine());
		buf.close();
		if (money <= 3500) {
			System.out.print(money);
			return;
		} else if (money <= 5000) {
			System.out.print((int)((money + 3500 * 0.03) / 0.97));
			return;
		}
		int tmp = money;
		int[] tax = {45, 300, 900, 6500, 6000, 8750};
		int[] sum = {3500, 4500, 9000, 35000, 55000, 80000};
		double[] rate = {0.03, 0.1, 0.2, 0.25, 0.3, 0.35, 0.45};
		int i = 0;
		while (i < sum.length && tmp > sum[i]) {
			tmp += tax[i];
			i++;
		}
		i--;
		tmp -= tax[i];
		System.out.print((int)(
				(tmp - (sum[i - 1] + 3500) * rate[i]) / (1 - rate[i])
				));
	}
}
