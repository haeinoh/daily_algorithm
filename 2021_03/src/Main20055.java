// https://www.acmicpc.net/problem/20055
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main20055 {
    public static int N, K;
    public static LinkedList<Integer> list, robot;

    public static void rotate() {
        // 벨트 이동
        list.addFirst(list.pollLast());
        // 벨트 위 로봇도 같이 이동
        for (int i = 0; i < robot.size(); i++) {
            int tmp = robot.pollFirst();
            robot.addLast(tmp + 1);
        }
        if (robot.contains(N - 1)) {
            robot.remove(robot.indexOf(N - 1));
        }
    }

    public static void move() {
        for (int i = 0; i < robot.size(); i++) {
            int tmp = robot.get(i);
            int nx = tmp + 1;
            // 이동하려는 칸에 로봇이 없으며 && 내구도가 1 이상 남아 있는 경우
            if (!robot.contains(nx) && list.get(nx) >= 1) {
                robot.set(i, nx);
                list.set(nx, list.get(nx) - 1);
            }
        }
        if (robot.contains(N - 1)) {
            robot.remove(robot.indexOf(N - 1));
        }
    }

    public static void up() {
        if ((robot.size() == 0 || !robot.contains(0)) && list.get(0) >= 1) {
            robot.addLast(0);
            list.set(0, list.get(0) - 1);
        }
    }

    public static boolean counting() {
        int count = 0;
        for (Integer v : list) {
            if (v == 0) count++;
            if (count >= K) return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new LinkedList<>();
        robot = new LinkedList<>();
        int answer = 1;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 2 * N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        while (true) {
            // 1. 벨트를 한 칸 회전한다.
            rotate();
            // 2. 로봇을 이동한다.
            move();
            // 3. 올라기는 위치(1)에 로봇이 없음녀 하나 올린다.
            up();
            // 4. 내구도가 0인 칸의 개수가 K개 이상일 떄 종료
            if (counting()) break;
            answer++;
        }
        System.out.println(answer);
    }
}
