public class Solution68935 {

    public static int solution(int n) {
        String str = "";
        while(n > 0) {
            str = str + String.valueOf(n%3);
            n /= 3;
        }

        return Integer.parseInt(str, 3);
    }

    public static void main(String[] args) {
        int n = 125;
        System.out.println(solution(n));
    }
}
