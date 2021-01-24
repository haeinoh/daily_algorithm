import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/60060
public class Solution60060 {
    public static int[] solution(String[] words, String[] queries) {
        int answer[] = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
        	int start = 0;
        	int end = 0;
        	boolean flag = false;
        	for(int k = 0; k < queries[i].length(); k++) {
        		if(!flag && queries[i].charAt(k) == '?') {
        			start = k;
        			flag = true;
        		} else if(flag && queries[i].charAt(k) == '?') {
        			end = k;
        		}
        	}
        	loop:for(int j = 0; j < words.length; j++) {
        		if(words[j].length() != queries[i].length()) continue loop;
        		else {
        			if(end-start == words[j].length()) {
        				answer[i]++;
        				continue;
        			} else {
        				if(start == 0) { // ¾Õ¿¡
        					for(int p = end+1; p < queries[i].length(); p++) {
        						if(queries[i].charAt(p) != words[j].charAt(p)) continue loop;
        						answer[i]++;
        					}
        				} else {
        					for(int p = 0; p < start; p++) {
        						if(queries[i].charAt(p) != words[j].charAt(p)) continue loop;
        					}
        					answer[i]++;
        				}
        			}
        		}
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		String w[] = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String q[] = {"fro??", "????o", "fr???", "fro???", "pro?"};
		
		System.out.println(Arrays.toString(solution(w, q)));
	}
}
