import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1181_Buffered {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int  compare(String o1, String o2) {
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append("\n");
        for(int i = 1; i < arr.length; i++) {
            if(arr[i].equals(arr[i-1])) continue;
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
