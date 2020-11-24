//https://programmers.co.kr/learn/courses/30/lessons/42885
import java.util.Arrays;

public class Solution42885 {

	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int answer = 0;

		int limit = 100;
		Arrays.sort(people);
		int idx = 0;
		for(int i = people.length-1; i >= idx; i--) {
			if(people[i] + people[idx] <= limit) idx++;
			answer++;
		}
	
		System.out.println(answer);
	}
}
