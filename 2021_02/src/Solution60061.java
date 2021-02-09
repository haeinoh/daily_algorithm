//https://programmers.co.kr/learn/courses/30/lessons/60061
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution60061 {
	public static int N, arr[][][];

	static class Robot {
		int x;
		int y;
		int str;

		public Robot(int x, int y, int str) {
			this.x = x;
			this.y = y;
			this.str = str;
		}
	}
	public static boolean isGidung(int x, int y) {
		if(x < 0 || y < 0 || x > N || y > N || arr[x][y][0] == 0) return false;
		return true;
	}

	public static boolean isBo(int x, int y) {
		if(x < 0 || y < 0 || x > N || y > N || arr[x][y][1] == 0) return false;
		return true;
	}


	public static boolean solveGidung(int x, int y) { // 바닥 / 또 다른 기둥 위 / 보 그 위에 / 보의 한 쪽 끝 부분
		return (y == 0 || isGidung(x, y-1) || isBo(x, y) || isBo(x-1, y));
	}

	public static boolean solveBo(int x, int y) { // 기둥 위 / 기둥 바로 위 / 기둥 끝쪽으로 / 양쪽 끝이 서로 다른 보 일 때
		return (isGidung(x, y-1) || isGidung(x,y) || isGidung(x+1, y-1) || (isBo(x-1, y) && isBo(x+1, y)));
	}

	public static int[][] solution(int n, int[][] build_frame) {
		N = n+1;
		arr = new int[N][N][2];

		for(int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int a = build_frame[i][2];
			int b = build_frame[i][3];

			if(a == 0) { // 기둥
				if(b == 1) { // 설치
					if(solveGidung(x,y)) arr[x][y][0] = 1;
				} else {
					if(arr[x][y][0] == 0) continue;
					arr[x][y][0] = 0;
					if((isGidung(x, y+1) && !solveGidung(x, y+1)) // (1) 위에 기둥인데 기둥을 만들 수 없을 때
							|| (isBo(x, y+1) && !solveBo(x, y+1)) // (2) 위에 보인데 보를 만들 수 없을 때
							// || (isBo(x,y) && !solveBo(x,y)) // (3) 현재 보인데 보를 만들 수 없을 때
							|| (isBo(x-1, y+1) && !solveBo(x-1, y+1)) // (3) 위의 오른쪽 보를 만들 수 없을 때
					) arr[x][y][0] = 1;
				}
			} else { // 보
				if(b == 1) {
					if(solveBo(x, y)) arr[x][y][1] = 1;
				} else {
					if(arr[x][y][1] == 0) continue;
					arr[x][y][1] = 0;
					if((isGidung(x,y) && !solveGidung(x,y)) // (1) 현재 좌표에 기둥이 있는데 기둥을 만들 수 없는 경우
							|| (isGidung(x+1, y) && !solveGidung(x+1, y)) // (2) 오른쪽에 기둥이 있는데 기둥을 만들 수 없는 경우
							|| (isBo(x-1, y) && !solveBo(x-1, y)) // (3) 왼쪽에 보가 있는데 보를 만들 수 없는 경우
							|| (isBo(x+1, y) && !solveBo(x+1, y)) // (4) 오른쪽에 보가 있는데 보를 만들 수 없는 경우
					)arr[x][y][1] = 1;

				}
			}
		}

		ArrayList<Robot> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j][0] != 0) list.add(new Robot(i, j, 0));
				if(arr[i][j][1] != 0) list.add(new Robot(i, j, 1));
			}
		}

		int[][] answer = new int[list.size()][3];

		for(int i = 0; i < list.size(); i++) {
			answer[i][0] = list.get(i).x;
			answer[i][1] = list.get(i).y;
			answer[i][2] = list.get(i).str;
		}

		Arrays.sort(answer, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0] && o1[1] != o2[1]) return o1[1] - o2[1];
				else if(o1[0] == o2[0] && o1[1] == o2[1]) return o1[2] - o2[2];
				return o1[0] - o2[0];
			}
		});
		return answer;

    }

    public static void main(String[] args) {
//    	int b[][] = {
//	    	{1,0,0,1},
//	    	{1,1,1,1},
//	    	{2,1,0,1},
//	    	{2,2,1,1},
//	    	{5,0,0,1},
//	    	{5,1,0,1},
//	    	{4,2,1,1},
//	    	{3,2,1,1}
//    	};
    	
    	int b[][] = {
    			{0,0,0,1},
    			{2,0,0,1},
    			{4,0,0,1},
    			{0,1,1,1},
    			{1,1,1,1},
    			{2,1,1,1},
    			{3,1,1,1},
    			{2,0,0,0},
    			{1,1,1,0},
    			{2,2,0,1}
    	};
    	
    	int r[][] = solution(5, b);
    	for(int p[]: r) System.out.println(Arrays.toString(p));
	}
}
