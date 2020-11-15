import java.util.Scanner;

public class Main3019 {
	public static int C, P, arr[][], height[];
	
	public static int solve(int tmp[]) {
		int count = 0;
		
		// üũ�ؾ��ϴ� ��Ʈ���� ���̸�ŭ ���� ���
		for(int i = 0; i <= C-tmp.length; i++) {
			int num = height[i];
			int cnt = 0;
			
			for(int j = 0; j < tmp.length-1; j++) {
				if(tmp[0] >= tmp[j+1]) { // ���� ���̰� ���� ���̺��� ũ�ų� ���� ��
					int xx = tmp[0] - tmp[j+1];
					if(num - xx >= 0) {
						if(arr[num-xx][i+j+1] == 0) {
							if(num-xx-1 == -1) cnt++; // ������ ����� ���
							if(num-xx-1 >= 0 && arr[num-xx-1][i+j+1] == 1) cnt++;
						}
					}
				} else { // ���� ���̰� ���� ���̺��� ���� ��
					int xx = tmp[0] + tmp[j+1];
					if(num + xx >= 0) {
						if(arr[num+xx][i+j+1] == 0) {
							if(num+xx-1 >= 0 && arr[num+xx-1][i+j+1] == 1) cnt++;
						}
					}
				}
			}
			if(cnt == (tmp.length-1)) count++;
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
				answer += solve(new int[] {0});
				answer += solve(new int[] {0, 0, 0, 0});
				break;
			case 2:
				answer += solve(new int[] {0, 0});
				break;
			case 3: 
				answer += solve(new int[] {0, 0, 1});
				answer += solve(new int[] {1, 0});
				break;
			case 4:
				answer += solve(new int[] {1, 0, 0});
				answer += solve(new int[] {0, 1});
				break;
			case 5:
				answer += solve(new int[] {0, 0, 0}); // ��
				answer += solve(new int[] {1, 0}); // ��
				answer += solve(new int[] {1, 0, 1}); // ��
				answer += solve(new int[] {0, 1}); // ��
				break;
			case 6:
				answer += solve(new int[] {0, 0, 0});
				answer += solve(new int[] {2, 0});
				answer += solve(new int[] {0, 1, 1});
				answer += solve(new int[] {0, 0});
				break;
			case 7:
				answer += solve(new int[] {0, 0, 0});
				answer += solve(new int[] {0, 0});
				answer += solve(new int[] {1, 1, 0});
				answer += solve(new int[] {0, 2});
				break;
		}
		System.out.println(answer);
	}
}
