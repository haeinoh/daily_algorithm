import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5698 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        loop:while(true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            if(str.equals("*")) break loop;
            char first = str.toLowerCase().charAt(0);
            boolean flag = false;
            while(st.hasMoreTokens()) {
                String val = st.nextToken();
                if(first != val.toLowerCase().charAt(0)) {
                    flag = true;
                    break;
                }
            }
            if(flag) System.out.println("N");
            else System.out.println("Y");
        }
    }
}
