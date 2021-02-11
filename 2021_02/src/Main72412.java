import java.util.*;

public class Main72412 {
	public static HashMap<String, List<Integer>> map;
	public static boolean vtd[];

	public static void comb(int cnt, String sb, String tmp[], int idx) {
		if (cnt == 4) {
			List<Integer> t = new ArrayList<>();
			if (map.containsKey(sb)) {
				if (map.get(sb) != null) {
					t = map.get(sb);
				}
			}
			t.add(Integer.parseInt(tmp[tmp.length - 1]));
			map.put(sb, t);
			return;
		}

		for (int i = idx; i < tmp.length - 1; i++) {
			if (!vtd[i]) {
				vtd[i] = true;
				comb(cnt + 1, sb + tmp[i], tmp, i);
				comb(cnt + 1, sb + "-", tmp, i);
				vtd[i] = false;
			}
		}
	}

	public int[] solution(String[] info, String[] query) {
		map = new HashMap<>();
		int[] answer = new int[query.length];
		for (int i = 0; i < info.length; i++) {
			String splitArray[] = info[i].split(" ");
			vtd = new boolean[splitArray.length];
			comb(0, "", splitArray, 0);
		}

		for (int i = 0; i < query.length; i++) {
			String tmp[] = query[i].split(" ");
			String str = tmp[0] + tmp[2] + tmp[4] + tmp[6];
			int val = Integer.parseInt(tmp[7]);

			if (map.containsKey(str)) {
				List<Integer> com = map.get(str);
				for (int k = 0; k < com.size(); k++) {
					if (com.get(k) >= val)
						answer[i]++;
				}
			}
		}

		return answer;
	}
}
