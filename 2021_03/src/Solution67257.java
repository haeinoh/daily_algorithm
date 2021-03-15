//https://programmers.co.kr/learn/courses/30/lessons/67257
import java.util.ArrayList;

public class Solution67257 {
    public static long answer;
    public static int[] order;
    public static boolean[] vtd;
    public static ArrayList<String> list;
    public static String[] dir = {"*", "+", "-"};
    public static void solve(int[] order) {
        ArrayList<String> temp = new ArrayList<>(list);
        for (int value : order) { // 만들 수 있는 기호의 조합 순서대로
            for (int j = 0; j < temp.size(); j++) {
                if (temp.get(j).equals(dir[value])) { // 우선순위에 있는 기호를 만나게 되면 기호 기준 전과 후의 값으로 계산
                    long tmp = 0;
                    switch (dir[value]) {
                        case "*":
                            tmp = Long.parseLong(temp.get(j - 1)) * Long.parseLong(temp.get(j + 1));
                            break;
                        case "-":
                            tmp = Long.parseLong(temp.get(j - 1)) - Long.parseLong(temp.get(j + 1));
                            break;
                        case "+":
                            tmp = Long.parseLong(temp.get(j - 1)) + Long.parseLong(temp.get(j + 1));
                            break;
                    }
                    for (int k = 0; k < 3; k++) {
                        temp.remove(j - 1);
                    }
                    temp.add(j - 1, String.valueOf(tmp));
                    j = 0;
                }
            }
        }
        answer = Math.max(answer, Math.abs(Long.parseLong(temp.get(0))));
    }

    public static void comb(int cnt) { // 기호로 만들어 낼 수 있는 모든 조합 (3!)
        if(cnt == dir.length) {
            solve(order);
            return;
        }

        for(int i = 0; i < dir.length; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                order[cnt] = i;
                comb(cnt+1);
                vtd[i] = false;
            }
        }
    }
    public static long solution(String expression) {
        answer = 0;
        list = new ArrayList<>();
        String str = "";
        vtd = new boolean[3];
        for(int i = 0; i < expression.length(); i++) { // 숫자와 기호 분리해서 arraylist에 추
            if(expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                list.add(str);
                list.add(String.valueOf(expression.charAt(i)));
                str = "";
            } else {
                str += expression.charAt(i);
            }
        }
        order = new int[3];
        list.add(str);
        comb(0);
        return answer;
    }

    public static void main(String[] args) {
        String s = "100-200*300-500+20";
        System.out.println(solution(s));
    }
}
