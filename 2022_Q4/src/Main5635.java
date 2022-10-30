import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main5635 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] name = new String[n];
        int[][] arr = new int[n][4];

        for(int i = 0; i < n; i++) {
            name[i] = sc.next();
            arr[i][0] = i;
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
            arr[i][3] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[3] == o2[3]) return o1[2] - o2[2];
                else if(o1[2] == o2[2]) return o2[1] - o2[1];
                return o1[3] - o2[3];
            }
        });

        System.out.println(name[arr[n-1][0]]);
        System.out.println(name[arr[0][0]]);
    }
}
