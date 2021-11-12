import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) sb.append(list.get(i)).append("\n");
        System.out.println(sb.toString());
    }
}
