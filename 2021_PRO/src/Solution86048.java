import java.util.ArrayList;
import java.util.Arrays;

public class Solution86048 {
    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < leave.length; i++) {
            for(int j = idx; j < enter.length; j++) {
                if(answer[leave[i]-1] > 0) break;
                list.add(enter[j]);
                idx++;
                if(enter[j] == leave[i]) {
                    break;
                }
            }
            list.remove(Integer.valueOf(leave[i]));
            for(int j = 0; j < list.size(); j++) {
                answer[list.get(j) - 1]++;
            }
            answer[leave[i] - 1] += list.size();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] e = {1, 4, 2, 3};
        int[] l = {2, 1, 3, 4};
        System.out.println(Arrays.toString(solution(e, l)));
    }
}
