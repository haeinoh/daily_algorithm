import java.util.*;
public class Solution68936 {
    static int zero, one;
    static void solve(int size, int x, int y, int[][] arr) {
        if(size == 1) {
            if(arr[x][y] == 0)zero++;
            else one++;
            return;
        }

        if(check(size, x,  y, arr)) {
            return;
        }
        solve(size/2, x, y, arr);
        solve(size/2, x, y+size/2, arr);
        solve(size/2, x+size/2, y, arr);
        solve(size/2, x+size/2, y+size/2, arr);
    }

    static boolean check(int size, int x, int y, int[][] arr) {
        int num = arr[x][y];
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(arr[i][j] != num) return false;
            }
        }

        if(num == 0) zero++;
        else one++;
        return true;
    }
    static int[] solution(int[][] arr) {
        zero = 0;
        one = 0;
        solve(arr.length, 0, 0, arr);

        return new int[]{zero, one};
    }
    public static void main(String[] args) {
        int[][] a = {
                {1,1,0,0},
                {1,0,0,0},
                {1,0,0,1},
                {1,1,1,1}
        };
        System.out.println(Arrays.toString(solution(a)));
    }
}
