import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution42891 {
	public static class Food {
		int index;
		int time;
		public Food(int index, int time) {
			this.index = index;
			this.time = time;
		}
	}
	public static int solution(int[] food_times, long k) {
		List<Food> list = new LinkedList<>();
		for(int i = 0; i < food_times.length; i++) {
			list.add(new Food(i, food_times[i]));
		}
		
		Collections.sort(list, new Comparator<Food>() {
			@Override
			public int compare(Food o1, Food o2) {
				return o1.time - o2.time; // 오름차순
			}
		});
		
		for(Food f: list) {
			System.out.println(f.index + " " +f.time);
		}
		
		int prev = 0;
		long eat = 0;
		
		while(list.size() > 0) {
			long diff = list.get(1).time - prev;
			if(diff != 0) {
				eat = diff * list.size();
				if(eat > k)  
					break;
				
				k -= eat;
				prev = list.get(0).time;
			}
			list.remove(0);
			System.out.println("??? " + list.get(0).time);
		}
		
		if(list.size() == 0) return -1; // 아무것도 없으면
		
		Collections.sort(list, new Comparator<Food>() {
			@Override
			public int compare(Food o1, Food o2) {
				return o1.index - o2.index; // 오름차순
			}
		});
		System.out.println("// "  + k +  " "  + list.size());
		k %= (long) list.size();
		
		return (list.get((int)k).index)+1; 
	}

	public static void main(String[] args) {
//		int f[] = {3, 1, 2};
//		int f[] = {4, 2, 3, 1};
//		int f[] = {4,2,3,6,7,1,5,8};
		int f[] = {7,8,3,3,2,2,2,2,2,2,2,2};
//		int f[] = {1,1,1,1};
		System.out.println(solution(f, 35));
	}
}