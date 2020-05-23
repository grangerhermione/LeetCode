package design;
/*
 * https://leetcode.com/problems/random-pick-with-weight/
 * Random Pick with Weight:
 * Given an array w of positive integers, where w[i] describes the weight of index i, 
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 */
public class RandomPickWithWeight {
	int[] cumulative;
    int sum;
    public RandomPickWithWeight(int[] w) {
        sum=0;
        cumulative=new int[w.length];
        for(int i=0;i<w.length;i++){
            sum+=w[i];
            cumulative[i]=sum;
        }
    }
    
    public int pickIndex() {
        double r=sum*Math.random();
        int index=-1;
        for(int i=0;i<cumulative.length;i++){
            if(r<cumulative[i]){
                return i;
            }
        }
        return index;
    }
}
