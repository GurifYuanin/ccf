package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class On_2018_03_02 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int number = Integer.parseInt(arr[0]);
		int length = Integer.parseInt(arr[1]);
		int second = Integer.parseInt(arr[2]);
		LinkedList[] list = new LinkedList[length + 1];
		for (int i = 0; i <= length; i++) {
			list[i] = new LinkedList<Integer>();
		}
		arr = buf.readLine().split(" ");
		Sphere[] s = new Sphere[number];
		for (int i = 0; i < number; i++) {
			s[i] = new Sphere(i, Integer.parseInt(arr[i]), false);
			list[Integer.parseInt(arr[i])].add(i);
		}
		buf.close();
		

		do {
			for (int i = 0; i < number; i++) {
				int p = s[i].position;
				for (int j = 0; j < list[p].size(); j++) {
					if ((int)list[p].get(j) == i) {
						list[p].remove(j);
						break;
					}
				}
				if (p == length) s[i].isLeft = true;
				if (p == 0) s[i].isLeft = false;
				p = s[i].position = s[i].isLeft ? p - 1 : p + 1;
				list[p].add(i);
			}
			for (int i = 0; i <= length; i++) {
				if (list[i].size() == 2) {
					Sphere tmp = s[(int) list[i].getFirst()];
					tmp.isLeft = !tmp.isLeft;
					tmp = s[(int) list[i].getLast()];
					tmp.isLeft = !tmp.isLeft;
				}
			}
			second--;
		} while (second != 0);
		if (s.length > 0) {
			System.out.print(s[0].position);
		}
		for (int i = 1; i < s.length; i++) {
			System.out.print(" " + s[i].position);
		}
	}
}
class Sphere {
	int id, position;
	boolean isLeft;
	Sphere (int i, int p, boolean direction) {
		this.id = i;
		this.position = p;
		this.isLeft = direction;
	}
}