import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine().trim());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int[] arr = new int[N];
        // 1) 수열 입력 받기
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> s = new Stack<>();
        // 2) stack, 0번째 index push;
        s.push(0);
        int[] answer = new int[N];

        for(int i = 1; i < N; i++) {
            if(s.isEmpty()) s.push(i);

            // 3) stack이 비어있지 않고, 현재 stack의 top에 있는 index의 값과 현재 index와 비교
            while(!s.isEmpty() && arr[s.peek()] < arr[i]) {
                answer[s.pop()] = arr[i];
            }
            s.push(i);
        }

        // 4) 끝까지 다 체크 했는데 아직 stack에 index가 남아있는 경우
        while(!s.isEmpty()) {
            answer[s.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < answer.length; i++) sb.append(answer[i]).append(" ");

        System.out.println(sb.toString());
    }
}
