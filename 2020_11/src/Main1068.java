
//https://www.acmicpc.net/problem/1068
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1068 {
	public static int N, arr[], removeNode, root, count;
	public static boolean vtd[];
	public static LinkedList<Integer> list[];
	public static Queue<Integer> q;

	public static void remove() {
		while (!q.isEmpty()) {
			int x = q.poll();

			for (int i = 0; i < N; i++) {
				if (arr[i] == x && !vtd[i]) {
					q.add(i);
					vtd[i] = true;
				}
			}
		}
	}

	public static void solve() {
		q.add(root);
		vtd[root] = true;

		while (!q.isEmpty()) {
			int x = q.poll();
			boolean flag = false;
			for (int i : list[x]) {
				if (arr[i] == x && !vtd[i]) {
					q.add(i);
					vtd[i] = true;
					flag = true;
				}
			}
			if (!flag)
				count++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		list = new LinkedList[N];
		q = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			list[i] = new LinkedList();
		}
		removeNode = sc.nextInt();
		vtd = new boolean[N];
		count = 0;

		for (int i = 0; i < N; i++) {
			if (arr[i] == -1) {
				root = i;
			} else {
				list[i].add(arr[i]);
				list[arr[i]].add(i);
			}
		}

		q.add(removeNode);
		vtd[removeNode] = true;
		remove();
		if (!vtd[root]) {
			solve();
		}
		System.out.println(count);
	}
}
