import java.util.Arrays;

public class SolutionLongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        String res = "";
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length() - 1; i++) 
        	if(s.charAt(i) == s.charAt(i+1)) dp[i][i+1] = true; 
        	
        for(boolean p[] : dp) System.out.println(Arrays.toString(p));
        
        for(int i = 1; i < s.length(); i++) {
        	for(int j = 0; j < s.length() - 1; j++) {
        		if(s.charAt(j) == s.charAt(j+1) && dp[j+1][j+i]) {
        			System.out.println(res + "  " + s.substring(j, j+1) + " " + res.compareTo(s.substring(j, j+1)));
        			if(res.compareTo(s.substring(j, j+2)) > 0) 
        				res = s.substring(j, j+1);
        			dp[j][j+1] = true;
        		}
        	}
        }
        
    	return res;
    }
	
	public static void main(String[] args) {
		String s = "babad";
		
		System.out.println(longestPalindrome(s));
	}
}
