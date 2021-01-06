//https://programmers.co.kr/learn/courses/30/lessons/67258
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution67528 {
	public static int[] solution(String[] gems) {
	        int[] answer = {0, 987654321};
	        int start = 0;
			int end = 0;
			
			HashSet<String> set = new HashSet<>();
			for(int i = 0; i < gems.length; i++) set.add(gems[i]); // hashset을 이용하여 size를 체크한다.
			int size = set.size(); // 중복이 걸러진 보석의 개수 
			
			// String을 key값으로 갖는 hashmap을 생성한다. 
			// value는 key값의 개수이다.
			HashMap<String, Integer> map = new HashMap<>();  
			
			while(start < gems.length) { // 투포인터 알고리즘을 이용한다. 
				if(map.size() >= size) { // map의 사이즈가 hashset으로 걸러낸 사이즈보다 크다면 
					if(map.get(gems[start]) == 1) map.remove(gems[start++]); // 해당 key가 하나밖에 없으면 remove
					else map.put(gems[start], map.get(gems[start++])-1); // 두 개 이상이면 개수-1
				} 
				else if(end == gems.length) break; // end 포인터가 gems 끝에 다다르면 break
				else {
					// 만약 현재 값이 map에 없다면
					if(!map.containsKey(gems[end])) map.put(gems[end++], 1); //새롭게 넣고 count는 1로 
					else map.put(gems[end], map.get(gems[end++])+1); // 이미 있었다면, value값만 +1해준다.
				}
				
				if(size == map.size()) { // map의 size가 중복 제거한 size와 같아진다면 
					if(answer[1]-answer[0] > (end-start)) { // 범위가 더 작다면 answer 값을 바꿔주고
						answer[0] = start;
						answer[1] = end;
					} else if(answer[1]-answer[0] == (end-start)) { // 범위가 같다면 start 값을 비교해서 작을때 answer 변경
						if(answer[0] > start) {
							answer[0] = start;
							answer[1] = end;	
						}
					}
				}
			}
			// 0부터 시작하기 때문에 +1 해준다.
			// end는 마지막에++한 상태로 종료되서 ++가 필요없다.
			answer[0]++; 
			return answer;
	}

	public static void main(String[] args) {
//		String g[] = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		String g[] = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//		String g[] = {"AA", "AB", "AC", "AA", "BC"};
//		String g[] = {"XYZ", "XYZ", "XYZ"};
		System.out.println(Arrays.toString(solution(g)));
	}
}
