import java.util.ArrayList;
import java.util.Scanner;

public class Main713 {
    public static int n, m, answer;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] ch;
    public static void DFS(int v) {
        if(v == n) answer++;
        else {
            for(int nv: graph.get(v)) {
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0; // 풀어줘야지 다시 백트래킹되었을때 접근 가능함... 스택 프레임 생각하기
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) { // 1~n번까지 정수를 저장할 수 있는 객체를 생성....
            graph.add(new ArrayList<>()); // arraylist index처럼 사용 할 수 있음  graph.get(1) ~ graph.get(n) 까지 접근 가능
        }

        answer = 0;
        ch = new int[n+1];

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).get(b);
        }

        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }
}
