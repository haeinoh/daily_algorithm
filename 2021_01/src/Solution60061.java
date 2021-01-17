//https://programmers.co.kr/learn/courses/30/lessons/60061
import java.util.Arrays;

public class Solution60061 {
    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        
        System.out.println(build_frame.length);
        
        return answer;
    }

    public static void main(String[] args) {
    	int b[][] = {
	    	{1,0,0,1},
	    	{1,1,1,1},
	    	{2,1,0,1},
	    	{2,2,1,1},
	    	{5,0,0,1},
	    	{5,1,0,1},
	    	{4,2,1,1},
	    	{3,2,1,1}
    	};
    	
    	int r[][] = solution(5, b);
    	for(int p[]: r) System.out.println(Arrays.toString(p));
	}
}
