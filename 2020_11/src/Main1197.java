// 최소 스패닝 트리
// https://www.acmicpc.net/problem/1197
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Graph implements Comparable<Graph> {
	int start;
	int end;
	int weight;

	Graph(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Graph o) {
		return this.weight - o.weight;
	}
}

public class Main1197 {
	public static int V, E, parent[], result;
	public static List<Graph> list;

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}

	public static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList<Graph>();
		parent = new int[V+1];
		result = 0;
		for(int i = 1; i <= V; i++) parent[i] = i;
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Graph(start, end, weight));
		}

		Collections.sort(list);

		for(int i = 0; i < list.size(); i++) {
			int start = list.get(i).start;
			int end = list.get(i).end;
			if(find(start) != find(end)) {
				union(start, end);
				result += list.get(i).weight;
			}
		}
		
		System.out.println(result);
	}
}
