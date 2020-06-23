package strings;

/*
 * https://leetcode.com/problems/integer-to-english-words/
 * 
 * Integer to English Words:
 * Convert a non-negative integer to its english words representation. 
 * Given input is guaranteed to be less than 231 - 1.
 */
public class IntegerToEnglishWords {
	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";

		int billion=num/1000000000;
		int million=(num-(billion*1000000000))/1000000;
		int thousand=(num-billion*1000000000-million*1000000)/1000;
		int rest=num-billion*1000000000-million*1000000-thousand*1000;

		StringBuilder sb=new StringBuilder();
		if(billion!=0){
			sb.append(build(billion));
			sb.append(" Billion");
		}
		if(million!=0){
			if(sb.length()!=0){
				sb.append(" ");
			}
			sb.append(build(million));
			sb.append(" Million");
		}
		if(thousand!=0){
			if(sb.length()!=0){
				sb.append(" ");
			}
			sb.append(build(thousand));
			sb.append(" Thousand");
		}
		if(rest!=0){
			if(sb.length()!=0){
				sb.append(" ");
			}
			sb.append(build(rest));
		}
		return sb.toString();
	}

	private String build(int num){
		String ones[]=new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
		String tens[]=new String[]{"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
		String teens[]=new String[]{"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		int first=num/100;
		int second=(num-(first*100))/10;
		int last=num-(first*100)-(second*10);

		StringBuilder sb=new StringBuilder();
		if(first!=0){
			sb.append(ones[first-1]).append(" Hundred");
		}
		if(second!=0){
			if(sb.length()!=0){
				sb.append(" ");
			}
			if(second!=1){
				sb.append(tens[second-1]);
			}
			else{
				if(last!=0){
					sb.append(teens[last-1]);
				}
				else{
					sb.append(tens[0]);
				}
				return sb.toString();
			}
		}
		if(last!=0){
			if(sb.length()!=0){
				sb.append(" ");
			}
			sb.append(ones[last-1]);
		}
		return sb.toString();
	}
}
