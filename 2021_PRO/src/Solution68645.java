import java.util.Arrays;

public class Solution68645 {
    static int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][n];

        int cnt = 1;
        int row = -1;
        int col = 0;
        for(int i = n; i >= 0; i-=3) {
            for(int k = 0; k < i; k++) arr[++row][col] = cnt++;
            for(int k = 0; k < i-1; k++) arr[row][++col] = cnt++;
            for(int k = 0; k < i-2; k++) arr[--row][--col] = cnt++;
        }

        int idx = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(arr[i][j] != 0) answer[idx++] = arr[i][j];

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5)));
    }
}
