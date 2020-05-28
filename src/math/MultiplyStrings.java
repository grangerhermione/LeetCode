package math;
/*
 * https://leetcode.com/problems/multiply-strings/
 * Multiply Strings:
 * Given two non-negative integers num1 and num2 represented as strings, 
 * return the product of num1 and num2, also represented as a string.
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		num1=new StringBuilder(num1).reverse().toString();
		num2=new StringBuilder(num2).reverse().toString();

		int mult[]=new int[num1.length()+num2.length()];
		for(int i=0;i<num1.length();i++){
			for(int j=0;j<num2.length();j++){
				mult[i+j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
			}
		}

		StringBuilder sb=new StringBuilder();
		int carry=0;
		for(int i=0;i<mult.length;i++){
			int sum=mult[i]+carry;
			carry=sum/10;
			sb.append(sum%10);
		}

		sb.reverse();
		while(sb.charAt(0)=='0' && sb.length()>1){
			sb.deleteCharAt(0);
		}
		return sb.toString();

	}
}
