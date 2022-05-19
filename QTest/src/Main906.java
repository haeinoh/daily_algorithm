import java.util.Scanner;

public class Main906 {
    public static int N, M;
    public static int[] arr;
    public static int find(int v) { // find 함수는 집합 번호를 return 해줌
        if(v == arr[v]) return arr[v];
        else return arr[v] = find(arr[v]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) arr[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1];
        for(int i = 1; i <= N; i++) arr[i] = i;
        for(int i = 1; i <= M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b); // a, b를 하나의 집합으로 만들어라
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = find(a);

    }
}
