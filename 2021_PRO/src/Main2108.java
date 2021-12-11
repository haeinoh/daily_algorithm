import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        Arrays.sort(arr);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        List<Integer> tmp = new ArrayList<>();
        int max = Collections.max(map.values());

        for(Map.Entry<Integer, Integer> m: list) {
            if(m.getValue().equals(max)) tmp.add(m.getKey());
        }
        Collections.sort(tmp);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%.0f", (sum/(float)N))).append("\n");
        sb.append(arr[N/2]).append("\n");
        if(tmp.size() > 1) sb.append(tmp.get(1)).append("\n");
        else sb.append(tmp.get(0)).append("\n");
        sb.append(arr[N-1]-arr[0]).append("\n");
        System.out.println(sb.toString());
    }
}