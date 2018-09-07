package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class On_2016_12_03 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int priNum = Integer.parseInt(buf.readLine());
		String[] pri = new String[priNum];
		for (int i = 0; i < priNum; i++) {
			pri[i] = buf.readLine();
		}
		
		int roleNum = Integer.parseInt(buf.readLine());
		HashMap<String, LinkedList<String>> role = new HashMap<String, LinkedList<String>>();
		String[] roleName = new String[roleNum];
		for (int i = 0; i < roleNum; i++) {
			String[] arr = buf.readLine().split(" ");
			roleName[i] = arr[0];
			int j = Integer.parseInt(arr[1]);
			LinkedList<String> tmp = new LinkedList<String>();
			for (int k = 2; k < j + 2; k++) {
				tmp.add(arr[k]);
			}
			role.put(roleName[i], tmp);
		}
		
		int peoNum = Integer.parseInt(buf.readLine());
		HashMap<String, LinkedList<String>> people = new HashMap<String, LinkedList<String>>();
		String[] peopleName = new String[peoNum];
		for (int i = 0; i < peoNum; i++) {
			String[] arr = buf.readLine().split(" ");
			peopleName[i] = arr[0];
			int j = Integer.parseInt(arr[1]);
			LinkedList<String> tmp = new LinkedList<String>();
			for (int k = 2; k < j + 2; k++) {
				tmp.add(arr[k]);
			}
			people.put(peopleName[i], tmp);
		}
		
		int query = Integer.parseInt(buf.readLine());
		for (int i = 0; i < query; i++) {
			String[] arr = buf.readLine().split(" ");
			if (!people.containsKey(arr[0])) {
				System.out.println("false");
				continue;
			}
			if (arr[1].contains(":")) {
				// 带查询等级查询
				int flag = 0;
				String[] tmpArr = arr[1].split(":");
				
				Iterator<String> ite = people.get(arr[0]).iterator();
				while (ite.hasNext()) {
					Iterator<String> it = role.get(ite.next()).iterator();
					while (it.hasNext()) {
						String p = it.next();
						if (p.indexOf(tmpArr[0]) == 0) {
							if (Integer.parseInt(p.split(":")[1]) <= Integer.parseInt(tmpArr[1])) {
								flag = 1; // 找到并且等级够
							} else {
								flag = 2; // 找到但是等级不够
							}
							break;
						}
					}
					if (flag == 0) break;
				}
				System.out.println(flag == 1 ? "true" : "false");
			} else {
				// 不带查询权限
				int need = 0; // 如果有权限等级，则最高多少
				String flag = "false";
				for (int j = 0; j < priNum; j++) {
					if (pri[j].indexOf(arr[1]) == 0) {
						if (pri[j].contains(":"))
							need = Integer.parseInt(pri[j].split(":")[1]);
						break;
					}
				}
				Iterator<String> ite = people.get(arr[0]).iterator();
				while (ite.hasNext()) {
					Iterator<String> it = role.get(ite.next()).iterator();
					while (it.hasNext()) {
						String p = it.next();
						if (p.indexOf(arr[1]) == 0) {
							if (p.contains(":")) {
								int t = Integer.parseInt(p.split(":")[1]);
								if (t >= need) {
									flag = "true";
								} else {
									flag = flag.equals("false") ?
											"" + t :
											"" + Math.max(Integer.parseInt(flag), t);
								}
							} else {
								flag = "true";
							}
						}
						if (flag.equals("true")) break;
					}
				}
				System.out.println(flag);

			}
		}
		buf.close();
	}
}
