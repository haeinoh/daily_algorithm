import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main505 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        String str = st.nextToken();

        Stack<Integer> s = new Stack<>();

        for(char x : str.toCharArray()) {

        }

        System.out.println(s.pop());
    }
}
