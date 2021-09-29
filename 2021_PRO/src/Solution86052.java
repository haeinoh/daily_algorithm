import java.util.ArrayList;
import java.util.Arrays;

public class Solution86052 {
    public static String[][] arr;
    public static ArrayList<Integer> answer;
    public static int[] dx = {-1, 0, 1, 0}; // up, left, down, right
    public static int[] dy = {0, -1 , 0, 1};

//    public static int direction(int x, int y, int cur) {
//
//
//    }
    public static int[] solution(String[] grid) {
        answer = new ArrayList<>();
        arr = new String[grid.length][grid[0].length()];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.valueOf(grid[i].charAt(j));
            }
        }




        int[] ans = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) ans[i] = answer.get(i);
        return ans;
    }
    public static void main(String[] args) {
        String[] g = {"SL","LR"};
        System.out.println(Arrays.toString(solution(g)));
    }
}
