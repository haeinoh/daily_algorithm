import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*class newTrieNode { // �ڽ� ��� ��, ���� ��尡 ������ �������� ����

	
	
}

class newTrie { // �� ���ڿ��� ������ ��Ʈ ��� 

	
}
*/
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
