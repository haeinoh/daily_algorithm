//https://programmers.co.kr/learn/courses/30/lessons/64065
import java.util.*;
import java.util.Map.Entry;

public class Solution64065 {
    public static int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>(); // 나온 숫자들 카운트 저장하는 map
        s = s.replace("{", "").replace("}", ""); // '{' 와 '}' 제거
        String[] tmp = s.split(",");
        for (String p : tmp) {
            if (map.containsKey(p)) map.put(p, map.get(p) + 1);
            else map.put(p, 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet()); // 정렬
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int[] answer = new int[Collections.max(map.values())];
        int idx = 0;
        for(Entry<String, Integer> m: list) {
            answer[idx++] = Integer.parseInt(m.getKey());
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//        String s = "{{123}}";
        System.out.println(Arrays.toString(solution(s)));
    }
}
