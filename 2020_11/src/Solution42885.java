import java.util.Arrays;

public class Solution42885 {

	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		
		boolean vtd[] = new boolean[people.length];
		
		int limit = 100;
		int answer = 0;
		
		for(int i = 0; i < people.length; i++) {
			if(!vtd[i]) {
				boolean flag = false;
				for(int j = people.length-1; j > i; j--) {
					if(!vtd[j]) {
						if(people[i] + people[j] <= limit) {
							vtd[i] = true;
							vtd[j] = true;
							flag = true;
							answer++;
							break;
						}
					}
				}
				if(!flag) answer++;
			}
		}
	
		
		System.out.println(answer);
	}
}
