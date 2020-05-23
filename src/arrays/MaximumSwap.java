package arrays;
/*
 * https://leetcode.com/problems/maximum-swap/solution/
 * Maximum Swap:
 * Given a non-negative integer, you could swap two digits at most once to get the maximum 
 * valued number. Return the maximum valued number you could get.
 */
public class MaximumSwap {
	public int maximumSwap(int num) {
		char A[]=Integer.toString(num).toCharArray();
		int[] index=new int[10];
		for(int i=0;i<A.length;i++){
			index[A[i]-'0']=i;
		}

		for(int i=0;i<A.length;i++){
			for(int j=9;j>A[i]-'0';j--){
				if(index[j]>i){
					char temp=A[i];
					A[i]=A[index[j]];
					A[index[j]]=temp;
					return Integer.valueOf(new String(A));
				}
			}
		}
		return num;
	}
}
