//https://leetcode.com/problems/container-with-most-water/
public class SolutionContainerWithMostWater {

	public static int maxArea(int[] height) {
		int answer = 0;
		// (1) brute force
		for(int i = 0; i < height.length; i++) {
			for(int j = height.length-1; j > i; j--) {
				int tmp = (height[i] < height[j]) ? height[i] : height[j];
				int num = tmp * (j-i);
				if(answer < num) answer = num;
			}
		}
		
		// (2) two pointer
		int start = 0;
		int end = height.length-1;
		while(start < end) {
			answer = Math.max(answer, Math.min(height[start], height[end])*(end-start));
			if(height[start] < height[end]) {
				start++;
			} else {
				end--;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {

		int h[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(h));
	}
}
