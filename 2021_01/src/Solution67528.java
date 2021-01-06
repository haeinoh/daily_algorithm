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
			for(int i = 0; i < gems.length; i++) set.add(gems[i]); // hashset�� �̿��Ͽ� size�� üũ�Ѵ�.
			int size = set.size(); // �ߺ��� �ɷ��� ������ ���� 
			
			// String�� key������ ���� hashmap�� �����Ѵ�. 
			// value�� key���� �����̴�.
			HashMap<String, Integer> map = new HashMap<>();  
			
			while(start < gems.length) { // �������� �˰����� �̿��Ѵ�. 
				if(map.size() >= size) { // map�� ����� hashset���� �ɷ��� ������� ũ�ٸ� 
					if(map.get(gems[start]) == 1) map.remove(gems[start++]); // �ش� key�� �ϳ��ۿ� ������ remove
					else map.put(gems[start], map.get(gems[start++])-1); // �� �� �̻��̸� ����-1
				} 
				else if(end == gems.length) break; // end �����Ͱ� gems ���� �ٴٸ��� break
				else {
					// ���� ���� ���� map�� ���ٸ�
					if(!map.containsKey(gems[end])) map.put(gems[end++], 1); //���Ӱ� �ְ� count�� 1�� 
					else map.put(gems[end], map.get(gems[end++])+1); // �̹� �־��ٸ�, value���� +1���ش�.
				}
				
				if(size == map.size()) { // map�� size�� �ߺ� ������ size�� �������ٸ� 
					if(answer[1]-answer[0] > (end-start)) { // ������ �� �۴ٸ� answer ���� �ٲ��ְ�
						answer[0] = start;
						answer[1] = end;
					} else if(answer[1]-answer[0] == (end-start)) { // ������ ���ٸ� start ���� ���ؼ� ������ answer ����
						if(answer[0] > start) {
							answer[0] = start;
							answer[1] = end;	
						}
					}
				}
			}
			// 0���� �����ϱ� ������ +1 ���ش�.
			// end�� ��������++�� ���·� ����Ǽ� ++�� �ʿ����.
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
