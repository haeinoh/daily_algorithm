public class Solution62048 {
    public static long solution(int w, int h) {
        long answer = 0;
        long wl = Long.parseLong(String.valueOf(w));
        long hl = Long.parseLong(String.valueOf(h));
        answer = (wl + hl) - gcd(wl, hl);

        return (wl * hl) - answer;
    }

    public static long gcd(long min, long max) {
        if(min > max) {
            long tmp = min;
            min = max;
            max = tmp;
        }

        while(min != 0) { // 유클리드 알고리즘, min값이 0이 될때까지 (max % min)을 돌고, min이 0이 되면 max값을 gcd로 판단한다.
            long tmp = max % min;
            max = min;
            min = tmp;
        }
        return max;
    }

    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(solution(w, h));
    }
}
