import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1193_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int X = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int num = 1; // 카운트

        while(X > num) {
            X -= num++;
        }
        if(num % 2 == 0) {
            sb.append(X).append("/").append(num+1-X);
        } else {
            sb.append(num+1-X).append("/").append(X);
        }


        System.out.println(sb.toString());
    }
}
