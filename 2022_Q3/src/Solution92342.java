import java.util.Arrays;

public class Solution92342 {
    public static int[] answer;
    public static int max;
    public static int calc(int[] info, int[] ry) {
        int apeach = 0;
        int ryan = 0;
        for(int i = 0; i <= 10; i++) {
            if(info[i] == 0 && ry[i] == 0) continue;
            if(info[i] >= ry[i]) apeach += (10-i);
            else ryan += (10-i);
        }
        if(apeach < ryan) return (ryan - apeach);

        return -1;
    }
    public static void solve(int n, int[] info, int idx, int[] tmp, int count) {
        if(n == count) {
            int val = calc(info, tmp);
            if(val > max) {
                answer = tmp.clone();
                max = val;
            }
            return;
        }

        for(int i = idx; i >= 0; i--) {
            tmp[i]++;
            solve(n, info, i, tmp,count+1);
            tmp[i]--;
        }

    }
    public static int[] solution(int n, int[] info) {
        answer = new int[info.length];
        int[] tmp = new int[info.length];
        max = -1;

        solve(n, info, 10, tmp, 0);
        int cnt = 0;
        for(int i = 0; i <= 10; i++) if(answer[i] == 0) cnt++;

        int[] temp = new int[1];
        temp[0] = -1;
        if(cnt == 11) return temp;
        else return answer;
    }
    public static void main(String[] args) {
        int n = 9;
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        System.out.println(Arrays.toString(solution(n, info)));
    }
}
