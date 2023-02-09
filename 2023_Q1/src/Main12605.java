import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb  = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            String[] arr = bf.readLine().split(" ");
            sb.append("Case #").append(i).append(": ");
            for(int j = arr.length - 1; j >= 0; j--) sb.append(arr[j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
