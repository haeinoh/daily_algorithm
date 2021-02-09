import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution60060 {
    static class TrieNode {
        TrieNode next[];
        boolean isLast;
        int count;
        TrieNode() {
            next = new TrieNode[26];
            this.isLast = false;
            this.count = 0;
        }
    }

    static class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if(node.next[idx] == null) node.next[idx] = new TrieNode();
                node = node.next[idx];
            }
            node.isLast = true;
        }

        boolean contains(String word, boolean flag) {
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if(word.charAt(i) == '?') {
//                    System.out.println(node.count);
                    continue;
                }
                if(node.next[idx] == null) return false;
                node = node.next[idx];
                node.count--;
            }
            if(!flag && node.isLast) return true;
            return false;
        }

    }
    public static int[] solution(String[] words, String[] queries) {
        int answer[] = new int[queries.length];
        Trie t = new Trie();
        for(int i = 0; i < words.length; i++) {
            t.insert(words[i]);
        }
        // insert를 두 번 해야하나....??
        for(int i = 0; i < queries.length; i++) {
            if(queries[i].charAt(0) == '?') { // 앞
                if(t.contains(queries[i], false)) answer[i]++;
            } else {
                if(t.contains(queries[i], true)) answer[i]++;
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
