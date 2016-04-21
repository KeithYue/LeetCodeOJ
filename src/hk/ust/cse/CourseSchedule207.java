package hk.ust.cse;

import java.util.*;

public class CourseSchedule207 {
	public static void main(String [] args){
		int [][] test = {{0,1}, {1,0}};
		System.out.println(new CourseSchedule207().canFinish(2, test));
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// the same as judging whether a graph is acyclic
		// build the hash map for graph
		boolean is_cycle = false;
		HashMap<Integer, List<Integer>> g = buildFromEdgelist(prerequisites);
		// System.out.println(g);
		HashMap<Integer, Integer> d = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> f = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> color = new HashMap<Integer, Integer>();
		// initialize the array
		HashSet<Integer> nodes = new HashSet<Integer>();
		for (int i = 0; i < prerequisites.length; i++) {
			color.put(prerequisites[i][0], -1);
			color.put(prerequisites[i][1], -1);
			nodes.add(prerequisites[i][0]);
			nodes.add(prerequisites[i][1]);
		}
		int[] time = { 0 };
		for (Integer node : nodes) {
			if (color.get(node) == -1) {
				DFS(g, node, d, f, color, time);
			}
		}

		// test whether there is a cycle
		for (int i = 0; i < prerequisites.length; i++) {
			Integer start = prerequisites[i][0];
			Integer end = prerequisites[i][1];
			if (d.get(start) >= d.get(end) && f.get(start) <= f.get(end)) {
				is_cycle = true;
			}
		}
		// System.out.println(d);
		// System.out.println(f);
		// System.out.println(color);

		if (is_cycle) {
			return false;
		} else {
			return true;
		}
	}

	public void DFS(HashMap<Integer, List<Integer>> g, Integer node, HashMap<Integer, Integer> d,
			HashMap<Integer, Integer> f, HashMap<Integer, Integer> color,
			int[] time) {
		time[0] = time[0] + 1;
		d.put(node, time[0]);
		color.put(node, 0);
		if (g.containsKey(node)) {
			for (Integer neighbor : (List<Integer>) g.get(node)) {
				if (color.get(neighbor) == -1) {
					// System.out.println("I am here");
					DFS(g, neighbor, d, f, color, time);
				}
			}

		}
		color.put(node, 1);
		time[0] = time[0] + 1;
		f.put(node, time[0]);
	}

	public HashMap<Integer, List<Integer>> buildFromEdgelist(int[][] edges) {
		// build a graph from edges
		HashMap<Integer, List<Integer>> g = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < edges.length; i++) {
			if (g.containsKey(edges[i][0])) {
				List<Integer> c = (List<Integer>) g.get(edges[i][0]);
				c.add(edges[i][1]);
				g.put(edges[i][0], c);
			} else {
				List<Integer> l = new ArrayList<Integer>();
				l.add(edges[i][1]);
				g.put(edges[i][0], l);
			}
		}
		return g;
	}
}
