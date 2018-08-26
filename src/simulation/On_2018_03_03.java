package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class On_2018_03_03 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int ruleNumber = Integer.parseInt(arr[0]);
		int reqNumber = Integer.parseInt(arr[1]);
		Pattern[] rules = new Pattern[ruleNumber];
		Pattern isNumber = Pattern.compile("\\d+");
		String[] name = new String[ruleNumber];
		for (int i = 0; i < ruleNumber; i++) {
			arr = buf.readLine().split(" ");
			arr[0] = arr[0].replace("<int>", "(\\d+)");
			arr[0] = arr[0].replace("<str>", "([0-9a-z_.-]+)");
			arr[0] = arr[0].replace("<path>", "([0-9a-z_./-]+)");
			arr[0] = arr[0] + "$";
			name[i] = arr[1];
//			System.out.println(arr[0]);
			rules[i] = Pattern.compile(arr[0]);
		}
		for (int i = 0; i < reqNumber; i++) {
			String str = buf.readLine();
			boolean flag = true;
			for (int j = 0; j < ruleNumber; j++) {
				Matcher m = rules[j].matcher(str);
				if (m.find()) {
					System.out.print(name[j]);
					for (int k = 1; k < m.groupCount() + 1; k++) {
						if (isNumber.matcher(m.group(k)).find()) {
							System.out.print(" " + Integer.parseInt(m.group(k)));
						} else {
							System.out.print(" " + m.group(k));
						}
					}
					System.out.println();
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("404");
			}
		}
		buf.close();
//		Pattern p = Pattern.compile("/articles/\\d+/");
//		System.out.println(p.matcher("/articles/2004/").find());
//		System.out.println(p.matcher("/articles/2004/").find());
	}
}
