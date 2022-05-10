import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main606 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] comp = arr.clone(); // deep copy
        Arrays.sort(comp);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < comp.length; i++) {
            if(arr[i] != comp[i]) sb.append(i+1).append(" ");
        }
        System.out.println(sb.toString());
    }
}
