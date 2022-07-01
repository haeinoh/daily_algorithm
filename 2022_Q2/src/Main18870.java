import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sorting = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            sorting[i] = arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorting);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        map.put(sorting[0], rank);
        for(int i = 1; i < sorting.length; i++) {
            if(sorting[i] != sorting[i-1]) {
                rank++;
                map.put(sorting[i], rank);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb.toString());
    }
}
