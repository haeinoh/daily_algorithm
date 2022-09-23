import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5704 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        loop:while(true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int[] arr = new int[26];
            while(st.hasMoreTokens()) {
                String str = st.nextToken();
                if(str.equals("*")) break loop;
                for(int i = 0; i < str.length(); i++) {
                    if(str.charAt(i) == ' ') continue;
                    arr[str.charAt(i) - 97]++;
                }
            }
            boolean flag = false;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == 0) {
                    flag = true;
                    break;
                }
            }
            if(flag) System.out.println("N");
            else System.out.println("Y");
        }
    }
}
