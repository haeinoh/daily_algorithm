import java.util.Arrays;
import java.util.Scanner;

public class Main2535 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        int max = 0;
        for(int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
            max = Math.max(arr[i][0], max);
        }

        int[] cnt = new int[max+1];

        Arrays.sort(arr, (o1, o2) -> o2[2] - o1[2]);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(cnt[arr[i][0]] < 2) {
                sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
                cnt[arr[i][0]]++;
                count++;
            }
            if(count >= 3) break;
        }

        System.out.println(sb.toString());
    }
}
