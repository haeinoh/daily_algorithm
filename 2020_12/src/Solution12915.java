//https://programmers.co.kr/learn/courses/30/lessons/12915?language=java
import java.util.Arrays;
import java.util.Comparator;

public class Solution12915 {

	public static void main(String[] args) {
		String[] strings  = {"sun", "bed", "car"};
		int n = 1;
		String [] answer = new String[strings.length];
		
		Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.charAt(n) > o2.charAt(n)) return 1;
				else if(o1.charAt(n) == o2.charAt(n)) return o1.compareTo(o2);
				return -1;
			}
		});
		answer = strings;
		System.out.println(Arrays.toString(answer));
	}
}
