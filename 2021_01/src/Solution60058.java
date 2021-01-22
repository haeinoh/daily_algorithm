
public class Solution60058 {
	public static String answer;
	public static int extract(String p) {
		int left = 0;
		int right = 0;
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '(') left++;
			else right++;
			if(left == right) return i;
		}
		
		return -1;
	}
	
	public static boolean check(String str) {
		boolean arr[]= new boolean[str.length()];

		int left = 0;
		int right = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				arr[left++] = true;
			}
			
			if(str.charAt(i) == ')') {
				if(!arr[right]) return false;
				right++;
			}
		}
		return true;
	}
	
	public static String split(String p) {
		if(("").equals(p)) return p;
		
		while(p.length() > 0) {
			int idx = extract(p);
			String u = p.substring(0, idx+1);
			String v = p.substring(idx+1, p.length());
			boolean res = check(u);
			if(res) { // 올바른 괄호 문자열
				answer += u;
				p = v;
			}
			else {
				answer += "(";
				//v에 대해 재귀적으로 수행
				split(v);
				answer += ")";
				for(int i = 1; i < u.length() - 1; i++) {
					if(u.charAt(i) == '(') answer += ")";
					else answer += "(";
				}	
				p = "";
			}
		}
		return answer;
	}
	public static String solution(String p) {
		answer = "";
        
        return split(p);
    }
	
	public static void main(String[] args) {
//		String p = "(()())()";
//		String p = ")(";
		String p = "()))((()";
		System.out.println(solution(p));
	}
}
