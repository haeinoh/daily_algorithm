import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class TrieNode { // �ڽ� ��� ��, ���� ��尡 ������ �������� ����
	public Map<Character, TrieNode> child = new HashMap<>();
	public boolean isLastChar;
	
	public Map<Character, TrieNode> getChild() {
		return child;
	}
	public boolean isLastChar() {
		return isLastChar;
	}
	public void setLastChar(boolean isLastChar) {
		this.isLastChar = isLastChar;
	}
}

class Trie { // �� ���ڿ��� ������ ��Ʈ ��� 
	public TrieNode rootNode;
	
	Trie() {
		rootNode = new TrieNode();
	}
	
	void insert(String word) {
		TrieNode node = this.rootNode;
		
		for(int i = 0; i < word.length(); i++) {
			if(node.getChild().get(word.charAt(i)) == null) {
				node = new TrieNode();
			}
		}
	}
	
	boolean contains(String word) {
		TrieNode node = this.rootNode;
		
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode n=  node.getChild().get(ch);
			if(n == null) return false;
			
			node = n;
		}
		return node.isLastChar();
	}
}

public class Solution60060 {
	public static int[] solution(String[] words, String[] queries) {
		int answer[] = {};
		// insert ?
		
		
		
		// contains ?
		
		for(int i = 0; i < queries.length; i++) {
			if(queries[i].charAt(0) == '?') { // �� �տ� ���� ��� 
				
			} else { // �ڿ� ���� ���
				
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
