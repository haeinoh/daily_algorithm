//https://leetcode.com/problems/unique-paths-ii/
public class SolutionUniquePaths2 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int N = obstacleGrid.length;
        int M = obstacleGrid[0].length;

        int dp[][] = new int[N][M];

        if(obstacleGrid[0][0] == 0) dp[0][0] = 1; 
        
        for(int i = 1; i < N; i++) 
        	if(obstacleGrid[i][0] == 0) dp[i][0] = dp[i-1][0];
        
        for(int i = 1; i < M; i++) 
        	if(obstacleGrid[0][i] == 0) dp[0][i] = dp[0][i-1];
        
        
        for(int i = 1; i < N; i++) {
        	for(int j = 1; j < M; j++) {
        		if(obstacleGrid[i][j] == 0) dp[i][j] = dp[i-1][j] + dp[i][j-1];
        	}
        }
         
    	return dp[N-1][M-1];
    }
    
	public static void main(String[] args) {
		/*int o[][] = {
			{0,0,0},
			{0,1,0},
			{0,0,0}	
		};
		*/
		int o[][] = {
				{1,0},
		};
		
		System.out.println(uniquePathsWithObstacles(o));
	}
}
