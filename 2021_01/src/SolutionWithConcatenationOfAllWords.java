import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionWithConcatenationOfAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> answer = new ArrayList<Integer>();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < words.length; i++)
			list.add(words[i]);

		int start = 0;
		int end = 0;

		HashMap<String, Integer> map = new HashMap<>();

		while (start <= end) {
			if(words.length > map.size()) {
				
			}
			
			if (map.size() < words.length) {
				if(list.contains(s.substring(end, end + 3))) {
					if ((end + 3 < s.length())) {
						map.put(s.substring(end, end + 3), map.get(s.substring(end, end + 3)) + 1);
						end += 3;
					}
				} 
			}
			

			if (words.length == map.size()) { // map에 담긴 크기가 같다면
				
				
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String w[] = { "foo", "bar" };
		System.out.println(findSubstring(s, w).toString());
	}
}
