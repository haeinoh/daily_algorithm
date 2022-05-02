import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main402 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str1 = st.nextToken();
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char ch : str1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        st = new StringTokenizer(bf.readLine());
        String str2 = st.nextToken();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(char ch : str2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        boolean flag = true;
        if(map1.size() == map2.size()) {
            for(char key: map1.keySet()) {
                if(map2.containsKey(key) && Objects.equals(map2.get(key), map1.get(key))) continue;
                else {
                    flag = false;
                    break;
                }
            }

        } else flag = false;

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
