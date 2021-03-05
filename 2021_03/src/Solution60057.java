//https://programmers.co.kr/learn/courses/30/lessons/60057
public class Solution60057 {
    public static int solution(String s) {
        int answer = s.length();
        for(int i = 1; i <= s.length()/2; i++) {
            int sum = 0;
            int count = 0;
            for(int j = 0; j <= s.length() - i; j+=count*i) {
                String str = s.substring(j, j+i);
                count = 1;
                for(int k = j+i; k <= s.length() - i; k+=i) {
                    String comp = s.substring(k, k+i);
                    if(str.equals(comp)) count++;
                    else break;
                }
                sum += ((count == 1) ? 0 : (String.valueOf(count).length())) + str.length();
            }
            sum += s.length() % i;
            answer = Math.min(sum, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        System.out.println(solution(s));
    }
}
