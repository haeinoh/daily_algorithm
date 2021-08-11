import java.util.*;

public class Solution42628 {
    static int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < operations.length; i++) {
            String key = operations[i].split(" ")[0];
            int value = Integer.parseInt(operations[i].split(" ")[1]);
            if(key.equals("I")) {
                pq.add(value);
            } else {
                if(!pq.isEmpty()) {
                    if(value == 1)pq.remove(pq.stream().mapToInt(x -> x).max().getAsInt());
                    else pq.poll();
                }
            }
        }
        if(pq.size() == 0) return new int[]{0, 0};
        return new int[]{pq.stream().mapToInt(x -> x).max().getAsInt(), pq.peek()};
    }

    public static void main(String[] args) {
        String[] o = {"I 4", "I -4", "I -1", "I 6", "I 3"};
        System.out.println(Arrays.toString(solution(o)));
    }
}
