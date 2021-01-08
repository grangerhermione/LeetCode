package sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/search-suggestions-system/
 * 
 * Search Suggestions System:
 * Given an array of strings products and a string searchWord. We want to design a system that 
 * suggests at most three product names from products after each character of searchWord is typed. 
 * Suggested products should have common prefix with the searchWord. If there are more than three 
 * products with a common prefix return the three lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed. 
 */
public class SearchSuggestionsSystem {
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Arrays.sort(products);
		List<List<String>> result=new ArrayList<>();
		for(int i=1;i<searchWord.length()+1;i++){
			String str=searchWord.substring(0,i);
			List<String> temp=new ArrayList<>();
			int count=0;
			for(String product: products){
				if(product.startsWith(str)){
					temp.add(product);
					count++;
				}
				if(count>=3){
					break;
				}
			}
			result.add(temp);
		}
		return result;
	}
}
