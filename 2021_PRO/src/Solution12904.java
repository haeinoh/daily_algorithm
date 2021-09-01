public class Solution12904 {
    static int solution(String s) {
        for(int len = s.length(); len > 0; len--) {
            for(int left = 0; left < s.length()-len+1; left++) {
                int l = left;
                int r = len - 1 + left;
                boolean flag = false;
                while(l < r) {
                    if(s.charAt(l) != s.charAt(r)) {
                        flag = true;
                        break;
                    }
                    l++;
                    r--;
                }
                if(!flag) return len;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String s = "dbdadb";
        System.out.println(solution(s));
    }
}
