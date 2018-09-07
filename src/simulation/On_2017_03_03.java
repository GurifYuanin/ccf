package simulation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class On_2017_03_03 {
	static Pattern p = Pattern.compile("\\[(.+)]\\((.+)\\)");
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int pEnd = 0, liEnd = 0;
		while(sca.hasNextLine()) {
			String line = sca.nextLine();
			if (line.indexOf("#") == 0) {
				int level = 0;
				while (level < line.length() && line.charAt(level) == '#' ) {
					level++;
				}
				if (pEnd > 0) {
					System.out.println("</p>");
					pEnd = 0;
				}
				System.out.println("<h" + level + ">" + line.substring(level + 1) + "</h" + level + ">");
			} else if (line.length() == 0) {
				if (liEnd > 0) {
					System.out.println("</ul>");
					liEnd = 0;
				}else if (pEnd > 0) {
					System.out.println("</p>");
					pEnd = 0;
				}
			} else if (line.indexOf("*") == 0){
				if (liEnd == 0) {
					System.out.println("<ul>");
				}
				System.out.println("<li>" + filterInline(line.substring(2)) + "</li>");
				liEnd++;
			} else {
				line = filterInline(line);
				if (pEnd == 0) {
					System.out.print("<p>" + line);
				} else {
					System.out.print("\n" + line);
				}
				pEnd++;
			}
		}
		if (pEnd > 0) {
			System.out.print("</p>");
		}
		sca.close();
	}
	static String filterInline (String string) {
		while (string.contains("_")) {
			int i = string.indexOf("_");
			string = string.substring(0, i) + "<em>" + string.substring(i + 1);
			i = string.indexOf("_");
			string = string.substring(0, i) + "</em>" + string.substring(i + 1);
		}
		Matcher m = p.matcher(string);
		if (m.find()) {
			string = string.replaceAll("\\[.+](.+)", "<a href=\"" + m.group(1) + "\">" + m.group(2) + "</a>");
		}
		
		return string;
	}
}




