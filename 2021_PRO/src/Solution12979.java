public class Solution12979 {

    static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        for (int station : stations) {
//            answer += Math.ceil(((station - w - start) / (double)((w*2) + 1)));
            int val = station - w - start;
            if(val > 0) {
                int res = val / (2 * w + 1);
                answer += (val % (2 * w + 1)) == 0 ? res : res + 1;
            }
            start = station + w + 1;
        }
        if(start <= n){
            int val = n - start + 1;
            int res = val / (2*w+1);
            if(n == start) answer++; // 끝
            else answer += (val % (2*w+1)) == 0 ? res : res + 1;
//            else answer += ((n - start + 1) % ((w*2) + 1)) == 0 ? ((n - start + 1) / ((w*2) + 1)) :  ((n - start + 1) / ((w*2) + 1)) + 1;
//            else answer += Math.ceil(((n - start + 1) / (double)((w*2) + 1)));
        }

        return answer;
    }
    public static void main(String[] args) {
        int n = 11;
        int[] s = {4, 11};
        int w = 1;
//        int n = 16;
//        int[] s = {9};
//        int w = 2;
        System.out.println(solution(n, s, w));
    }
}
