public class Solution42898 {
    static int[] dx = {-1, 0};
    static int[] dy = {0, -1};
    static int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n][m];
        for(int i = 0; i < puddles.length; i++) {
            arr[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }
        arr[0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                if((i == 0 && j == 0) || arr[i][j] == -1) continue;
                for(int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m || arr[nx][ny] == -1) continue;
                    arr[i][j] += (arr[nx][ny] % 1000000007);
                }
            }
        }
        return arr[n-1][m-1];
    }
    public static void main(String[] args) {
        int m = 4;
        int n = 1;
        int[][] p = {{2, 1}};

        System.out.println(solution(m, n, p));
    }
}
