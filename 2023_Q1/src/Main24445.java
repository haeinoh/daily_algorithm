import java.util.*;

public class Main24445 {
    public static int n, m ,r;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] arr;
    public static boolean[] vtd;
    public static void bfs() {
        int idx = 1;
        vtd[r] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(r);

        while(!q.isEmpty()) {
            int tmp = q.poll();
            arr[tmp] = idx++;
            ArrayList<Integer> list = graph.get(tmp);
            Collections.sort(list, Collections.reverseOrder());
            for(int i = 0; i < list.size(); i++) {
                if(!vtd[list.get(i)]) {
                    vtd[list.get(i)] = true;
                    q.add(list.get(i));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        vtd = new boolean[n+1];
        graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        arr = new int[n+1];
        Arrays.fill(arr, 0);

        bfs();

        for(int i = 1; i < arr.length; i++) System.out.print(arr[i] + " ");
    }
}
