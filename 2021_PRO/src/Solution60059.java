import java.util.*;

public class Solution60059 {
    public static int[][] arr;
    public static int count;
    public static int[][] rotate(int k, int[][] key) {
        if(k == 0) return key;
        int[][] tmp = new int[key[0].length][key.length];
        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key[i].length; j++) {
                tmp[j][key.length-i-1] = key[i][j];
            }
        }
        return tmp;
    }
    public static boolean solve(int x, int y, int[][] key, int[][] arr) {
        int cnt = 0;
        for(int i = x; i < key.length+x; i++) {
            for(int j = y; j < key.length+y; j++) {
                if(arr[i][j] == 0 && key[i-x][j-y] == 1) cnt++;
                if(arr[i][j] == 1 && key[i-x][j-y] == 1) return false;
            }
        }
        return (count == cnt);
    }
    public static boolean solution(int[][] key, int[][] lock) {
        count = 0;
        // key배열 *2 + (자물쇠배열 - 2) 크기의 배열을 만든다
        int len = key.length*2+(lock.length-2);
        arr = new int[len][len];
        // start : key배열크기 - 1
        int x = 0;
        int y = 0;
        for(int[] p: arr) Arrays.fill(p, -1);
        for(int i = key.length-1; i < lock.length+key.length-1; i++) {
            for(int j = key.length-1; j < lock.length+key.length-1; j++) {
                arr[i][j] = lock[x][y];
                if(arr[i][j] == 0) count++;
                y++;
            }
            x++;
            y = 0;
        }


        for(int k = 0; k < 4; k++) {
            key = rotate(k, key);
            for(int i = 0; i <= arr.length-key.length; i++) {
                for(int j = 0; j <= arr[i].length-key[0].length; j++) {
                    if(solve(i, j, key, arr)) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        int[][] key = {{0, 1},{0, 1}};
//        int[][] lock = {{0, 0},{1, 1}};
        System.out.println(solution(key, lock));
    }
}
