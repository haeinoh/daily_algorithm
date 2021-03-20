
public class Solution12977 {
    public static boolean[] sosu, vtd;
    public static int answer;
    public static void calc() {
        sosu[0] = sosu[1] = true;
        for(int i = 2; i <= Math.sqrt(3000); i++) {
            if(sosu[i]) continue;
            for(int j = i; (i*j) <= 3000; j++) {
                sosu[i*j] = true;
            }
        }
    }

    public static void solve(int idx, int cnt, int sum, int[] nums) {
        if(cnt == 3) {
            if(!sosu[sum]) answer++;
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                solve(i, cnt+1, sum + nums[i], nums);
                vtd[i] = false;
            }
        }
    }
    public static int solution(int[] nums) {
        answer = 0;
        sosu = new boolean[3001];
        vtd = new boolean[nums.length];
        calc();

        solve(0, 0, 0, nums);

        return answer;
    }

    public static void main(String[] args) {
        int[] n = {1, 2, 7, 6, 4};
        System.out.println(solution(n));
    }
}
