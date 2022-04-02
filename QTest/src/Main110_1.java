import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main110_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        char target = st.nextToken().toString().charAt(0);
        int[] arr = new int[str.length()];
        int idx = 1000;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == target) {
                idx = 0;
                arr[i] = 0;
            } else {
                idx++;
                arr[i] = idx;
            }
        }
        idx = 1000;
        for(int i = str.length() - 1; i >=0; i--) {
            if(str.charAt(i) == target) idx = 0;
            else {
                idx++;
                arr[i] = Math.min(arr[i], idx);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) sb.append(arr[i]).append(" ");
        System.out.println(sb.toString());
    }
}
