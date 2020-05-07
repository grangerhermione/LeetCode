package strings;
/*
 * https://leetcode.com/problems/validate-ip-address/
 * Validate IP Address:
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 */
public class ValidateIPAddress {
	public String validIPAddress(String IP) {
		String[] tokens=IP.split("\\.");
		if(tokens.length==1){
			//Ipv6
			tokens=IP.split(":");

			if(IP.chars().filter(ch -> ch==':').count()!=7){
				return "Neither";
			}
			return (validatev6(tokens)?"IPv6":"Neither");
		}
		else{
			//IPv4
			if(IP.chars().filter(ch -> ch=='.').count()!=3){
				return "Neither";
			}
			return (validatev4(tokens)?"IPv4":"Neither");
		}
	}
	private boolean validatev4(String[] tokens){
		if(tokens.length!=4){
			return false;
		}
		for(String token:tokens){
			if(token.length()>3 || token.length()<1){
				return false;
			}
			if((token.startsWith("0") && token.length()!=1)|| token.equals("")){
				return false;
			}
			for(char c: token.toCharArray()){
				if(!(c>='0' && c<='9')){
					return false;
				}
			}
			Integer x=Integer.parseInt(token);
			if(x<0 || x>255){
				return false;
			}

		}
		return true;
	}
	private boolean validatev6(String[] tokens){
		if(tokens.length!=8){
			return false;
		}
		for(String token:tokens){
			if (token.length() == 0 || token.length() > 4){
				return false;
			}
			for(char c: token.toCharArray()){
				if(!isValid(c)){
					return false;
				}
			}

		}
		return true;
	}

	private boolean isValid(char c){
		if( (c>='0' && c<='9') ||(c>='a' && c<='f') ||(c>='A' && c<='F')){
			return true;
		}
		return false;
	}
}
