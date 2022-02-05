import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1339_2 {
    public static int N, answer;
    public static int[] arr;
    public static String[] word;
    public static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        arr = new int[26];
        word = new String[N];
        set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine().trim());
            String str = st.nextToken();
            word[i] = str;
            int num = 1;
            for(int j = str.length()-1; j >= 0; j--) {
                arr[str.charAt(j)-65] += num;
                num *= 10;
            }
        }

        Arrays.sort(arr);
        int val = 9;
        for(int i = arr.length - 1; i >= 0; i--) {
            answer += arr[i] * val--;
        }

        System.out.println(answer);
    }
}
