import java.io.*;
import java.util.StringTokenizer;

public class Main1244 {
    public static int[] arr;
    public static void turnonoff(int index) {
        int p = 1;
        for(int i = index; i < arr.length; i=index*p) {
            arr[i] = (arr[i] == 0 ? 1 : 0);
            p++;
        }
    }

    public static void symmetry(int index) {
        int left = index - 1;
        int right = index + 1;
        int min = Math.min(index-1, arr.length - 1 - index);
        while(min > 0) {
            if(arr[left] != arr[right]) break;
            arr[left] = arr[left] == 0 ? 1 : 0;
            arr[right] = arr[right] == 0 ? 1 : 0;
            left--;
            right++;
            min--;
        }
        arr[index] = arr[index] == 0 ? 1 : 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken().trim());
        arr = new int[N+1];

        st = new StringTokenizer(bf.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine().trim());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            if(gender == 1) turnonoff(index);
            else symmetry(index);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 1; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
            count++;
            if(count % 20 == 0) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
