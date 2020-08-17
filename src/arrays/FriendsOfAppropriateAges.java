package arrays;
/*
 * https://leetcode.com/problems/friends-of-appropriate-ages/
 * Friends Of Appropriate Ages:
 * Some people will make friend requests. The list of their ages is given and ages[i] is the 
 * age of the ith person. 

Person A will NOT friend request person B (B != A) if any of the following conditions are true:

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
Otherwise, A will friend request B.

Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.

How many total friend requests are made?
 */
public class FriendsOfAppropriateAges {
	public int numFriendRequests(int[] ages) {
		int[] count = new int[121];
		for (int age: ages) {
			count[age]++;
		}

		int ans = 0;
		for (int ageA = 0; ageA <= 120; ageA++) {
			int countA = count[ageA];
			for (int ageB = 0; ageB <= 120; ageB++) {
				int countB = count[ageB];
				if (ageA * 0.5 + 7 >= ageB) continue;
				if (ageA < ageB) continue;
				if (ageA < 100 && 100 < ageB) continue;
				ans += countA * countB;
				if (ageA == ageB) ans -= countA;
			}
		}

		return ans;
	}
}
