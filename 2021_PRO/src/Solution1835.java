public class Solution1835 {
    static String[] arr = {"A", "C", "F" , "J", "M", "N", "R", "T"};
    static String[] da;
    static boolean[] vtd;
    static int answer;

    static boolean check(String str) {
        for(int i = 0; i < da.length; i++) {
            String a = String.valueOf(da[i].charAt(0));
            String b = String.valueOf(da[i].charAt(2));
            String op = String.valueOf(da[i].charAt(3));
            int num = Character.getNumericValue(da[i].charAt(4));

            int cal = Math.abs(str.indexOf(a) - str.indexOf(b)) - 1;
            switch (op) {
                case "=":
                if(cal != num) return false;
                    break;
                case ">":
                    if(cal <= num) return false;
                    break;
                case "<":
                    if(cal >= num) return false;
                    break;
            }
        }

        return true;
    }
    static void solve(String str, int cnt) {
        if(cnt == arr.length) {
            if(check(str)) answer++;
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                solve(str+arr[i], cnt+1);
                vtd[i] = false;
            }
        }
    }
    static int solution(int n, String[] data) {
        answer = 0;
        vtd = new boolean[arr.length];
        da = data;
        solve("", 0);
        return answer;
    }

    public static void main(String[] args) {
        String[] d = {"N~F=0", "R~T>2"};
        int n = 2;

        System.out.println(solution(n, d));
    }
}
