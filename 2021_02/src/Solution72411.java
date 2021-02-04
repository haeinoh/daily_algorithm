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
             Arrays.sort(temp); // ���� �� �ִ� ���� ��ȣ�� ������ ���� ��, ������������ ����
             String str = "";
             for(int i = 0; i < temp.length; i++) str += temp[i]; 
             if(map.containsKey(str)) { // ���� ������ �ִ� ������ �����̶�� +1 �߰� �� put 
                 int val = map.get(str);
                 map.put(str, val+1);
             } else map.put(str, 1); // �� ���� ���� �� ���� ������ �����̶�� 1�� put
             return;
         }

         for(int i = idx; i < orders.length(); i++) { // ����
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
        for(int i = 0; i < orders.length; i++) maxLength = Math.max(maxLength, orders[i].length()); // orders ���� �� ��
        for(int i = 0; i < course.length; i++) { 
        	if(course[i] <= maxLength) { 
        		arr = new int[course[i]]; // course�� ���̿� ���� arr �迭 ���� - �������� ���� ����
        		map = new HashMap<>(); // string(���յ� ����)�� key��, Integer(����)�� value��
        		for(int j = 0; j < orders.length; j++) { // order��ŭ ���鼭 ���� �� �ִ� ���� 
        			vtd = new boolean[orders[j].length()];
        			solve(orders[j], course[i], 0, 0);
        		}
        		int findMax = Collections.max(map.values()); // value�� �� ���� ū ���� ã�´�.
        		if(findMax >= 2) { // value���� 2 �̻��� �� �߿��� 
        			for(Map.Entry<String, Integer> m: map.entrySet()) { // map�� ���鼭 
        				if(m.getValue() == findMax) { // findMax value�� ���� �ִ� key���� ���� list�� �ִ´�.(1�� �̻��� �� ������ ���鼭 �� üũ�غ���)
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
