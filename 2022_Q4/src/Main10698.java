import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10698 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i ++){
            String[] arr = bf.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[2]);
            int c = Integer.parseInt(arr[4]);

            String op = arr[1];
            sb.append("Case ").append(i+1).append(": ");
            if(op.equals("+")) {
                if(a + b == c) sb.append("YES");
                else sb.append("NO");
            } else {
                if(a - b == c) sb.append("YES");
                else sb.append("NO");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
