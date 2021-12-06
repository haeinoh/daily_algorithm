import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int K = Integer.parseInt(st.nextToken());
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int val = Integer.parseInt(st.nextToken());
            if(!s.isEmpty() && val == 0) s.pop();
            else s.push(val);
        }
        int sum = 0;
        while(!s.isEmpty()) sum += s.pop();
        System.out.println(sum);
    }
}
