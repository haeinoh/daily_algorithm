public class Solution49191 {
    static int solution(int n, int[][] results) {
        int answer = n;
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                dist[i][j] = 987654321;
            }
        }

        for(int i = 0; i < results.length; i++) {
            dist[results[i][0]-1][results[i][1]-1] = 1;
        }

       for(int m = 0; m < n; m++) {
           for(int s = 0; s < n; s++) {
               for(int e = 0; e < n; e++) {
                   if(dist[s][e] > dist[s][m] + dist[m][e]) {
                       dist[s][e] = dist[s][m] + dist[m][e];
                   }
               }
           }
       }

       for(int i = 0; i < n; i++) {
           for(int j = 0; j < n; j++) {
               if(dist[i][j] == 987654321 && dist[j][i] == 987654321) {
                   answer--;
                   break;
               }
           }
       }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] r = {
                {4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
        };
        System.out.println(solution(n, r));
    }
}
