import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main508 {
    static class Person {
        int idx;
        int priority;

        public Person(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        Queue<Person> q = new LinkedList<>();
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            q.offer(new Person(i, Integer.parseInt(st.nextToken())));
        }

        int answer = 0;
        while(!q.isEmpty()) {
            Person tmp = q.poll();
            for(Person x: q) {
                if(x.priority > tmp.priority) {
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {
                answer++;
                if(tmp.idx == M) break;
            }
        }

        System.out.println(answer);
    }
}
