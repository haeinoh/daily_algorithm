import java.util.Arrays;

public class Solution42862 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        for(int i = 0; i < lost.length; i++) {
            arr[lost[i] - 1] = 1;
        }

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = 0; i < reserve.length; i++) {
            if(arr[reserve[i]-1] == 1) {
                arr[reserve[i]-1] = 2;
                answer++;
            }
        }

        for(int i = 0; i < reserve.length; i++) {
            int val = reserve[i] - 1;
            if(arr[val] != 0) continue;
            if(val != 0 && arr[val-1] == 1) {
                arr[val-1] = 0;
                answer++;
            } else if(val != n-1 && arr[val+1] == 1) {
                arr[val+1] = 0;
                answer++;
            }
        }

        return n - lost.length + answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] l = {2, 3, 4, 1};
        int[] r = {3, 2};
        System.out.println(solution(n, l, r));
    }
}
