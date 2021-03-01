//https://programmers.co.kr/learn/courses/30/lessons/60060
import java.util.Arrays;

public class Solution60060 {
	static class TrieNode {
		TrieNode[] next;
		int count;

		TrieNode() {
			next = new TrieNode[26];
		}
	}

	static class Trie {
		TrieNode root;
		Trie() {
			root = new TrieNode();
		}

		void insert(String str) {
			TrieNode node = root;
			for(int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i) - 'a';
				if(node.next[idx] == null) node.next[idx] = new TrieNode();
				node.count++;
				node = node.next[idx];
			}
		}

		int contains(String str) {
			TrieNode node = root;

			for(int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i) - 'a';
				if(str.charAt(i) == '?') return node.count; // 만약 들어온 값이 ? 이면 바로 count 값을 리턴
				if(node.next[idx] == null) return 0;
				node = node.next[idx];
			}
			return node.count;
		}
	}

    public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];

		// 조건에 주어진 길이만큼 만든다.
		Trie[] forward = new Trie[10001]; // 앞에서부터 원래대로 insert
		Trie[] backward = new Trie[10001]; // 뒤에서부터 거꾸로 insert

		for (String word : words) { // words를 돌면서 각각의 글자들을 길이 별로 insert하는 부분
			StringBuilder sb = new StringBuilder(word);
			int len = sb.length();
			if (forward[len] == null) { // 한 번도 만들어진 적이 없는 길이라면
				forward[len] = new Trie();
				backward[len] = new Trie();
			}
			forward[len].insert(sb.toString()); // 기존 그대로 insert
			backward[len].insert(sb.reverse().toString()); // 거꾸로 insert
		}

		for(int i = 0; i < queries.length; i++) { // queries를 돌면서 가사를 검색한다.
			StringBuilder str = new StringBuilder(queries[i]);
			if(forward[str.length()] == null) answer[i] = 0; // 만약 quries에서 주어진 길이가 존재 하지 않는다면 그냥 0
			else if(str.charAt(0) == '?') { // ? 앞에 있는 경우
				answer[i] = backward[str.length()].contains(str.reverse().toString()); // 글자를 reverse해서 backward로 검사한다.
			} else {
				answer[i] = forward[str.length()].contains(str.toString()); // 원래 글자 그대로 forward로 검사한다.
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		String w[] = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String q[] = {"fro??", "????o", "fr???", "fro???", "pro?"};
		
		System.out.println(Arrays.toString(solution(w, q)));
	}
}
