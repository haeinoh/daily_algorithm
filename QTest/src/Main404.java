import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main404 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String S = st.nextToken();

        st = new StringTokenizer(bf.readLine());
        String T = st.nextToken();

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> sarr = new HashMap<>();
        for(char x : T.toCharArray()) {
            sarr.put(x, sarr.getOrDefault(x, 0) + 1);
        }

        for(int i = 0; i < T.length(); i++) {
            char ch = S.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int count = 0;

        while(left < S.length()) {
            if(map.equals(sarr)) count++;
            if(left+T.length() == S.length()) break;
            char key = S.charAt(left + T.length());
            left++;
        }

        System.out.println(count);
    }
}