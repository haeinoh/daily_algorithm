//https://programmers.co.kr/learn/courses/30/lessons/42579
import java.util.*;

public class Solution42579 {
    public static int[] solution(String[] genres, int[] plays) {
    	  HashMap<String, Integer> map = new HashMap<>();
    	  int maxLength = 0;
          for(int i = 0; i < genres.length; i++) { // 각 장르의 재생횟수 합치기
              if(map.containsKey(genres[i])) {
                  map.put(genres[i], map.get(genres[i])+plays[i]);
              } else map.put(genres[i], plays[i]);
              maxLength = Math.max(maxLength, map.get(genres[i]));
          }

          List<String> keySetList = new ArrayList<>(map.keySet()); // list에 넣고
          
          Collections.sort(keySetList, new Comparator<String>() { // 재생횟수 순으로 오름차순 정리 
              @Override 
              public int compare(String o1, String o2) {
            	  return map.get(o2) - map.get(o1); 
              }
          });
          
         ArrayList<Integer> list = new ArrayList<>(); 
         for(int i = 0; i < keySetList.size(); i++) { // 장르 순서대로 돌면서 
        	 int idx = 0;
        	 int arr[][] = new int[maxLength][2];
        	 for(int j = 0; j < genres.length; j++) { 
        		 if(genres[j].equals(keySetList.get(i))) { // 같은 장르
        			 arr[idx][0] = plays[j];
        			 arr[idx++][1] = j;
        		 }
        	 }
        	 Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[0] - o1[0]; // 재생횟수 기준으로 오름차순
				}
			});
        	
        	if(arr[0][0] != 0) list.add(arr[0][1]);
        	if(genres.length > 1 && arr[1][0] != 0) list.add(arr[1][1]);
        	// 4번 : 하나인 경우 이 설정 안 해주면 런타임 에러 
         }
         int answer[] = new int[list.size()];
    	 for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
         
    	return answer;
    }
	
	public static void main(String[] args) {
		String g[] = {"classic", "pop", "classic", "classic", "pop"};
		int p[] = {500, 600, 150, 800, 2500};
//		String g[] = {"classic","jazz","music","rap","pop"};
//		int p[] = {500,150,600,800,2500};
//		String g[] = {"classic"};
//		int p[] = {500};
		System.out.println(Arrays.toString(solution(g, p)));
	}
}
