import java.util.Arrays;

public class Solution87390 {
    public static int[] solution(int n, long left, long right) {
        int[] arr = new int[(int) (right-left+1)];
        int idx = 0;
        while(left <= right) {
            arr[idx++] = (int) Math.max(left/n+1, left%n+1);
            left++;
        }
        return arr;
    }
    public static void main(String[] args) {
        int n = 4;
        long left = 7;
        long right = 14;
        System.out.println(Arrays.toString(solution(n, left, right)));
    }
}
