package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class On_2017_12_04 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		final int UNCONNECT = Integer.MAX_VALUE / 3;
		String[] arr = buf.readLine().split(" ");
		int nodeNum = Integer.parseInt(arr[0]);
		int pathNum = Integer.parseInt(arr[1]);
		int[][] path = new int[nodeNum][nodeNum]; // 节点距离
		for (int i = 0; i < nodeNum; i++) {
			Arrays.fill(path[i], UNCONNECT);
		}
		for (int i = 0; i < pathNum; i++) {
			arr = buf.readLine().split(" ");
			int type = Integer.parseInt(arr[0]);
			int start = Integer.parseInt(arr[1]) - 1;
			int end = Integer.parseInt(arr[2]) - 1;
			int cost = Integer.parseInt(arr[3]);
			path[start][end] = path[end][start] = type == 0 ? cost : -cost;
		}
		buf.close();
		
		int[] sum = new int[nodeNum]; // 从 0 到其他各点所需的疲劳值
		int[] pre = new int[nodeNum];
		int start = 0, end = nodeNum - 1;
		boolean[] isOk = new boolean[nodeNum];
		Arrays.fill(pre, -1);
		Arrays.fill(isOk, false);
		Arrays.fill(sum, UNCONNECT);
		sum[0] = 0; // 0 到 0 不需要疲劳
		isOk[0] = true;
		
		// 迪杰斯特拉
		for (int i = 0, min = UNCONNECT, index = 0; i < nodeNum; i++, min = UNCONNECT) {
			for (int j = 0; j < nodeNum; j++) {
				if (!isOk[j] && min > sum[j]) {
					min = sum[j];
					index = j;
				}
			}
			isOk[index] = true;
			for (int j = 0; j < nodeNum; j++) {
				if (!isOk[j] && path[index][j] < UNCONNECT) {
					if (path[index][j] < 0) {
						
					} else {
						if (sum[j] > sum[index] + path[index][j]) {
							sum[j] = sum[index] + path[index][j];
							pre[j] = index;
						}
					}
				}
			}
		}
		System.out.println(sum[end]);
	}
}
