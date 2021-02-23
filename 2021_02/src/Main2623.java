//https://www.acmicpc.net/problem/2623
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2623 {
    public static List<List<Integer>> list;
    public static Queue<Integer> q;
    public static int[] arr;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        q = new LinkedList<>();
        list = new ArrayList<>();
        for(int i = 1; i <= N+1; i++) list.add(new ArrayList<>());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                list.get(cur).add(next);
                arr[next]++;
                cur = next;
            }
        }

        // 1. 진입 차수가 0이면 queue에 넣는다.
        for(int i = 1; i <= N; i++) {
            if(arr[i] == 0) q.add(i);
        }
        StringBuilder sb = new StringBuilder();

        int count = 0;
        while(!q.isEmpty()) {
            int idx = q.poll();
            sb.append(idx).append("\n");
            count++;
            // 2. queue에서 꺼내서 연결된 순서들을 체크한다.
            for(int i = 0; i < list.get(idx).size(); i++) {
                int num = list.get(idx).get(i);
                //3. 연결된 순서들의 진입차수를 하나씩 제거해가면서, 새롭게 진입차수가 0이되면 queue에 넣는다.
                if(--arr[num] == 0) q.add(num);
            }
        }
        if(count != N) System.out.println("0");
        System.out.println(sb.toString());
    }
}
