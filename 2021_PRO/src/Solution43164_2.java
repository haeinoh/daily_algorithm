import java.util.Arrays;

public class Solution43164_2 {
    static String answer;
    static boolean[] vtd;
    static void solve(int count, String word, String res, String[][] t) {
        if(count == t.length) {
            if(answer.length() == 0) answer = res;
            else if(answer.compareTo(res) > 0) answer = res;
            return;
        }

        for(int i = 0; i < t.length; i++) {
            if(!vtd[i] && t[i][0].equals(word)) {
                vtd[i] = true;
                solve(count+1, t[i][1], res + " " + t[i][1], t);
                vtd[i] = false;
            }
        }
    }
    static String[] solution(String[][] tickets) {
        answer = "";
        vtd = new boolean[tickets.length];
        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals("ICN")) {
                vtd[i] = true;
                solve(1, tickets[i][1], "ICN " + tickets[i][1], tickets);
                vtd[i] = false;
            }
        }

        return answer.split(" ");
    }

    public static void main(String[] args) {
        String[][] t = {
                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}
        };
        System.out.println(Arrays.toString(solution(t)));
    }
}
