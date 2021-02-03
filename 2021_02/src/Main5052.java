import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class phoneTrieNode {
	public phoneTrieNode next[];
	public boolean isLast;
	
	phoneTrieNode() {
		next = new phoneTrieNode[10];
		this.isLast = isLast;
	}
}

class phoneTrie {
	phoneTrieNode root;
	
	phoneTrie(){
		root = new phoneTrieNode();
	}
	
	public void insert() {
		phoneTrieNode node = root;
		
		
		
	}
	
}


public class Main5052 {
	public static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		int test = Integer.parseInt(st.nextToken());

		for(int ts = 1;  ts <= test; ts++) {
			int answer = 0;
			st = new StringTokenizer(bf.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			for(int i = 0; i < N; i++) {
				int k = Integer.parseInt(new StringTokenizer(bf.readLine().trim()).nextToken());
				
			}
			
			
			System.out.println(answer);
		}
	}
}
