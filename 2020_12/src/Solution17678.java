//https://programmers.co.kr/learn/courses/30/lessons/17678
import java.util.Arrays;

public class Solution17678 {

	public static void main(String[] args) {
		String answer = "";
		int n = 2;
		int t = 10;
		int m = 2;
		String timetable[] = {"09:10", "09:09", "08:00"}; // test��
//		String timetable[] = {"08:00", "08:01", "08:02", "08:03"}; // test��
		int time[] = new int[timetable.length];
		
		for(int i = 0; i < timetable.length; i++) {
			String str[] = timetable[i].split(":");
			time[i] = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
		}
		
		Arrays.sort(time);
		System.out.println(Arrays.toString(time));
		int start = 9*60;
		int ans = 0;
		int idx = 0;
		// ������ �� ���� �� Ÿ�� ��� 
		// ������ Ż �� �ִ� ���
		for(int i = 0; i < n; i++) {
			
			
		}
		
		if(ans / 60 < 12) answer += "0";
		answer += (ans/60) + ":";
		if(ans % 60 < 10) answer += "0";
		answer += (ans % 60);
		System.out.println(answer);
	}
}
