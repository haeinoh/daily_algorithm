import java.util.Scanner;

public class Main3040 {
    public static int[] arr;
    public static boolean[] vtd, ans;

    public static void solve(int cnt, int sum) {
        if(sum > 100) return;
        if(cnt == 7) {
            if(sum == 100) {
                for(int i = 0; i < 9; i++) ans[i] = vtd[i];
            }
            return;
        }

        for(int i = 0; i < 9; i++) {
            if(!vtd[i]) {
                vtd[i] = true;
                solve(cnt+1, sum+arr[i]);
                vtd[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr =  new int[9];
        vtd = new boolean[9];
        ans = new boolean[9];
        for(int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        solve(0, 0);
        for(int i = 0; i < 9; i++) {
            if(ans[i]) sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
