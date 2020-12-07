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
        //�������� depth�� �θ����� depth+1 �̾���Ѵ�.
        //�� ��, root node�� depth�� 1�� ��´�
        depth[cur] = depth[parent] + 1;  

        for(int next: list.get(cur)) { // ���� node�� ����� ������ ã�Ƽ� depthüũ, dp �θ𰪿� �����Ѵ�.
            if(!vtd[next]) { //�湮������ ���� ����� ��쿡�� üũ�Ѵ�.
                vtd[next] = true; // �湮 üũ true 
                dp[next][0] = cur; // ���� �� ����� �θ���� ���� ��� ���̴�.
                dfs(next, cur); //next���� ���簪�� �ǰ�, ���� ���� �θ��� �ȴ�.
            }
        }
    }

    public static void solve() {
        for(int y = 1; y <= maxLevel; y++) { // 1 -> maxLevel
            for(int x = 1; x <= N; x++) { // 1 -> N ������ üũ
                dp[x][y] = dp[dp[x][y-1]][y-1];
            }
        }
    }

    public static int lca(int x, int y) {
        //x�� �� ���� depth�� �����Ѵ�.
    	//�׷��� ���� y�� depth�� �� ���� ���, x, y�� swap �Ѵ�.
        if(depth[x] < depth[y]) { 
            int tmp = y;
            y = x;
            x = tmp;
        }

        for(int i = maxLevel; i >= 0; i--) {
        	//�� ����� depth ���̰� 2^i���� �۰ų� ���� ��...
            //x�� y�� depth�� ����� 
            if(Math.pow(2, i) <= depth[x] - depth[y]) {
                x = dp[x][i];
            }
        }

        if(x == y) return x; //�� ����� �θ� ��尡 ���ٸ�? �״�� return x
        else { //depth�� ������ �θ��尡 �ٸ��ٸ�? 
            for(int i = maxLevel; i >= 0; i--) {
                //���� ���� depth�� ���� �ֱ� ������, ���� ���� ���� �и� ���� �� �ֵ��� ������ üũ�Ѵ�.
                if(dp[x][i] != dp[y][i]) {
                    x = dp[x][i];
                    y = dp[y][i];
                }
            }
            x = dp[x][0]; //���� �θ� �������� üũ�����Ƿ�, �� ����� �θ� ��带 return�Ѵ�.
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        // root ��带 1���� ����
        dp = new int[N+1][maxLevel+1]; // dp[x][y] ���·� x�� 2^y �θ��带 ����
        depth = new int[N+1]; // �� ����� �θ� ��� ���� �迭
        vtd = new boolean[N+1]; // dfs �� �� �湮 üũ �迭
        list = new ArrayList<>();

        for(int i = 0; i <= N; i++) list.add(new ArrayList<>()); //�ʱ�ȭ

        for(int i = 0; i < N-1; i++) { // �Է�
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        } 

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