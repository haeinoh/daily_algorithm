import java.util.HashSet;

public class Solution42839 {
    public static String[] arr;
    public static boolean[] vtd;
    public static int answer;
    public static HashSet<Integer> set;
    static boolean prime(int num) {
        if(num == 0 || num == 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    static void solve(String tmp, int cnt) {
        if(cnt == tmp.length()) {
            int num = Integer.parseInt(tmp);
            if(!set.contains(num)) {
                set.add(num);
                if(prime(num)) answer++;
            }
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                solve(tmp + arr[i], cnt);
                solve(tmp + arr[i], cnt+1);
                vtd[i] = false;
            }
        }
    }
    static int solution(String numbers) {
        answer = 0;
        set = new HashSet<>();
        arr = new String[numbers.length()];
        for(int i = 0; i < numbers.length(); i++) arr[i] = String.valueOf(numbers.charAt(i));

        vtd = new boolean[numbers.length()];

        solve("", 1);
        return answer;
    }

    public static void main(String[] args) {
        String n = "011";
        System.out.println(solution(n));
    }
}
