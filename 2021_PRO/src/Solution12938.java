import java.util.Arrays;

public class Solution12938 {
    static int[] solution(int n, int s) {
        if(s-n < 0) return new int[]{-1};
        int[] answer = new int[n];
        int mod = s % n;
        for(int i = n-1; i >= 0; i--) {
            answer[i] += (s/n);
            if(mod > 0) {
                answer[i]++;
                mod--;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int n = 2;
        int s = 9;
        System.out.println(Arrays.toString(solution(n, s)));
    }
}
