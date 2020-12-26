//https://leetcode.com/problems/single-number/
import java.util.Arrays;

public class SolutionSingNumber {
	 public static int singleNumber(int[] nums) {
	        int answer = 0;
	        if(nums.length == 1) {
	            answer = nums[0];
	        } else {
	            Arrays.sort(nums);
	            boolean flag = false;
	            for(int i = 0; i < nums.length-1; i++) {
	                if(nums[i] == nums[i+1]) {
	                    i++;         
	                } else {
	                    flag = true;
	                    answer = nums[i];
	                    break;
	                }
	            }
	            if(!flag) answer = nums[nums.length-1];
	        }
	        return answer;
	 }
	 
	public static void main(String[] args) {
		int n[] = {2, 2, 1};
		System.out.println(singleNumber(n));
	}
}
