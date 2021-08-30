import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution84512 {
    static String[] arr = {"A", "E", "I", "O", "U"};
    static List<String> list;
    static void solve(int cnt, int limit, String tmp) {
        if(cnt == limit) {
            list.add(tmp);
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            solve(cnt+1, limit,tmp+arr[i]);
        }
    }
    static int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        for(int i = 1; i <= arr.length; i++) solve(0, i, "");
        Collections.sort(list);
        return list.indexOf(word) + 1;
    }

    public static void main(String[] args) {
       String w = "AAAA";
        System.out.println(solution(w));
    }
}
