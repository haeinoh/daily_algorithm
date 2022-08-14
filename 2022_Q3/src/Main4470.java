import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main4470 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(i).append(". ").append(bf.readLine()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
