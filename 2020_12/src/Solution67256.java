//https://programmers.co.kr/learn/courses/30/lessons/67256?language=java
import java.util.LinkedList;
import java.util.Queue;
public class Solution67256 {
	public static int arr[][] = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9},
			{10, 0, 11}
	};
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
	public static boolean vtd[][];
	public static Queue<int[]> q;
	public static int solve(int num) {
		int count = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			while(size > 0) {
				int tmp[] = q.poll();
				int x = tmp[0];
				int y = tmp[1];
				
				if(arr[x][y] == num) return count;
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx < 0 || ny < 0 || nx >= 4 || ny >= 3) continue;
					else {
						q.add(new int[] {nx, ny});
					}
				}
				size--;
			}
			count++;
		}
		return count;
	}
	
	public static void insert(int cur) {
		loop:for(int i = 0; i < 4; i++) {
			for(int j =0; j < 3; j++) {
				if(arr[i][j] == cur) {
					q.add(new int[] {i, j});
					break loop;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right"; 
		String answer =""; // test¿ë
		int left = 10;
		int right = 11;
		for(int i = 0; i < numbers.length; i++) {
			int num = numbers[i];
			
			if(num == 1 || num == 4 || num == 7) {
				answer += "L";
				left = num;
			} else if(num == 3 || num == 6 || num == 9) {
				answer += "R";
				right = num;
			} else {
				int leftLen = 0;
				int rightLen = 0;
				q = new LinkedList<int[]>();
				insert(left);
				leftLen = solve(num);
				
				q.clear();
				insert(right);
				rightLen = solve(num);
				
				if(leftLen == rightLen) {
					if(hand.equals("right")) {
						answer += "R";
						right = num;
					} else {
						answer += "L";
						left = num;
					}
				} else if(leftLen < rightLen) {
					left = num;
					answer += "L";
				} else {
					right = num;
					answer += "R";
				}
			}
		}
		
		System.out.println(answer); // test¿ë
	}
}
