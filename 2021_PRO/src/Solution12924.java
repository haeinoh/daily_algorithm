public class Solution12924 {
    public static int solution(int n) {
        int answer = 0;

        for(int i = 1; i < n; i++) {
            int sum = i;
            for(int j = i+1; j < n; j++) {
                sum += j;
                if(sum == n) answer++;
                if(sum >= n) break;
            }
        }

        return answer+1;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
