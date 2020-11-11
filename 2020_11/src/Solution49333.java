
public class Solution49333 {

	public static void main(String[] args) {
		int answer = 0;
		String[] skill_trees = { "BACDE", "CBADF" };
		String skill = "CBD";

		for (int i = 0; i < skill_trees.length; i++) {
			String str = skill_trees[i];
			String tmp = "";
			for (int j = 0; j < str.length(); j++) {
				for (int k = 0; k < skill.length(); k++) {
					if (str.charAt(j) == skill.charAt(k)) {
						tmp += str.charAt(j);
						break;
					}
				}
			}
			boolean flag = false;

			for (int p = 0; p < skill.length(); p++) {
				if (tmp.length() <= p)
					break;
				if (skill.charAt(p) == tmp.charAt(p)) {
					continue;
				} else {
					flag = true;
					break;
				}
			}
			if (!flag)
				answer++;
		}
		System.out.println(answer);
	}
}
