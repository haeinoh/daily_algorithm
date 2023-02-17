import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main11637 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int ts = 1; ts <= T; ts++) {
            int n = sc.nextInt();
            int sum = 0;
            int[][] arr = new int[n][2];
            for(int i = 0; i < n; i++) {
                arr[i][0] = i+1;
                arr[i][1] = sc.nextInt();
                sum += arr[i][1];
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });

            if(arr[0][1] != arr[1][1]) {
                if(arr[0][1] > (sum/2)) System.out.println("majority winner " + arr[0][0]);
                else System.out.println("minority winner " + arr[0][0]);
            } else System.out.println("no winner");
        }
    }
}
