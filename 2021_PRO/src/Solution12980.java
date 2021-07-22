public class Solution12980 {
    public static int solution(int n) {
        int ans = 0;
        int pos = n;

        while(pos != 0) {
            if(pos % 2 == 0) pos /= 2;
            else {
                pos -= 1;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int s = 5000;
        System.out.println(solution(s));
    }
}
