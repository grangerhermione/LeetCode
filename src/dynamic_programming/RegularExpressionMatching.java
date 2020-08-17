package dynamic_programming;
/*
 * https://leetcode.com/problems/regular-expression-matching/
 * Regular Expression Matching:
 * Given an input string (s) and a pattern (p), implement regular expression matching with 
 * support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if(s == null || p == null) {
			return false;
		}
		boolean[][] state = new boolean[s.length() + 1][p.length() + 1];
		state[0][0] = true;

		for (int j = 1; j < state[0].length; j++) {
			if (p.charAt(j - 1) == '*') {
				if (state[0][j - 1] || (j > 1 && state[0][j - 2])) {
					state[0][j] = true;
				}
			} 
		}
		for (int i = 1; i < state.length; i++) {
			for (int j = 1; j < state[0].length; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
					state[i][j] = state[i - 1][j - 1];
				}
				if (p.charAt(j - 1) == '*') {
					if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
						state[i][j] = state[i][j - 2];
					} else {
						state[i][j] = state[i - 1][j] || state[i][j - 1] || state[i][j - 2];
					}
				}
			}
		}
		return state[s.length()][p.length()];

	}
}
