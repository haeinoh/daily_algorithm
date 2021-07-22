import java.util.Arrays;
import java.util.HashSet;

public class Solution12981 {
    public static int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
            if(set.contains(words[i])) {
                return new int[]{i%n+1, i/n+1};
            } else {
                if(i > 0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) return new int[]{i%n+1, i/n+1};
                set.add(words[i]);
            }
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int n = 2;
        String[] w = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(solution(n, w)));
    }
}
