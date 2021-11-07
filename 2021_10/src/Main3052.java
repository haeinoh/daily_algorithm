import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main3052 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            set.add(Integer.parseInt(st.nextToken())%42);
        }
        System.out.println(set.size());
    }
}
