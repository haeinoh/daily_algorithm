import java.util.Scanner;

public class Main804 { // 중복순열
    public static int[] arr;
    public static int n, m;
    public static void DFS(int cnt) {
        if(cnt == m) {
            for(int x: arr) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = 1; i <= n; i++) {
                arr[cnt] = i;
                DFS(cnt+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        DFS(0);
    }
}
