//https://programmers.co.kr/learn/courses/30/lessons/72413

public class Solution72413 {
	public static int arr[][], dist[][];
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 987654321;
        arr = new int[n+1][n+1];
        dist = new int[n+1][n+1];
        
        for(int i = 0; i < fares.length; i++) {
        	arr[fares[i][0]][fares[i][1]] = fares[i][2];
        	arr[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        //초기화
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		dist[i][j] = (arr[i][j] == 0 && (i!=j)) ? 987654321 : arr[i][j];
        	}
        }
        
        for(int k = 1; k <= n; k++) { // 거쳐가는 노드
        	for(int i = 1; i <= n; i++) { // 출발 노드
        		for(int j = 1; j <= n; j++) { // 도착 노드
        			if(dist[i][j] > dist[i][k] + dist[k][j]) 
        				dist[i][j] = dist[i][k] + dist[k][j];
        		}
        	}
        }
        
        for(int i = 1; i <= n; i++) {
        	if(dist[s][i] != 987654321) {
        		answer = Math.min(answer, (dist[s][i] + dist[i][a] + dist[i][b]));
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int fares[][] = {
			{4, 1, 10}, 
			{3, 5, 24}, 
			{5, 6, 2}, 
			{3, 1, 41}, 
			{5, 1, 24}, 
			{4, 6, 50},
			{2, 4, 66}, 
			{2, 3, 22}, 
			{1, 6, 25}
		};
		
		System.out.println(solution(n, s, a, b, fares));
	}
}
