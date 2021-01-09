import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution42891 {
	public static int solution(int[] food_times, long k) {
		int answer = 0;
		int arr[][] = new int[food_times.length][2];
		for(int i = 0; i < food_times.length; i++) {
			arr[i][0] = i;
			arr[i][1] = food_times[i];
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		for(int p[]: arr) System.out.println(Arrays.toString(p));
		long sum = 0;
		for(int i = 0; i < food_times.length; i++) {
			sum += arr[i][1];
			if(sum == k) {
				if(i+1 != food_times.length) answer = arr[i+1][0]+1;
				break;
			} else if(sum > k) {
				
			}
		}
		if(answer == 0) return -1;
		return answer; 
	}

	public static void main(String[] args) {
//		int f[] = {3, 1, 2};
//		int f[] = {4, 2, 3, 1};
		int f[] = {4,2,3,6,7,1,5,8};
		System.out.println(solution(f, 4));
	}
}