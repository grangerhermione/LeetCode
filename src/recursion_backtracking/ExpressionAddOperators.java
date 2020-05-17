package recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/expression-add-operators/
 * Expression Add Operators:
 * Given a string that contains only digits 0-9 and a target value, return all possibilities 
 * to add binary operators (not unary) +, -, or * between the digits so they evaluate to the 
 * target value.
 */
public class ExpressionAddOperators {

	int target;
	String num;
	List<String> result;

	public List<String> addOperators(String num, int target) {
		result=new ArrayList<>();
		if(num.length()==0){
			return result;
		}
		this.target= target;
		this.num=num;


		recurse(0,0,0,0,new ArrayList<String>());
		return result;
	}

	private void recurse(int index, long current, long prev, long value, List<String> ops){
		if(index==num.length()){
			if(value==target && current==0){
				StringBuilder sb=new StringBuilder();
				ops.subList(1,ops.size()).forEach(v->sb.append(v));
				result.add(sb.toString());
			}
			return;
		}

		current=current*10+num.charAt(index)-'0';
		String currString=Long.toString(current);

		if(current>0){
			recurse(index+1, current, prev, value, ops);
		}

		ops.add("+");
		ops.add(currString);
		recurse(index+1, 0, current, value+current, ops);
		ops.remove(ops.size()-1);
		ops.remove(ops.size()-1);

		if(ops.size()>0){
			ops.add("-");
			ops.add(currString);
			recurse(index+1, 0, -current, value-current, ops);
			ops.remove(ops.size()-1);
			ops.remove(ops.size()-1);

			ops.add("*");
			ops.add(currString);
			recurse(index+1, 0, current*prev, value-prev+(current*prev), ops);
			ops.remove(ops.size()-1);
			ops.remove(ops.size()-1);

		}

	}
}
