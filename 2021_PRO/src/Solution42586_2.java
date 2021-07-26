import java.util.*;

public class Solution42586_2 {
    static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            q.add((int)Math.ceil((double) (100 - progresses[i])/speeds[i]));
        }
        List<Integer> list = new ArrayList<>();

        if(!q.isEmpty()) {
            int prev = q.poll();
            int count = 1;
            while (!q.isEmpty()) {
                int cur = q.poll();
                if (prev >= cur) {
                    count++;
                } else {
                    list.add(count);
                    prev = cur;
                    count = 1;
                }
            }
            list.add(count);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] p = {93, 30, 55};
        int[] s = {1, 30, 5};
        System.out.println(Arrays.toString(solution(p, s)));
    }
}
