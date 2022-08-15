import java.util.HashSet;
import java.util.Scanner;

public class Main16922 {
    public static int N;
    public static HashSet<Integer> set;
    public static int[] arr = {1, 5, 10, 50};
    public static boolean[] vtd;
    public static void solve(int idx, int cnt, int sum) {
        if(cnt == N) {
            set.add(sum);
            vtd[sum] = true;
            return;
        }

        for(int i = idx; i < arr.length; i++) {
            if(!vtd[sum+arr[i]]) {
                vtd[sum+arr[i]] = true;
                solve(i, cnt+1, sum + arr[i]);
                vtd[sum+arr[i]] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        set = new HashSet<>();
        vtd = new boolean[N*50+1];
        solve(0, 0, 0);
        System.out.println(set.size());
    }
}
