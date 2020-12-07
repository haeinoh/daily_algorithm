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
        vtd[cur] = true; //�湮 ��� üũ
        //�������� depth�� �θ����� depth+1�̾���ϴ�.
        depth[cur] = depth[parent] + 1;  // root node�� depth�� 1�� ��´�.

        for(int next: list.get(cur)) { // ���� node�� ����� ������ ã�Ƽ� depthüũ, dp�� �θ𰪿� �����Ѵ�.
            if(!vtd[next]) { //�湮������ ���� ����� ��쿡�� üũ�Ѵ�.
                vtd[next] = true; // �湮 üũ
                dp[next][0] = cur; // ���� �� ����� �θ���� ���� ��� ���̴�.
                dfs(next, cur); //next���� ���簪�� �ǰ�, ���� ���� �θ��� �ȴ�.
            }
        }
    }

    public static void solve() {
        for(int y = 1; y <= maxLevel; y++) {
            for(int x = 1; x <= N; x++) { // 1 -> N ������ üũ
                dp[x][y] = dp[dp[x][y-1]][y-1];
            }
        }
    }

    public static int lca(int x, int y) {
        //depth[x] >= depth[y], x�� �� ���� depth�� �����Ѵ�.
        if(depth[x] < depth[y]) { //���� y�� depth�� �� ���� ���, x, y�� swap �Ѵ�.
            int tmp = y;
            y = x;
            x = tmp;
        }

        for(int i = maxLevel; i >= 0; i--) {
            //�� depth�� ���� x�� ��������
            //2^i���� �� ����� depth ������ Ŀ��������..
            //���� depth�� ���� ��带 x�� �����Ѵ�.
            if(Math.pow(2, i) <= depth[x] - depth[y]) {
                x = dp[x][i];
            }
        }

        if(x == y) return x; //x�� �����尡 y���, �� ���� �����尡 ���ٸ�
        else {
            for(int i = maxLevel; i >= 0; i--) {
                //���� ���� depth�� ���� �ֱ� ������, ���� �θ��� �������� ��带 ����ø���.
                if(dp[x][i] != dp[y][i]) {
                    x = dp[x][i];
                    y = dp[y][i];
                }
            }
            x = dp[x][0]; //���� �θ� �������� üũ�����Ƿ�, �װ��� �θ� return �Ѵ�.
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        // root ��带 1���� ����
        dp = new int[N+1][maxLevel+1]; // dp[x][y] ���·� x�� 2^y�θ��带 ����
        depth = new int[N+1]; // �� ����� �θ��� ����
        vtd = new boolean[N+1];
        list = new ArrayList<>();

        for(int i = 0; i <= N; i++) list.add(new ArrayList<>());

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        } // �Է�

        dfs(1, 0); // dfs�� ������ ��ȸ�ϸ鼭, ������ depth�� ã��, �θ������ �����Ѵ�.
        solve(); // dp�� Ȱ���Ͽ�, �� ����� 2^i �θ������ �����Ѵ�.

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