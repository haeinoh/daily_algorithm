import java.util.Arrays;

public class Solution77484 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int count = 0;
        int zero = 0;
        for(int j = 0; j < lottos.length; j++) {
            for(int i = 0; i < win_nums.length; i++) {
                if(lottos[j] == win_nums[i]) {
                    count++;
                    break;
                }
                if(lottos[j] == 0) {
                    zero++;
                    break;
                }
            }
        }
        answer[0] = count;
        zero = answer[0] + zero;

        if(count == 2) answer[1] = 5;
        else if(count == 3) answer[1] = 4;
        else if(count == 4) answer[1] = 3;
        else if(count == 5) answer[1] = 2;
        else if(count == 6) answer[1] = 1;
        else answer[1] = 6;


        if(zero == 2) answer[0] = 5;
        else if(zero == 3) answer[0] = 4;
        else if(zero == 4) answer[0] = 3;
        else if(zero == 5) answer[0] = 2;
        else if(zero == 6) answer[0] = 1;
        else answer[0] = 6;

        return answer;
    }
    public static void main(String[] args) {
        int[] l = {44, 1, 0, 0, 31, 25};
        int[] w = {31, 10, 45, 1, 6, 19};
        int[] ans = solution(l, w);
        System.out.println(Arrays.toString(ans));
    }
}
