//https://programmers.co.kr/learn/courses/30/lessons/17684
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution17684 {
	public static List<String> list;
	public static List<Integer> ans;
	public static void main(String[] args) {
		String msg = "TOBEORNOTTOBEORTOBEORNOT"; //TEST용
		int[] answer = {}; 
		
		list = new ArrayList<>();
		ans = new ArrayList<>();
		
		list.add("/");
		for(int i = 1; i < 27; i++) {
			list.add(String.valueOf((char)(i+64)));
		}
		
		int index = 0;
		
		while(true) {
			//index값을 기준으로 +1, +2 씩 해서 제일 긴 문자열 (list에 존재하는 것 중에)
			String str = "";
			String max = ""; // 
			String next = ""; // 사전추가 (w+c)
			for(int i = index; i < msg.length(); i++) {
				str += String.valueOf(msg.charAt(i));
				if(list.contains(str) && str.length() >= max.length()) {
					max = str;
				} else {
					next = str;
					break;
				}
			}

			if(list.contains(max)) {
				ans.add(list.indexOf(max)); // 사전에 이미 존재하면, 정답에 add
				if(next.equals("")) break;
			} 
			
			if(!list.contains(next)) { // 사전에 없으므로 list에 add
				list.add(next);
				index += next.length()-1;
			}
		}
		
		answer = new int[ans.size()]; 
		for(int i = 0; i < ans.size(); i++) answer[i] = ans.get(i);

		System.out.println(Arrays.toString(answer)); //TEST용
	}
}
