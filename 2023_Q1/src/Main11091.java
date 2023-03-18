import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11091 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int[] arr =  new int[26];
            String str = bf.readLine().toLowerCase();

            for(int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if(ch >= 'a' && ch <= 'z') arr[(int)ch-'0'-49]++;
            }

            String ans = "";
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == 0) ans += (char)(j + '0' + 49);
            }

            if(ans.equals("")) sb.append("pangram");
            else sb.append("missing ").append(ans);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
