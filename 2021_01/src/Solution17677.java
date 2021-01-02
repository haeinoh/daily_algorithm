//https://programmers.co.kr/learn/courses/30/lessons/17677?language=java
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Solution17677 {
	public static boolean check(String str) {
		String pattern = "^[a-z]*$*";
		boolean result = Pattern.matches(pattern, str);
		return result;
	}
	public static int solution(String str1, String str2) {
		int answer = 0;

		str1 = str1.toLowerCase(); // lowercase·Î ¸ÂÃã
		str2 = str2.toLowerCase();
		
		ArrayList<String> s1 = new ArrayList<>();
		ArrayList<String> s2= new ArrayList<>();
		
		for(int i = 0; i < str1.length()-1; i++) {
			String st = str1.substring(i, i+2);
			if(check(st)) s1.add(st);
		}
		
		for(int i = 0; i < str2.length()-1; i++) {
			String st = str2.substring(i, i+2);
			if(check(st)) s2.add(st);
		}
		
		double hap = s1.size() + s2.size();
		double gyo = 0;

		for(int i = 0; i < s1.size(); i++) {
			loop:for(int j = 0; j < s2.size(); j++) {
				if(s1.get(i).equals(s2.get(j))) {
					gyo++;
					s2.remove(j);
					break loop;
				}
			}
		}
		if(gyo == 0 && hap == 0) return 65536;
		hap -= gyo;
		return (int) ((gyo / hap) * 65536);
	}

	public static void main(String[] args) {

		String a = "E=M*C^2";
		String b = "e=m*c^2";
		
		System.out.println(solution(a, b));
	}
}
