//https://www.acmicpc.net/problem/9466
import java.util.Scanner;

public class Main9466 {
    public static int answer, N, arr[];
    public static boolean vtd[], check[];

    public static void solve(int num) {
        vtd[num] = true;
        int next = arr[num]; // next value
        if(!vtd[next]) { // never visited
            solve(next);
        } else if (!check[next]) { // visited && not deleted?
            for(int i = next; i != num; i = arr[i]) {
            	answer++;
            }
            answer++;
        }
        check[num] = true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int ts = 1; ts <= test; ts++) {
            N = sc.nextInt();
            arr = new int[N+1];
            vtd = new boolean[N+1];
            check = new boolean[N+1];
            answer = 0;

            for(int i = 1; i <= N; i++) {
                int x = sc.nextInt();
                arr[i] = x;
            }

            for(int i = 1; i <= N; i++) {
                if(!vtd[i]) solve(i);
            }
            System.out.println(N-answer);
        }
    }
}