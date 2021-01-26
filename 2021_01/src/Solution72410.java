//https://programmers.co.kr/learn/courses/30/lessons/72410
public class Solution72410 {
    public static String solution(String new_id) {
        String answer = "";
        // 1
        answer = new_id.toLowerCase();
        String tmp = "";
        // 2
        for(int i = 0; i < answer.length(); i++) {
        	if(('a' <= answer.charAt(i) && answer.charAt(i) <= 'z')  
        			|| Character.isDigit(answer.charAt(i)) || answer.charAt(i) == '.'
        			|| answer.charAt(i) == '_' || answer.charAt(i) == '-') tmp += answer.charAt(i);
        }
        answer = tmp;

        // 3
        tmp = "";
        boolean flag = false;
        for(int i = 0; i < answer.length() - 1; i++) {
        	if(answer.charAt(i) == '.' && answer.charAt(i+1) == '.') flag = true;
        	else if(flag && answer.charAt(i) == '.' && answer.charAt(i+1) != '.') {
        		flag = false;
        		tmp += '.';
        	} else if(!flag) tmp += answer.charAt(i); 
        }
        tmp += answer.charAt(answer.length()-1);
        System.out.println(tmp);
        answer = tmp;
        
        // 4
        if(answer.charAt(0) == '.') answer = answer.substring(1, answer.length());
        if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);
        
        // 5
        if(answer.length() == 0) answer = "a";
        
        // 6
        if(answer.length() >= 16) {
        	answer = answer.substring(0, 15);
        	if(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);
        }
        
        // 7
        if(answer.length() <= 2) {
        	tmp = String.valueOf(answer.charAt(answer.length()-1));
        	while(answer.length() < 3) {
        		answer += tmp;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		
		String s = "abcdefghijklmn.p";
//		String s = "=.=";
		System.out.println(solution(s));
	}
}
