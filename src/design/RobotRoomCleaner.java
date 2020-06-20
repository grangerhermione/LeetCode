package design;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/robot-room-cleaner/
 * 
 * Robot Room Cleaner:
 * Given a robot cleaner in a room modeled as a grid.

Each cell in the grid can be empty or blocked.

The robot cleaner with 4 given APIs can move forward, turn left or turn right. 
Each turn it made is 90 degrees.

When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it 
stays on the current cell.
 */
public class RobotRoomCleaner {
	Set<Pair> visited=new HashSet<>();
	int dx[]=new int[]{-1, 0, 1, 0};
	int dy[]=new int[]{0, 1, 0, -1};
	Robot robot;
	public void cleanRoom(Robot robot) {
		this.robot=robot;
		backtrack(0,0,0);
	}


	private void backtrack(int row, int col, int d){
		visited.add(new Pair(row, col));
		robot.clean();
		for(int i=0;i<4;i++){
			int newD=(d+i)%4;
			int r=row+dx[newD];
			int c=col+dy[newD];

			if(!visited.contains(new Pair(r,c)) && robot.move()){
				backtrack(r,c,newD);
				goBack();
			}

			robot.turnRight();
		}
	}

	private void goBack() {
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}

	class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}

		@Override
		public int hashCode() {
			return (this.x + ":" + this.y).hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Pair))
				return false;
			if (obj == this)
				return true;

			Pair r = (Pair) obj;
			return (this.x==r.x) && (this.y==r.y);
		}
	}

}

interface Robot {
	// Returns true if the cell in front is open and robot moves into the cell.
	// Returns false if the cell in front is blocked and robot stays in the current cell.
	public boolean move();

	// Robot will stay in the same cell after calling turnLeft/turnRight.
	// Each turn will be 90 degrees.
	public void turnLeft();
	public void turnRight();

	// Clean the current cell.
	public void clean();
}
