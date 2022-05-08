import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main604 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken()); // cache size
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        LinkedList list = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            int value  = Integer.parseInt(st.nextToken());

            if(list.contains(value)) {
                list.removeFirstOccurrence(value);
                list.addFirst(value);
            } else if(list.size() == S) {
                list.removeLast();
                list.addFirst(value);
            } else {
                list.addFirst(value);
            }
//            System.out.println(value +  " " + list.toString());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) sb.append(list.get(i)).append(" ");
        System.out.println(sb.toString());
    }
}
