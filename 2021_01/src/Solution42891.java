import java.util.ArrayList;

public class Solution42891 {
	public static int solution(int[] food_times, long k) {
		int answer = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < food_times.length; i++) list.add(food_times[i]);
		
		for(int i = 0; i < k-1; i++) {
//			System.out.println(i + " " + list.size() + " " + i%list.size());
//			System.out.println(list.toString());
			int num = i % list.size();
			answer = num;
			if(list.get(num) > 1) list.set(num, list.get(num) - 1);
			else if(list.get(num) == 1) list.remove(num);
//			System.out.println("answer " + answer);
		}
		
		if(list.size() == 0) return -1;
		answer = (answer+1) % 2; 
		
		return answer+1;
	}

	public static void main(String[] args) {
		int f[] = {3, 1, 2};
		System.out.println(solution(f, 5));
	}
}