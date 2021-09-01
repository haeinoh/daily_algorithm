import java.util.*;
public class Solution81303 {
    static class Node {
        int prev;
        int cur;
        int next;

        public Node(int prev, int cur, int next) {
            this.prev = prev;
            this.cur = cur;
            this.next = next;
        }
    }
    static String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];

        for(int i = 0; i < n; i++) { // prev, next init
            prev[i] = i - 1;
            next[i] = i + 1;
        }

        next[n-1] = -1; // 마지막 원소 (맨 처음과 끝은 -1 처리)

        Stack<Node> stack = new Stack<>(); // remove ) (prev, cur, next)

        StringBuilder sb = new StringBuilder("O".repeat(n)); // 초기값

        for(int i = 0; i < cmd.length; i++) {
            if(cmd[i].charAt(0) == 'U') {
                int val = Integer.parseInt(cmd[i].substring(2));
                while(val-- > 0) k = prev[k]; // up ) 위로 커서 이동
            } else if(cmd[i].charAt(0) == 'D') {
                int val = Integer.parseInt(cmd[i].substring(2));
                while(val-- > 0) k = next[k]; // down ) 아래로 커서 이동
            } else if(cmd[i].charAt(0) == 'C') {
                stack.push(new Node(prev[k], k , next[k])); // 삭제되는 노드 저장

                // 현재 위치가 마지막이 아닌 경우
                if(next[k] != -1) prev[next[k]] = prev[k];
                // 현재 위치가 처음이 아닌 경우
                if(prev[k] != -1) next[prev[k]] = next[k];

                //삭제 처리
                sb.setCharAt(k, 'X');

                // 마지막이 아닌 경우
                if(next[k] != -1) k = next[k];
                else k = prev[k];
            } else { // Z
                int pre = stack.peek().prev;
                int cur = stack.peek().cur;
                int nxt = stack.peek().next;

                // prev, next는 이미 변경 됐으므로
                if(nxt != -1) prev[nxt] = cur;
                if(pre != -1) next[pre] = cur;

                sb.setCharAt(cur, 'O');
                stack.pop();
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        System.out.println(solution(n, k, cmd));
    }
}
