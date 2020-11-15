import java.util.Arrays;
import java.util.Scanner;

public class Main3019 {
	public static int C, P, arr[][], height[];
	
	public static int solve(String str) {
		int count = 0;
		int tmp[] = new int[str.length()];
		for(int i = 0; i < tmp.length; i++) 
			tmp[i] = Character.getNumericValue(str.charAt(i));
		
		System.out.println(Arrays.toString(tmp));
		System.out.println("=======================");
		for(int i = 0; i <= C-tmp.length; i++) {
			int num = height[i];
			System.out.println("緋 " + i + " ====== "+ num);
			boolean flag = false;
			loop:for(int j = 0; j < tmp.length; j++) {
				if(num > 0) {
					System.out.println("j " + arr[num-1+tmp[j]][i+j]);
					if(arr[num-1+tmp[j]][i+j] == 1) continue;
					else {
						flag = true;
						break loop;
					}
				}
			}
			if(!flag) count++;
			System.out.println("/// " + flag + " " +count);
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		P = sc.nextInt();
		
		arr = new int[105][C];
		height = new int[C];
		
		for(int i = 0; i < C; i++) {
			height[i] = sc.nextInt(); 
			for(int j = 0; j <= height[i] - 1; j++) {
				arr[j][i]++;
			}
		}
		
		int answer = 0;
		
		switch(P) {
			case 1:
				answer += solve("0");
				answer += solve("0000");
				break;
			case 2:
				answer += solve("00");
				break;
			case 3: 
				answer += solve("001");
				answer += solve("10");
				break;
			case 4:
				answer += solve("100");
				answer += solve("01");
				break;
			case 5:
				answer += solve("000"); // で
				answer += solve("10"); // っ
				answer += solve("101"); // ぬ
				answer += solve("01"); // た
				break;
			case 6:
				answer += solve("000");
				answer += solve("20");
				answer += solve("011");
				answer += solve("00");
				break;
			case 7:
				answer += solve("000");
				answer += solve("00");
				answer += solve("110");
				answer += solve("02");
				break;
		}
		System.out.println(answer);
	}
}
