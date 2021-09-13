import java.util.HashSet;

public class Solution77664 {
    static int check(int num) {
        if(num == 1) return 1;
        if(num == 2) return 2;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= num/2; i++) {
            if(num % i == 0) {
                set.add(i);
                set.add(num/i);
            }
        }
        return set.size();
    }
    static int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
            if(check(i) % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(13, 17));
    }
}
