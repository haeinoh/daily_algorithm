import java.util.Arrays;

public class Solution87946 {
    public static int answer;
    public static boolean[] vtd;
    public static void solve(int cnt, int[][] dungeons, int k) {
        for(int i = 0; i < vtd.length; i++) {
            if(!vtd[i] && k >= dungeons[i][0]) {
                vtd[i] = true;
                solve(cnt+1, dungeons, k - dungeons[i][1]);
                vtd[i] = false;
            }
        }
        answer = Math.max(answer, cnt);
    }
    public static int solution(int k, int[][] dungeons) {
        answer = 0;
        vtd = new boolean[dungeons.length];

        solve(0, dungeons, k);

        return answer;
    }
    public static void main(String[] args) {
        int k = 80;
        int[][] d = {{80,20},{50,40},{30,10}};
        System.out.println(solution(k, d));
    }
}
