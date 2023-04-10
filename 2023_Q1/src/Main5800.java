import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());


        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append("Class ").append(i).append("\n");
            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));

            Collections.sort(list);
            sb.append("Max ").append(list.get(list.size() -1));
            sb.append(", Min ").append(list.get(0));
            sb.append(", Largest gap ");
            int max = 0;
            for(int j = 0; j < list.size() - 1; j++) max = Math.max(max, list.get(j+1) - list.get(j));
            sb.append(max).append("\n");
        }
        System.out.println(sb.toString());
    }
}
