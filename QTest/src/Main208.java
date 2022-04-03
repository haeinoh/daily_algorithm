import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main208 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[][] arr = new int[N][3];
        for(int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        int grade = 1;
        arr[0][2] = grade;
        int cnt = 0;
        for(int i = 1; i < N; i++) {
            if(arr[i-1][0] != arr[i][0]) {
                grade += cnt;
                arr[i][2] = ++grade;
                cnt = 0;
            } else {
                arr[i][2] = grade;
                cnt++;
            }
        }

        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i= 0; i < N; i++) sb.append(arr[i][2]).append(" ");

        System.out.println(sb.toString());
    }
}