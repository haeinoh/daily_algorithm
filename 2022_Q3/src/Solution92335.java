import java.util.ArrayList;

public class Solution92335 {
    public static int solution(int n, int k) {
        int answer = 0;
        String str = "";

        if(k != 10) {
            while(n > 0) {
                str = (n % k) + str;
                n /= k;
            }
        } else str = String.valueOf(n);

        String tmp = "";
        ArrayList<Long> list = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                if(!tmp.equals("")) list.add(Long.parseLong(tmp));
                tmp = "";
            } else {
                tmp += str.charAt(i);
            }
            if(i == str.length() - 1 && !tmp.equals("")) list.add(Long.parseLong(tmp));
        }
        if(list.size() == 0) return 0;

        System.out.println(list.toString());

        for(int i = 0; i < list.size(); i++) {
            boolean prime = false;
            if(list.get(i) < 2) continue;
            for(long j = 2; j <= Math.sqrt(list.get(i)); j++) {
                if(list.get(i) % j == 0) {
                    prime = true;
                    break;
                }
            }
            if(!prime) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }
}
