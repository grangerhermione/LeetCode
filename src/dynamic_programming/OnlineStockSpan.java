package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/online-stock-span/
 * 
 * Online Stock Span:
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns 
 * the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days 
(starting from today and going backwards) for which the price of the stock was less than or 
equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], 
then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 */
public class OnlineStockSpan {
	List<Integer> list;
	List<Integer> result;

	public OnlineStockSpan() {
		list=new ArrayList<>();
		result=new ArrayList<>();
	}

	public int next(int price) {
		if(list.size()==0){
			list.add(price);
			result.add(1);
			return 1;
		}
		int counter=1;
		int i= list.size();
		while(i-counter>=0 && price>=list.get(i-counter)){
			counter+=result.get(i-counter);
		}
		list.add(price);
		result.add(counter);
		return counter;
	}
}
