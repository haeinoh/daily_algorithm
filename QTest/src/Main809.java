public class Main809 {
    public static int[] comb;
    public static int n, m;
    public static void solve(int cnt, int idx) {
        if(cnt == m) {
            for(int x : comb) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = idx; i <= n; i++) {
                comb[cnt] = i;
                solve(cnt+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        n = 4;
        m = 2;
        comb = new int[m];
        solve(0, 1);
    }
}
