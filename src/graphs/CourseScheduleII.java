package graphs;

import java.util.Arrays;
import java.util.LinkedList;

/*
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * Course Schedule II:
 * There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means 
you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, 
return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, 
return an empty array.


 */
public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if(prerequisites.length==0){
			int result[]=new int[numCourses];
			for(int i=0;i<numCourses;i++){
				result[i]=i;
			}
			return result;
		}

		int arr[]=new int[numCourses];
		Arrays.fill(arr,0);
		for(int i=0;i<prerequisites.length;i++){
			arr[prerequisites[i][0]]++;
		}
		LinkedList<Integer> queue=new LinkedList<>();
		for(int i=0;i<numCourses;i++){
			if(arr[i]==0){
				queue.add(i);
			}
		}

		int count=queue.size();

		int result[]=new int[numCourses];
		int k=0;
		while(!queue.isEmpty()){
			int e=queue.remove();
			result[k++]=e;
			for(int i=0;i<prerequisites.length;i++){
				if(prerequisites[i][1]==e){
					arr[prerequisites[i][0]]--;
					if(arr[prerequisites[i][0]]==0){
						queue.add(prerequisites[i][0]);
						count++;
					}
				}
			}
		}
		if(count==numCourses){
			return result;
		}                              
		return new int[0];                              

	}
}
