import java.util.*;

public class Main72412 {
	public static HashMap<String, List<Integer>> map;
	public static boolean vtd[];

	public static void comb(int cnt, String sb, String tmp[], int idx) { // 모든 경우의 수 다 map에 put
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

	public static int[] solution(String[] info, String[] query) {
		map = new HashMap<>();
		int[] answer = new int[query.length];
		for (int i = 0; i < info.length; i++) {
			String splitArray[] = info[i].split(" ");
			vtd = new boolean[splitArray.length];
			comb(0, "", splitArray, 0); // comb
		}

		// map value 오름차순으로 정렬
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			List<Integer> list = map.get(key);
			Collections.sort(list);
		}

		for (int i = 0; i < query.length; i++) {
			String tmp[] = query[i].split(" ");
			String str = tmp[0] + tmp[2] + tmp[4] + tmp[6]; // 비교해야할 string
			int score = Integer.parseInt(tmp[7]); // 찾아야할 점수

			if (map.containsKey(str)) { // 포함되어 있는 경우
				List<Integer> nums = map.get(str); // map에서 str을 갖고 있는 경우, 점수들 list
				int start = 0;
				int end = nums.size() - 1;
				while(start <= end) { // 시간초과 때문에 이분탐색으로 체크
					int mid = (start + end) / 2;
					if(nums.get(mid) < score) start = mid + 1;
					else end = mid - 1;
				}
				answer[i] = nums.size() - start; // start index부터가 X점수 이상이므로, 그 index ~ size 까지가 갯수
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		String in[] = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String qu[] = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(Arrays.toString(solution(in, qu)));
	}
}
