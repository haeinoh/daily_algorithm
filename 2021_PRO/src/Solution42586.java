import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution42586 {
    static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int prev = (int) Math.ceil((double)(100 - progresses[0]) / speeds[0]); // init
        int count = 1;
        for(int i = 1; i < progresses.length; i++) {
            int tmp = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            if(prev >= tmp) {
                count++;
            } else {
                prev = tmp;
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }

    public static void main(String[] args) {
        int[] p = {93, 30, 55};
        int[] s = {1, 30, 5};
        System.out.println(Arrays.toString(solution(p, s)));
    }
}
