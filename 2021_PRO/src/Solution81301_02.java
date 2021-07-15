public class Solution81301_02 {
    public static int solution(String s) {
        int answer = 0;
        String[] alpha = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < alpha.length; i++) {
            s = s.replaceAll(alpha[i], String.valueOf(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
    }
}
