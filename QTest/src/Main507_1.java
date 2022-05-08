import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main507_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String mandatory = st.nextToken();

        st = new StringTokenizer(bf.readLine());
        String subject = st.nextToken();

        boolean flag = true;
        Queue<Character> q = new LinkedList<>();
        for(char x : mandatory.toCharArray()) q.offer(x);
        for(char x : subject.toCharArray()) {
            if(q.contains(x)) {
                if(x != q.poll()) {
                    flag = false;
                    break;
                }
            }
        }
        if(!q.isEmpty()) flag = false;

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
