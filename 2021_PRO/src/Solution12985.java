public class Solution12985 {
    static int solution(int n, int a, int b)
    {
        int answer = 0;
        while(a != b) {
            answer++;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(solution(n, a, b));
    }
}
