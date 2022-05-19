import java.util.Scanner;

public class Main806 { // 순열 구하기
    public static int[] arr, chk, pm;
    public static int n, m;
    public static void DFS(int cnt) {
        if(cnt == m) {
            for(int x: pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = 1; i <= n; i++) {
                if(chk[i] == 0) {
                    pm[cnt] = arr[i];
                    chk[i] = 1;
                    DFS(cnt+1);
                    chk[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        chk = new int[n];
        pm = new int[m];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        DFS(0);
    }
}
