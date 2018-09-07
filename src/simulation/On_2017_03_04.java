package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class On_2017_03_04 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int nodeNumber = Integer.parseInt(arr[0]);
		int pathNumber = Integer.parseInt(arr[1]);
		int[][] path = new int[nodeNumber][nodeNumber];
		for (int i = 0; i < nodeNumber; i++) Arrays.fill(path[i], Integer.MAX_VALUE);
		for (int i = 0; i < pathNumber; i++) {
			arr = buf.readLine().split(" ");
			int start = Integer.parseInt(arr[0]) - 1;
			int end = Integer.parseInt(arr[1]) - 1;
			int cost = Integer.parseInt(arr[2]);
			path[start][end] = path[end][start] = cost;
		}
		buf.close();
		
		boolean[] isVisited = new boolean[nodeNumber];
		int[] dist = new int[nodeNumber];
		Arrays.fill(isVisited, false);
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		for (int i = 0, index = 0, min; i < nodeNumber; i++) {
			min = Integer.MAX_VALUE;
			for (int j = 0; j < nodeNumber; j++) {
				if (!isVisited[j] && dist[j] < min) {
					min = dist[j];
					index = j;
				}
			}
			isVisited[index] = true;
			for (int j = 0; j < nodeNumber; j++) {
				if (!isVisited[j] && path[index][j] < Integer.MAX_VALUE && Math.max(dist[index], path[index][j]) < dist[j]) {
					dist[j] = Math.max(dist[index], path[index][j]);
				}
			}
		}
		System.out.print(dist[nodeNumber - 1]);
	}
}
