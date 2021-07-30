public class Solution12945_2 { // recursion
    static int solve(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 1;

        return ((solve(n-1) % 1234567) + (solve(n-2) % 1234567)) % 1234567;
    }
    static int solution(int n) {
        return solve(n);
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(solution(n));
    }
}
