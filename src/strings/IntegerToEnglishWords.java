package strings;
import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/integer-to-english-words/
 * 
 * Integer to English Words:
 * Convert a non-negative integer to its english words representation. 
 * Given input is guaranteed to be less than 231 - 1.
 */
public class IntegerToEnglishWords {
	public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        StringBuilder sb=new StringBuilder();
        String suffix[]=new String[]{" Billion ", " Million ", " Thousand "};
        List<Integer> digits=new ArrayList<>();
        List<String> chunks=new ArrayList<>();
        while(num>=1){
            digits.add(num%10);
            num=num/10;
            if(digits.size()==3){
                int x=build(digits);
                chunks.add(convert(x));
                digits.clear();
            }
        }
        if(digits.size()>0){
            int x=build(digits);
            chunks.add(convert(x));
            digits.clear();
        }
        if(chunks.size()==4){
            int j=0;
            for(int i=chunks.size()-1;i>0;i--){
                if(!chunks.get(i).equals("")){
                    sb.append(chunks.get(i)+suffix[j++]);
                }
            }
            sb.append(chunks.get(0));
        }
        else if(chunks.size()==3){
            int j=1;
            for(int i=chunks.size()-1;i>0;i--){
                if(!chunks.get(i).equals("")){
                    sb.append(chunks.get(i)+suffix[j++]);
                }
            }
            sb.append(chunks.get(0));
        }
        else if(chunks.size()==2){
            int j=2;
            for(int i=chunks.size()-1;i>0;i--){
                if(!chunks.get(i).equals("")){
                    sb.append(chunks.get(i)+suffix[j++]);
                }
            }
            sb.append(chunks.get(0));
        }
        else if(chunks.size()==1){
            if(!chunks.get(0).equals("")){
                sb.append(chunks.get(0));
            }
        }
        
        
        return sb.toString().trim();
    }
    
    private int build(List<Integer> digits){
        int pre=1;
        int result=0;
        for(int i=0;i<digits.size();i++){
            result+=digits.get(i)*pre;
            pre*=10;
        }
        
        return result;
    }
    
    private String convert(int three){
        StringBuilder sb=new StringBuilder();
        String tens[]=new String[]{" Twenty", " Thirty", " Forty"," Fifty"," Sixty"," Seventy"," Eighty", " Ninety"};
        String ones[]=new String[]{" One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"};
        String eleven[]=new String[]{" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        
        List<Integer> digits=new ArrayList<>();
        while(three>=1){
            digits.add(three%10);
            three=three/10;
        }
        if(digits.size()==3){
            int first=digits.get(2);
            int second=digits.get(1);
            int third=digits.get(0);
            if(first!=0){
                sb.append(ones[first-1]+" Hundred");
            }
            if(second==0){
                if(third!=0){
                    sb.append(ones[third-1]);
                }
            }
            else if(second==1){
                sb.append(eleven[third]);
            }
            else if(second>1){
                sb.append(tens[second-2]);
                if(third!=0){
                    sb.append(ones[third-1]);
                }
            }
        }
        else if(digits.size()==2){
            int first=digits.get(1);
            int second=digits.get(0);
            
            if(first==0){
                if(second!=0){
                    sb.append(ones[second-1]);
                }
            }
            else if(first==1){
                sb.append(eleven[second]);
            }
            else if(first>1){
                sb.append(tens[first-2]);
                if(second!=0){
                    sb.append(ones[second-1]);
                }
            }
        }
        else if(digits.size()==1){
            int first=digits.get(0);
            if(first!=0){
                sb.append(ones[first-1]);
            }
        }
        return sb.toString().trim();
    }
}
