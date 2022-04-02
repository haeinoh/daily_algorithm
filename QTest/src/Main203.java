import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main203 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] brr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int j = 0; j  < N; j++) {
            brr[j] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            switch(arr[i]) {
                case 1:
                    if(brr[i] == 1) sb.append("D").append("\n");
                    else if(brr[i] == 2) sb.append("B").append("\n");
                    else sb.append("A").append("\n");
                    break;
                case 2:
                    if(brr[i] == 1) sb.append("A").append("\n");
                    else if(brr[i] == 2) sb.append("D").append("\n");
                    else sb.append("B").append("\n");
                    break;
                case 3:
                    if(brr[i] == 1) sb.append("B").append("\n");
                    else if(brr[i] == 2) sb.append("A").append("\n");
                    else sb.append("D").append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
