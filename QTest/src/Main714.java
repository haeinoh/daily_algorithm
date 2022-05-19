import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main714 {
    public static int n, m;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] ch, dis;
    public static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        q.offer(v);

        while(!q.isEmpty()) {
            int cv = q.poll();
            for(int nv: graph.get(cv)) {
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    q.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // vertex
        m = sc.nextInt(); // edge
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        ch = new int[n+1];
        dis = new int[n+1];

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).get(b);
        }

        ch[1] = 1;
        BFS(1);
        for(int i = 0; i < dis.length; i++) {
            System.out.println((i+1) + " " + dis[i]);
        }
    }
}
