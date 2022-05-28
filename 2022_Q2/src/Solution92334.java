import java.util.*;
import java.util.stream.Collectors;

public class Solution92334 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<String> ans = new ArrayList<String>(List.of(id_list));
        //distinct
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for(String x : list) {
            String target = x.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        for(int i = 0; i < list.size(); i++) {
            String src = list.get(i).split(" ")[0];
            String tar = list.get(i).split(" ")[1];
            if(count.containsKey(tar) && count.get(tar) >= k) answer[ans.indexOf(src)]++;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id = {"muzi", "frodo", "apeach", "neo"};
        String[] r = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id, r, k)));
    }
}
