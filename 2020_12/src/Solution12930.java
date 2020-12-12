
public class Solution12930 {

	public static void main(String[] args) {
		String s = "try hello world";
		String answer = "";
		int idx = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				answer += " ";
				idx = 0;
				continue;
			} else if(idx % 2 == 0) {
				answer += String.valueOf(s.charAt(i)).toUpperCase();
			} else {
				answer += String.valueOf(s.charAt(i)).toLowerCase();
			}
			idx++;
		}
		System.out.println(answer);
	}
}
