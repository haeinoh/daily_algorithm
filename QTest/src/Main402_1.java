import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main402_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str1 = st.nextToken();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        st = new StringTokenizer(bf.readLine());
        String str2 = st.nextToken();

        boolean flag = true;
        for(char ch :  str2.toCharArray()) {
            if(!map.containsKey(ch) || map.get(ch) == 0) {
                flag = false;
                break;
            } else map.put(ch, map.get(ch) - 1);
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
