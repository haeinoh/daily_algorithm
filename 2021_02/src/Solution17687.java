//https://programmers.co.kr/learn/courses/30/lessons/17687
import java.util.ArrayList;

public class Solution17687 {
    public static ArrayList<String> list;
    public static String nu[] = {"A", "B", "C", "D", "E", "F"};
    public static void make(int jinbub, int done) {
        list.add("0");
        loop:
        for (int i = 1; i < done; i++) {
            int num = i;
            String tmp = "";
            while (num > 0) {
                int re = num % jinbub;
                if(re >= 10) tmp = nu[re-10] + tmp;
                else tmp = re + tmp;
                num /= jinbub;
            }
            for (int k = 0; k < tmp.length(); k++) {
                list.add(String.valueOf(tmp.charAt(k)));
                if (list.size() >= done) break loop;
            }
        }
    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        list = new ArrayList<>();
        make(n, (t - 1) * m + p);
        for (int i = p - 1; i < list.size(); i += m) {
            answer += list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 8; // 진법
        int t = 100; // 미리 구할 숫자의 갯수
        int m = 20; // 게임에 참가하는 인원
        int p = 3; // 튜브의 순서
        System.out.println(solution(n, t, m, p));
    }
}
