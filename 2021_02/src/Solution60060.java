import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*class newTrieNode { // 자식 노드 맵, 현재 노드가 마지막 글자인지 여부

	
	
}

class newTrie { // 빈 문자열을 가지는 루트 노드 

	
}
*/
public class Solution60060 {
	public static int[] solution(String[] words, String[] queries) {
		int answer[] = {};
		// insert ?
		
		
		
		// contains ?
		
		for(int i = 0; i < queries.length; i++) {
			if(queries[i].charAt(0) == '?') { // 맨 앞에 오는 경우 
				
			} else { // 뒤에 오는 경우
				
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
