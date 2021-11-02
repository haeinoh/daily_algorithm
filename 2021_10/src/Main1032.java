import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken().trim());

        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine().trim());
            arr[i] = st.nextToken();
        }

        String answer = "";
        for(int i = 0; i < arr[0].length(); i++) {
            char comp = arr[0].charAt(i);
            boolean flag = false;
            for(int j = 1; j < N; j++) {
                if(arr[j].charAt(i) != comp) {
                    answer += "?";
                    flag = true;
                    break;
                }
            }
            if(!flag) answer += comp;
        }

        System.out.println(answer);
    }
}
