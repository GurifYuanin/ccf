package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class On_2017_12_03 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int line = Integer.parseInt(arr[0]);
		String[][] command = new String[line][6];
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.set(Integer.parseInt(arr[1].substring(0, 4)),
				Integer.parseInt(arr[1].substring(4, 6)) - 1,
				Integer.parseInt(arr[1].substring(6, 8)),
				Integer.parseInt(arr[1].substring(8, 10)),
				Integer.parseInt(arr[1].substring(10, 12)),
				0);
		end.set(Integer.parseInt(arr[2].substring(0, 4)),
				Integer.parseInt(arr[2].substring(4, 6)) - 1,
				Integer.parseInt(arr[2].substring(6, 8)),
				Integer.parseInt(arr[2].substring(8, 10)),
				Integer.parseInt(arr[2].substring(10, 12)),
				0);
		for (int i = 0; i < line; i++) {
			command[i] = buf.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				String str = command[i][j];
				if (!str.equals("*")) {
					str = str.replace(",", " ");
					if (j == 2) {
						str = replaceMontn(str);
					}
					if (j == 4) {
						str = replaceWeek(str);
					}
					int index = str.indexOf("-");
					while (index >= 0) {
						int s = index - 2 >= 0 && str.charAt(index - 2) >= 48 && str.charAt(index - 2) <= 57 ?
								Integer.parseInt(str.substring(index - 2, index)) :
								Integer.parseInt(str.substring(index - 1, index));
						int e = index + 2 < str.length() && str.charAt(index + 2) >= 48 && str.charAt(index + 2) <= 57 ?
								Integer.parseInt(str.substring(index + 1, index + 3)) :
								Integer.parseInt(str.substring(index + 1, index + 2));
						String newChar = s + "";
						for (int k = s + 1; k <= e; k++) {
							newChar += " " + k;
						}
						str = str.replace(s + "-" + e, newChar);
						index = str.indexOf("-");
					}
					command[i][j] = str;
//					System.out.println(str);
				}
			}
		}
		buf.close();
		
		while (start.getTimeInMillis() < end.getTimeInMillis()) {
			for (int i = 0; i < line; i++) {
				if (isOk(start, command[i])) {
					System.out.println(String.format("%4d%02d%02d%02d%02d %s", 
							start.get(Calendar.YEAR),
							start.get(Calendar.MONTH) + 1,
							start.get(Calendar.DAY_OF_MONTH),
							start.get(Calendar.HOUR_OF_DAY),
							start.get(Calendar.MINUTE),
							command[i][5]
							));
//					System.out.println(start.get(Calendar.DAY_OF_WEEK));
				}
			}
			start.add(Calendar.MINUTE, 1);
		}
	}
	static boolean isOk (Calendar date, String[] command) {
		String[] arr = null;
		int[] tmp = new int[5];
		tmp[0] = date.get(Calendar.MINUTE);
		tmp[1] = date.get(Calendar.HOUR_OF_DAY);
		tmp[2] = date.get(Calendar.DAY_OF_MONTH);
		tmp[3] = date.get(Calendar.MONTH) + 1;
		tmp[4] = date.get(Calendar.DAY_OF_WEEK) - 1;
		for (int i = 0; i < 5; i++) {
			boolean flag = false;
			if (!command[i].equals("*")) {
				arr = command[i].split(" ");
				for (int j = 0; j < arr.length; j++) {
					if (Integer.parseInt(arr[j]) == tmp[i]) {
						flag = true;
						break;
					}
				}
				if (!flag) return flag;
			}
		}
		return true;
	}
	static String replaceMontn (String origin) {
		origin = origin.replace("Jan", "1");
		origin = origin.replace("Feb", "2");
		origin = origin.replace("Mar", "3");
		origin = origin.replace("Apr", "4");
		origin = origin.replace("May", "5");
		origin = origin.replace("Jun", "6");
		origin = origin.replace("Jul", "7");
		origin = origin.replace("Aug", "8");
		origin = origin.replace("Sep", "9");
		origin = origin.replace("Oct", "10");
		origin = origin.replace("Nov", "11");
		origin = origin.replace("Dec", "12");
		return origin;
	}
	static String replaceWeek (String origin) {
		origin = origin.replace("Sun", "0");
		origin = origin.replace("Mon", "1");
		origin = origin.replace("Tue", "2");
		origin = origin.replace("Wed", "3");
		origin = origin.replace("Thu", "4");
		origin = origin.replace("Fri", "5");
		origin = origin.replace("Sat", "6");
		return origin;
	}
	
}
