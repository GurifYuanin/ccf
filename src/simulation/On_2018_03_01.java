package simulation;

import java.util.Scanner;

public class On_2018_03_01 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int sum = 0, last = 1, current;
		while ((current = sca.nextInt()) != 0) {
			if (current == 2) {
				last += 2 - last % 2;
			} else {
				last = 1;
			}
			sum += last;
		}
		sca.close();
		
		System.out.print(sum);
	}
}
