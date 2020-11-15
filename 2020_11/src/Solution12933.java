import java.util.Arrays;

public class Solution12933 {

	public static void main(String[] args) {
		long n = 118372;
		long answer = 0;

		String str = String.valueOf(n);
		long arr[] = new long[str.length()];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Character.getNumericValue(str.charAt(i));
		}
		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();
		for(int i = arr.length-1; i >= 0; i--) 
			sb.append(arr[i]);
		
		answer = Long.parseLong(sb.toString());
		System.out.println(answer);
	}
}
