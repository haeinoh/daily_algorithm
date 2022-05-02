import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main403 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < K; i++) {
            map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
        }
        sb.append(map.size()).append(" ");

        for(int i = 1; i <= N-K; i++) {
            map.put(arr[i-1], map.get(arr[i-1])-1);
            if(map.get(arr[i-1]) == 0) map.remove(arr[i-1]);
            map.put(arr[i+K-1], map.getOrDefault(arr[i+K-1], 0) + 1);
            sb.append(map.size()).append(" ");
        }

        System.out.println(sb.toString());
    }
}
