//https://leetcode.com/problems/median-of-two-sorted-arrays/
import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionMedianOfTwoSortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    double result = 0;
	    int len = nums1.length+nums2.length;
//		int merge[] = new int[len];
	    
	    int x = 0;
	    int y = 0;
	    int idx = 0;
	    int prev = 0;
	    int cur = 0;
	    
	    while(x < nums1.length || y < nums2.length) { // 71.33%
	    	if(x < nums1.length && y < nums2.length) {
	    		if(nums1[x] < nums2[y]) {
	    			cur = nums1[x];
	    			x++;
	    		} else {
	    			cur = nums2[y];
	    			y++;
	    		}
	    	} else if(x < nums1.length && y >= nums2.length) {
	    		cur = nums1[x];
	    		x++;
	    	} else if(x >= nums1.length && y < nums2.length) {
	    		cur = nums2[y];
	    		y++;
	    	}
	    	if(idx == len/2) break;
	    	idx++;
	    	prev = cur;
	    }
	    
	    if(len % 2 == 0) result = (prev+cur) / 2.0;
	    else result = cur;
	    
	   
// (2) using array 	    
//	    while(x < nums1.length || y < nums2.length) { // 57.55%
//	    	if(x < nums1.length && y < nums2.length) {
//	    		if(nums1[x] < nums2[y]) {
//	    			merge[idx] = nums1[x];
//	    			x++;
//	    		} else {
//	    			merge[idx] = nums2[y];
//	    			y++;
//	    		}
//	    	} else if(x < nums1.length && y >= nums2.length) {
//	    		merge[idx] = nums1[x];
//	    		x++;
//	    	} else if(x >= nums1.length && y < nums2.length) {
//	    		merge[idx] = nums2[y];
//	    		y++;
//	    	}
//	    	if(idx == len/2) break;
//	    	idx++;
//	    }
//		if(len % 2 == 0) {
//			result = (merge[len/2] + merge[len/2-1]) / 2.0;
//		} else result = merge[len/2];

//    (3) using priorityqueue
//		
//		PriorityQueue<Integer> q = new PriorityQueue<>();
//		
//		for(int i = 0; i < nums1.length; i++) q.add(nums1[i]);
//		for(int i = 0; i < nums2.length; i++) q.add(nums2[i]);
//		
//		for(int i = 0; i < len; i++) {
//			merge[i] = q.poll();
//		}
//		
//		if(len % 2 == 0) {
//			result = (merge[len/2] + merge[len/2-1]) / 2.0;
//		} else result = merge[len/2];
	    
	    
		return result;
	}
	
	public static void main(String[] args) {
		int n[] = {1,2};
		int n2[] = {3,4};
	
		System.out.println(findMedianSortedArrays(n, n2));
	}
}
