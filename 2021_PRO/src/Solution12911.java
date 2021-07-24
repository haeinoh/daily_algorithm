public class Solution12911 {
    public static int solution(int n) {
        int bin = Integer.bitCount(n);
        for(int i = n+1; ;i++) {
            int answer = Integer.bitCount(i);
            if(answer == bin) return i;
        }
    }

    public static void main(String[] args) {
        int n = 78;
        System.out.println(solution(n));
    }
}
