import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution43163 {
    static int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0;
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        boolean[] vtd = new boolean[words.length];
        q.add(begin);
        loop:while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                String tmp = q.poll();
                if(tmp.equals(target)) break loop;
                for(int i = 0; i < words.length; i++) {
                    int count = 0;
                    if(!vtd[i]) {
                        for(int k = 0; k < words[i].length(); k++) {
                            if(tmp.charAt(k) != words[i].charAt(k)) {
                                count++;
                            }
                        }
                        if(count == 1) {
                            q.add(words[i]);
                            vtd[i] = true;
                        }
                    }
                }
                size--;
            }
            answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        String b = "hit";
        String t = "cog";
        String[] w = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(b, t, w));
    }
}
