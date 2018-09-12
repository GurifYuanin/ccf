package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class On_2016_04_03 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(buf.readLine());
		String dir = buf.readLine();
		for (int i = 0; i < length; i++) {
			String path = buf.readLine();
			path = path.replaceAll("/{2,}", "/");
			path = path.replaceAll("(?<!\\.)\\./", "");
			if (path.charAt(0) != '.' && path.charAt(0) != '/') {
				path = dir + "/" + path;
			} else if (path.indexOf("../") == 0) {
				path = path.substring(2);
			}
			int index = path.indexOf("../");
			while (index != -1) {
				if (index == 1) {
					path = path.substring(3);
				} else {
					path = path.substring(0, path.substring(0, index - 1).lastIndexOf("/") + 1
							) + path.substring(index + 3);
				}
				index = path.indexOf("../");
			}
			System.out.println(path);
			
		}
		buf.close();
	}
}
