//https://www.acmicpc.net/problem/11438
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main11438 {
    public static int N, M, dp[][], depth[];
    public static List<List<Integer>> list;
    public static boolean vtd[];
    public static int maxLevel = 21;

    public static void dfs(int cur, int parent) {
        vtd[cur] = true; //방문 노드 체크
        //현재노드의 depth는 부모노드의 depth+1이어야하다.
        depth[cur] = depth[parent] + 1;  // root node의 depth를 1로 잡는다.

        for(int next: list.get(cur)) { // 현재 node와 연결된 노드들을 찾아서 depth체크, dp의 부모값에 저장한다.
            if(!vtd[next]) { //방문한적이 없는 노드인 경우에만 체크한다.
                vtd[next] = true; // 방문 체크
                dp[next][0] = cur; // 다음 갈 노드의 부모노드는 현재 노드 값이다.
                dfs(next, cur); //next값이 현재값이 되고, 현재 값이 부모값이 된다.
            }
        }
    }

    public static void solve() {
        for(int y = 1; y <= maxLevel; y++) {
            for(int x = 1; x <= N; x++) { // 1 -> N 노드까지 체크
                dp[x][y] = dp[dp[x][y-1]][y-1];
            }
        }
    }

    public static int lca(int x, int y) {
        //depth[x] >= depth[y], x를 더 깊은 depth로 가정한다.
        if(depth[x] < depth[y]) { //만약 y의 depth가 더 깊은 경우, x, y를 swap 한다.
            int tmp = y;
            y = x;
            x = tmp;
        }

        for(int i = maxLevel; i >= 0; i--) {
            //더 depth가 깊은 x를 기준으로
            //2^i승이 두 노드의 depth 값보다 커질때까지..
            //맞춘 depth의 조상 노드를 x에 저장한다.
            if(Math.pow(2, i) <= depth[x] - depth[y]) {
                x = dp[x][i];
            }
        }

        if(x == y) return x; //x의 조상노드가 y라면, 즉 둘의 조상노드가 같다면
        else {
            for(int i = maxLevel; i >= 0; i--) {
                //현재 같은 depth를 갖고 있기 때문에, 공통 부모의 직전까지 노드를 끌어올린다.
                if(dp[x][i] != dp[y][i]) {
                    x = dp[x][i];
                    y = dp[y][i];
                }
            }
            x = dp[x][0]; //공통 부모 직전까지 체크했으므로, 그것의 부모를 return 한다.
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        // root 노드를 1부터 시작
        dp = new int[N+1][maxLevel+1]; // dp[x][y] 형태로 x의 2^y부모노드를 저장
        depth = new int[N+1]; // 각 노드의 부모노드 저장
        vtd = new boolean[N+1];
        list = new ArrayList<>();

        for(int i = 0; i <= N; i++) list.add(new ArrayList<>());

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        } // 입력

        dfs(1, 0); // dfs로 노드들을 순회하면서, 각각의 depth를 찾고, 부모노드들을 저장한다.
        solve(); // dp를 활용하여, 각 노드의 2^i 부모노드들을 저장한다.

        st = new StringTokenizer(bf.readLine().trim());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(lca(x, y));
        }
    }
}