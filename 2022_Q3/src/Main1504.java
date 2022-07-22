import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1504 {
    static class Node implements Comparable<Node>{
        int v;
        int w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    public static int value1, value2, N, E;
    public static int[] dist;
    public static List<List<Node>> list;
    public static void solve() {


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dist = new int[N+1];
        //init
        for(int i = 0; i <= N; i++) {
            dist[i] = 987654321;
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
        }

        int value1 = Integer.parseInt(st.nextToken());
        int value2 = Integer.parseInt(st.nextToken());

        solve();


    }
}
