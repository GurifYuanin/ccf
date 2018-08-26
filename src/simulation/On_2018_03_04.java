package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class On_2018_03_04 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(buf.readLine()); // ∆Â≈Ã ˝
		int[] chess = new int[9];
		String[] arr = null;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 3; j++) {
				arr = buf.readLine().split(" ");
				for (int k = 0; k < 3; k++) {
					chess[3 * j + k] = Integer.parseInt(arr[k]);
				}
			}
			int preRes = preCheck(chess);
			if (preRes == -1) {
				dfs(chess, 1);
			} else {
				System.out.println(preRes);
			}
		}
		buf.close();
	}
	static int preCheck (int[] chess) {
		boolean flag = true;
		int j = 0;
		for (int i = 0; i < 9; i++) {
			if (chess[i] == 0) {
				j++;
			} else {
				flag = false;
			}
		}
		if (flag) return 0;
		if (j == 2) {
			if (chess[4] != 0) {
				if (chess[1] != 0 || chess[3] != 0 || chess[5] != 0 || chess[7] != 0) {
					return chess[4] == 1 ? 3 : -3;
				}
				if (chess[0] != 0 || chess[2] != 0 || chess[4] != 0 || chess[6] != 0 || chess[8] != 0) {
					return 0;
				}
			}
		}
		return -1;
	}
	static int isWin (int[] chess) {
		if (chess[0] != 0 && chess[0] == chess[1] && chess[1] == chess[2]) return (chess[0] + chess[1] + chess[2]) / 3;
		if (chess[3] != 0 && chess[3] == chess[4] && chess[4] == chess[5]) return (chess[3] + chess[4] + chess[5]) / 3;
		if (chess[6] != 0 && chess[6] == chess[7] && chess[7] == chess[8]) return (chess[6] + chess[7] + chess[8]) / 3;
		if (chess[0] != 0 && chess[0] == chess[3] && chess[3] == chess[6]) return (chess[0] + chess[3] + chess[6]) / 3;
		if (chess[1] != 0 && chess[1] == chess[4] && chess[4] == chess[7]) return (chess[1] + chess[4] + chess[7]) / 3;
		if (chess[2] != 0 && chess[2] == chess[5] && chess[5] == chess[8]) return (chess[2] + chess[5] + chess[8]) / 3;
		if (chess[0] != 0 && chess[0] == chess[4] && chess[4] == chess[8]) return (chess[0] + chess[4] + chess[8]) / 3;
		if (chess[2] != 0 && chess[2] == chess[4] && chess[4] == chess[6]) return (chess[2] + chess[4] + chess[6]) / 3;
		return 0;
	}
	static boolean dfs (int[] chess, int next) {
		int res = isWin(chess);
		if (res != 0) {
			int j = 0;
			for (int i = 0; i < 9; i++) {
				if (chess[i] == 0) j++;
			}
			j++;
			if (res == 2) j = -j;
			System.out.println(j);
			return true;
		} else {
			for (int i = 0; i < 9; i++) {
				if (chess[i] == 0) {
					chess[i] = next;
					boolean r = dfs(chess, next == 1 ? 2 : 1);
					chess[i] = 0;
					if (r) return r;
				}
			}
			return false;
		}
	}
}
