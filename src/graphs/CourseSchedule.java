package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/course-schedule/
 * Course Schedule:
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?


 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses==0 || prerequisites.length==0 ){
			return true;
		}

		int visit[] = new int[numCourses];

		Map<Integer, List<Integer>> map=new HashMap<>();

		for(int i=0;i<prerequisites.length;i++){
			if(map.containsKey(prerequisites[i][1])){
				map.get(prerequisites[i][1]).add(prerequisites[i][0]);
			}
			else{
				List<Integer> arr=new ArrayList<>();
				arr.add(prerequisites[i][0]);
				map.put(prerequisites[i][1], arr);
			}
		}

		for(int i=0;i<numCourses;i++){
			if(!canFinish(i, visit, map)){
				return false;
			}
		}
		return true;
	}

	private boolean canFinish(int i, int[] visit, Map<Integer, List<Integer>> map ){
		if(visit[i]==-1){
			return false;
		}
		if(visit[i]==1){
			return true;
		}

		visit[i]=-1;

		if(map.containsKey(i)){
			for(Integer c: map.get(i)){
				if(!canFinish(c, visit, map)){
					return false;
				}
			}
		}
		visit[i]=1;
		return true;
	}
}
