import java.util.Arrays;
import java.util.Scanner;

public class Main5217 {
    public static StringBuilder sb;
    public static boolean[] vtd;
    public static int[] arr;
    public static void solve(int idx, int cnt, int value, boolean flag) {
        if(cnt == 2) {
            if(arr[0] + arr[1] == value) {
                flag = true;
                sb.append(arr[0]).append(" ").append(arr[1]);
                if(flag) sb.append(", ");
            }
            return;
        }

        for(int i = idx; i <= value; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                arr[cnt] = i;
                solve(i, cnt+1, value, flag);
                vtd[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            int value = sc.nextInt();
            sb = new StringBuilder();
            sb.append("Pairs for ").append(value).append(": ");
            arr = new int[2];
            vtd = new boolean[value+1];
            solve(1, 0, value, false);
            if(sb.toString().contains(",")) sb.deleteCharAt(sb.length() - 2);
            System.out.println(sb.toString());
        }
    }
}
