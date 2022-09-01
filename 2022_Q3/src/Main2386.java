import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2386 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = bf.readLine();
            if(str.equals("#")) break;
            StringTokenizer st = new StringTokenizer(str);
            String value = st.nextToken();
            int cnt = 0;
            while(st.hasMoreTokens()) {
                String tmp = st.nextToken().toLowerCase();
                for(int i = 0; i < tmp.length(); i++) {
                    if(value.equals(String.valueOf(tmp.charAt(i)))) cnt++;
                }
            }
            System.out.println(value + " " + cnt);
        }

    }
}
