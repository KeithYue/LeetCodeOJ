package hk.ust.cse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule210 {
	public static void main(String[] args){
		int [][] a = {
				{0,1}
		};
		int[] result = (new CourseSchedule210()).findOrder(3, a);
		System.out.println(result);
	}
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// the same as judging whether a graph is acyclic
		// build the hash map for graph
		boolean is_cycle = false;
		
		// initialize the random order
		int[] topologicalOrder = new int[numCourses];
		for (int i = 0; i < topologicalOrder.length; i++) {
			topologicalOrder[i] = i;
			// System.out.println(i + " " + topologicalOrder[i]);
		}
		if(prerequisites.length == 0){
			return topologicalOrder;
		}

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
		
		// initialize the finish time 
		for(int i =0;i<numCourses;i++){
			f.put(i, 0);
		}
		int[] time = { 0 };
		for (Integer node : nodes) {
			if (color.get(node) == -1) {
				DFS(g, node, d, f, color, time);
			}
		}

		// test whether there is a cycle
		for (int i = 0; i < prerequisites.length; i++) {
			Integer start = prerequisites[i][1];
			Integer end = prerequisites[i][0];
			if (d.get(start) >= d.get(end) && f.get(start) <= f.get(end)) {
				is_cycle = true;
			}
		}
		// System.out.println(d);
		// System.out.println(f);
		// System.out.println(color);

		if (is_cycle) {
			// System.out.println("there is a cycle");
			int  [] a = new int [0];
			return a;
		} else {
			// sort nodes by finish time
			// bubble sort
			// for (int i = 0; i < topologicalOrder.length ; i++) {
			// 	for (int j = i; j < topologicalOrder.length-1; j++) {
			// 		if (f.get(j) < f.get(j + 1)) {
			// 			// System.out.println(j);
			// 			// System.out.println(j+1);
			// 			int tmp = topologicalOrder[j+1];
			// 			topologicalOrder[j+1] = topologicalOrder[j];
			// 			topologicalOrder[j] = tmp;
			// 		}
			// 	}
			// }
			// for(int i =0;i<topologicalOrder.length;i++){
			// 	System.out.print(topologicalOrder[i] + " ");
			// }
			// System.out.println();
			int [] r = new int[topologicalOrder.length];
			mergesort(topologicalOrder, r, f, 0,topologicalOrder.length);
			for(int i =0;i<r.length;i++){
				System.out.print(r[i] + " ");
			}
			System.out.println();
			return r;
		}
	}
	
	public void mergesort(int [] a, int [] b,HashMap<Integer, Integer> f,int start, int end ){
		if(start == end - 1){
			return;
		}
		int middle = (start+end)/2;
		mergesort(a,b,f, start,middle);
		mergesort(a,b,f, middle, end);
		// merge
		int i=start,j=middle,k=start;
		while(i<middle && j < end){
			if(f.get(a[i]) > f.get(a[j])){
				b[k] = a[i];
				i++;
			}else{
				b[k] = a[j];
				j++;
			}
			k ++;
		}
		while(i<middle){
			b[k] = a[i];
			k++;
			i++;
		}
		while(j<end){
			b[k] = a[j];
			k++;
			j++;
		}
		// copy back to a
		for(i = start;i < end;i++){
			a[i] = b[i];
		}
	}
	

	public void DFS(HashMap<Integer, List<Integer>> g, Integer node,
			HashMap<Integer, Integer> d, HashMap<Integer, Integer> f,
			HashMap<Integer, Integer> color, int[] time) {
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
			if (g.containsKey(edges[i][1])) {
				List<Integer> c = (List<Integer>) g.get(edges[i][1]);
				c.add(edges[i][0]);
				g.put(edges[i][1], c);
			} else {
				List<Integer> l = new ArrayList<Integer>();
				l.add(edges[i][0]);
				g.put(edges[i][1], l);
			}
		}
		return g;
	}

}
