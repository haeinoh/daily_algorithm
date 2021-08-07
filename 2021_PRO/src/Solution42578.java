import java.util.*;

public class Solution42578 {
    static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for(Map.Entry<String, Integer> m: map.entrySet()) {
            answer *= (m.getValue()+1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] c = {
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"},
                {"green_turban1", "shirts"},
                {"green_turban2", "shirts"},
                {"green_turban3", "shirts"}
        };
        System.out.println(solution(c));
    }
}
