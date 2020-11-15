import java.util.ArrayList;
import java.util.Arrays;

public class Solution12906 {

	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0, arr[0]);
		int idx = 1;
		
		
 		for(int i = 1; i < arr.length; i++) {
			if(list.get(idx-1) != arr[i]) {
				list.add(idx, arr[i]);
				idx++;
			}
		}
 		int[] answer = new int[list.size()];
 		
 		for(int i = 0; i < list.size(); i++)
 			answer[i] = list.get(i);
 		
		System.out.println(Arrays.toString(answer));
	}
}
