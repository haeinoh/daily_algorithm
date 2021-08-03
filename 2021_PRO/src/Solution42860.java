public class Solution42860 {
    static int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        for(int i = 0; i < name.length(); i++) {
            // up & down
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i)+ 1);

            int idx = i+1;
            while(idx < name.length() && name.charAt(idx) == 'A') idx++;
            move = Math.min(move, i*2+name.length()-idx);
        }
        return answer + move;
    }
    public static void main(String[] args) {
        String name = "BAAAAABBB";
        System.out.println(solution(name));
    }
}
