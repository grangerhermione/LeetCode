package recursion_backtracking;
/*
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 * 
 * Strobogrammatic Number II:
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees 
 * (looked at upside down).
 * Find all strobogrammatic numbers that are of length = n.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII {
	List<String> result = new ArrayList<>();
	Map<Character, Character> mapper = new HashMap<>();
	public List<String> findStrobogrammatic(int n) {

		mapper.put('0', '0');
		mapper.put('1', '1');
		mapper.put('6', '9');
		mapper.put('8', '8');
		mapper.put('9', '6');

		// Edge case
		if (n == 1) {
			result.add("0");
		}

		char[] array = new char[n];

		helper(0, n - 1, array);

		return result;
	}

	void helper(int i, int j, char[] array) {
		if (i > j) {
			result.add(String.valueOf(array));
			return;
		}

		for (char ch : mapper.keySet()) {
			// Number can't start with 0
			if (i == 0 && ch == '0') {
				continue;
			}

			// The number in the middle
			if (i == j && ch != mapper.get(ch)) {
				continue;
			}

			array[i] = ch;
			array[j] = mapper.get(ch);

			helper(i + 1, j - 1, array);
		}
	}

}
