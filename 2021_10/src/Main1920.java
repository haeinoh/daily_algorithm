import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < M; i++) {
            if(set.contains(Integer.parseInt(st.nextToken()))) System.out.println("1");
            else System.out.println("0");
        }
    }
}
