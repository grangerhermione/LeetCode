package arrays;
/*
 * https://leetcode.com/problems/prison-cells-after-n-days/
 * 
 * Prison Cells After N Days:
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell 
becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't 
have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell 
is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days 
(and N such changes described above.)
 */
public class PrisonCellAfterNDays {
	public int[] prisonAfterNDays(int[] cells, int N) {
		int n=N%14;
		if(n==0){
			n=14;
		}
		for(int k=0;k<n;k++){
			int prev=cells[0];
			cells[0]=0;
			for(int i=1;i<cells.length-1;i++){
				if(prev==cells[i+1]){
					prev=cells[i];
					cells[i]=1;
				}
				else{
					prev=cells[i];
					cells[i]=0;
				}
			}
			cells[cells.length-1]=0;
		}
		return cells;

	}
}
