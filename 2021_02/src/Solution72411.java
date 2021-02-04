//https://programmers.co.kr/learn/courses/30/lessons/72411
import java.util.*;
public class Solution72411 {
    public static HashMap<String, Integer> map;
    public static ArrayList<String> ans;
    public static int arr[];
    public static boolean vtd[];
    public static void solve(String orders, int course, int count, int idx) {
    	 if(count == course) {
             String temp[] = new String[course];
             for(int i = 0; i < count; i++) {
                 temp[i] = String.valueOf(orders.charAt(arr[i]));
             } 
             Arrays.sort(temp); // 만들 수 있는 조합 번호로 음식을 만들 때, 오름차순으로 정렬
             String str = "";
             for(int i = 0; i < temp.length; i++) str += temp[i]; 
             if(map.containsKey(str)) { // 만약 나온적 있던 음식의 조합이라면 +1 추가 후 put 
                 int val = map.get(str);
                 map.put(str, val+1);
             } else map.put(str, 1); // 한 번도 나온 적 없던 음식의 조합이라면 1로 put
             return;
         }

         for(int i = idx; i < orders.length(); i++) { // 조합
             if(!vtd[i]) {
                 vtd[i] = true;
                 arr[count] = i;
                 solve(orders, course, count + 1, i);
                 vtd[i] = false;
             }
         }
    }
    public static String[] solution(String[] orders, int[] course) {
    	ans = new ArrayList<>();
        int maxLength = 0;
        for(int i = 0; i < orders.length; i++) maxLength = Math.max(maxLength, orders[i].length()); // orders 가장 긴 값
        for(int i = 0; i < course.length; i++) { 
        	if(course[i] <= maxLength) { 
        		arr = new int[course[i]]; // course의 길이와 같은 arr 배열 생성 - 조합으로 넣을 예정
        		map = new HashMap<>(); // string(조합된 음식)을 key로, Integer(갯수)를 value로
        		for(int j = 0; j < orders.length; j++) { // order만큼 돌면서 만들 수 있는 조합 
        			vtd = new boolean[orders[j].length()];
        			solve(orders[j], course[i], 0, 0);
        		}
        		int findMax = Collections.max(map.values()); // value값 중 가장 큰 값을 찾는다.
        		if(findMax >= 2) { // value값이 2 이상인 것 중에서 
        			for(Map.Entry<String, Integer> m: map.entrySet()) { // map을 돌면서 
        				if(m.getValue() == findMax) { // findMax value를 갖고 있는 key들을 정답 list에 넣는다.(1개 이상일 수 있으니 돌면서 다 체크해본다)
        					ans.add(m.getKey());
        				}
        			}
        		}
        	}
        }
        Collections.sort(ans);
        String answer[] = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++) answer[i] = ans.get(i);
        return answer;
    }
	
	public static void main(String[] args) {
		String o[] = {"XYZ", "XWY", "WXA"};
		int c[] = {2, 3, 4};
		
		System.out.println(Arrays.toString(solution(o, c)));
	}
}
