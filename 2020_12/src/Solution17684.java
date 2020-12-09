//https://programmers.co.kr/learn/courses/30/lessons/17684
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution17684 {
	public static List<String> list;
	public static List<Integer> ans;
	public static void main(String[] args) {
		String msg = "TOBEORNOTTOBEORTOBEORNOT"; //TEST��
		int[] answer = {}; 
		
		list = new ArrayList<>();
		ans = new ArrayList<>();
		
		list.add("/");
		for(int i = 1; i < 27; i++) {
			list.add(String.valueOf((char)(i+64)));
		}
		
		int index = 0;
		
		while(true) {
			//index���� �������� +1, +2 �� �ؼ� ���� �� ���ڿ� (list�� �����ϴ� �� �߿�)
			String str = "";
			String max = ""; // 
			String next = ""; // �����߰� (w+c)
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
				ans.add(list.indexOf(max)); // ������ �̹� �����ϸ�, ���信 add
				if(next.equals("")) break;
			} 
			
			if(!list.contains(next)) { // ������ �����Ƿ� list�� add
				list.add(next);
				index += next.length()-1;
			}
		}
		
		answer = new int[ans.size()]; 
		for(int i = 0; i < ans.size(); i++) answer[i] = ans.get(i);

		System.out.println(Arrays.toString(answer)); //TEST��
	}
}
