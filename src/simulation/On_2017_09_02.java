package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class On_2017_09_02 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int keyNum = Integer.parseInt(arr[0]);
		int teacherNum = Integer.parseInt(arr[1]);
		int[] keys = new int[keyNum + 1];
		Fetch[] list = new Fetch[teacherNum];
		for (int i = 0; i <= keyNum; i++) {
			keys[i] = i;
		}
		int timeout = 0;
		for (int i = 0; i < teacherNum; i++) {
			arr = buf.readLine().split(" ");
			int start = Integer.parseInt(arr[1]);
			int length = Integer.parseInt(arr[2]);
			if (timeout < start + length) timeout = start + length;
			list[i] = new Fetch(
					Integer.parseInt(arr[0]),
					start,
					length
					);
		}
		buf.close();
		
		Arrays.sort(list, (a, b) -> a.key - b.key);
		for (int i = 1; i <= timeout; i++) {
			for (int j = 0; j < teacherNum; j++) {
				if (list[j].end == i) {
					// ¹é»¹Ô¿³×
					for (int k = 1; k <= keyNum; k++) {
						if (keys[k] == -1) {
							keys[k] = list[j].key;
							break;
						}
					}
				}
			}
			for (int j = 0; j < teacherNum; j++) {
				if (list[j].start == i) {
					// ½èÔ¿³×
					for (int k = 1; k <= keyNum; k++) {
						if (keys[k] == list[j].key) {
							keys[k] = -1;
							break;
						}
					}
				}
			}
		}
		System.out.print(keys[1]);
		for (int i = 2; i <= keyNum; i++) {
			System.out.print(" " + keys[i]);
		}
	}
}
class Fetch {
	int key;
	int start;
	int length;
	int end;
	Fetch (int k, int s, int l) {
		this.key = k;
		this.start = s;
		this.length = l;
		this.end = this.start + this.length;
	}
}
