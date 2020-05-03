/*
 *Given two binary strings, return their sum (also a binary string).
 *
 *The input strings are both non-empty and contains only characters 1 or 0.
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		int m=a.length();
		int n=b.length();

		StringBuilder sb=new StringBuilder();
		int i=m-1;
		int j=n-1;
		int carry=0;
		while(i>=0 || j>=0){
			if(i>=0 && a.charAt(i)=='1'){
				carry++;
			}
			if(j>=0 && b.charAt(j)=='1'){
				carry++;
			}

			if(carry%2==0){
				sb.append('0');
			}
			else{
				sb.append('1');
			}
			i--;
			j--;
			carry=carry/2;   
		}
		if(carry==1){
			sb.append('1');
		}

		return sb.reverse().toString();
	}
}
