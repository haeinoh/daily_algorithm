import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TrieNode {
	public TrieNode next[]; // 다음 (자식) 노드
	public boolean isLast; // 문자열이 끝난지를 체크한다.
	
	TrieNode() {
		next = new TrieNode[26]; // 알파벳
		this.isLast = false; 
	}
}

class Trie {
	TrieNode root;
	Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++) {
			int ch = word.charAt(i) - 'a';
			if(node.next[ch] == null) node.next[ch] = new TrieNode();
			node = node.next[ch];
		}
		node.isLast = true;
	}
	
	public boolean contains(String word) {
		TrieNode node = root;
		for(int i = 0; i < word.length(); i++) {
			int ch = word.charAt(i) - 'a';
			if(node.next[ch] == null) return false;
			node = node.next[ch];
		}
		if(node.isLast) return true;
		return false;
	}
	
}

public class Main14425 {
	public static int N, M, answer;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		Trie t = new Trie();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine().trim());
			String str = st.nextToken();
			if(!t.contains(str)) t.insert(str);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine().trim());
			String str = st.nextToken();
			if(t.contains(str)) answer++;
		}
		
		System.out.println(answer);
	}
}
