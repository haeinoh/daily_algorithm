import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main14425_2 {
	public static int N, M, answer;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		Set<String> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			set.add(new StringTokenizer(bf.readLine().trim()).nextToken());
		}
		for(int i = 0; i < M; i++) {
			if(set.contains(new StringTokenizer(bf.readLine().trim()).nextToken())) answer++;
		}		
		System.out.println(answer);
	}
}
