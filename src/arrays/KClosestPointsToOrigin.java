package arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * K Closest Points to Origin:
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 */
public class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int K) {
		if(points==null || points.length<K){
			return points;
		}
		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b){
				return Integer.compare(dist(b), dist(a));
			}

			private Integer dist(int[] p){
				return p[0]*p[0]+p[1]*p[1];
			}
		});

		for(int i=0;i<points.length;i++){
			pq.offer(points[i]);
			if(pq.size()>K){
				pq.poll();
			}
		}
		int result[][]=new int[K][2];
		for(int i=0;i<K;i++){
			int item[]=pq.poll();
			result[i][0]=item[0];
			result[i][1]=item[1];
		}
		return result;

	}
}
