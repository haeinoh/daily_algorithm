//https://programmers.co.kr/learn/courses/30/lessons/17680
import java.util.ArrayList;

public class Solution17680 {
    public static int solution(int cacheSize, String[] cities) {
    	if(cacheSize == 0) return 5*(cities.length);

    	int answer = 0;
    		
    	ArrayList<String> list = new ArrayList<>();
    	for(int i = 0; i < cities.length; i++) cities[i] = cities[i].toLowerCase();
    	
        for(int i = 0; i < cities.length; i++) {
        	if(list.contains(cities[i])) {
        		answer++;
        		list.remove(cities[i]);
        		list.add(cities[i]);
        	}  else if(list.size() < cacheSize) {
        		list.add(cities[i]);
        		answer+=5;
        	} else if(list.size() == cacheSize) {
        		list.remove(0);
        		list.add(cities[i]);
        		answer+=5;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		String c[] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(3, c));
	}
}
