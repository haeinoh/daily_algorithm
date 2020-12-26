
public class Solution42746 {
	public static int len;
	public static String answer;
	public static boolean vtd[];
	
	public static void solve(int[] numbers, String str, int count) {
		System.out.println(answer + " " + str);
		if(count == len) {
			if(str.compareTo(answer) > 0) 
				answer = str;
			
			return;
		}
		
		for(int i = 0; i < len; i++) {
			if(!vtd[i]) {
				vtd[i] = true;
				solve(numbers, str+String.valueOf(numbers[i]), count+1);
				vtd[i] = false;
			}
		}
	}
	
	public static String solution(int[] numbers) {
        answer = "";
        len = numbers.length;
        vtd = new boolean[len];
        solve(numbers, "", 0);
        
        return answer;
    }
	
	public static void main(String[] args) {
		int n[] = {0, 0, 0, 0, 0};
		System.out.println(solution(n));
	}
}
