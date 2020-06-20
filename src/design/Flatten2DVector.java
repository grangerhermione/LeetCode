package design;

import java.util.NoSuchElementException;
/*
 * https://leetcode.com/problems/flatten-2d-vector/
 * 
 * Flatten 2D Vector:
 * Design and implement an iterator to flatten a 2d vector. 
 * It should support the following operations: next and hasNext.
 */
public class Flatten2DVector {
	private int[][] vector;
	private int inner=0;
	private int outer=0;
	public Flatten2DVector(int[][] v) {
		vector=v;
	}

	public int next() {
		if (!hasNext()) throw new NoSuchElementException();
		return vector[outer][inner++];
	}

	public boolean hasNext() {
		while(outer<vector.length && inner==vector[outer].length){
			inner=0;
			outer++;
		}

		return outer<vector.length;
	}
}
