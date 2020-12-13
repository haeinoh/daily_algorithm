import java.util.Arrays;

public class Solution12940 {

	public static void main(String[] args) {
		int n = 3;
		int m = 12;

		int answer[] = new int[2];
		int temp = 1;
		
		while(temp != 0) {
			temp = m % n;
			m = n;
			n = temp;
		}
		
		answer[0] = m;
		answer[1] = (n*m) / answer[0];
		System.out.println(Arrays.toString(answer));
	}
}
