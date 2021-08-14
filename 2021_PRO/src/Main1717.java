import java.io.*;
import java.util.*;

public class Main1717 {
    public static int[] parent;
    public static int n, m;

    public static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) { // y > x
        x = find(x);
        y = find(y);

        if(x != y) parent[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for(int i = 1; i <= n; i++) parent[i] = i; // init

        for(int i = 0;i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(op == 0) { //union
                if(a > b) {
                    int tmp = b;
                    b = a;
                    a = tmp;
                }
                union(a, b);
            } else { // find
                if(find(a) == find(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
