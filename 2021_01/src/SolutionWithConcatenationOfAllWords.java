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
		HashMap<String, Integer> map = new HashMap<>();

		while (start + words[0].length() < words.length) {
			
			
			
		}

		return answer;
	}

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String w[] = { "foo", "bar" };
		System.out.println(findSubstring(s, w).toString());
	}
}
