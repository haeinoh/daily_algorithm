import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main401 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        HashMap<Character, Integer> map = new HashMap<>();
        // char x : s.toCharArray()
        for(int i = 0; i < N; i++) {
            Character ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        char ans = 0;
//        for(char key : map.keySet()) {
//            if(map.get(key) > max) {
//                max = map.get(key);
//                ans = key;
//            }
//        }
        for(Map.Entry<Character, Integer> m : map.entrySet()) {
            if(m.getValue() > max) {
                max = m.getValue();
                ans = m.getKey();
            }
        }

        System.out.println(ans);
    }
}
