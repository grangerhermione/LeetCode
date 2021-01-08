package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/analyze-user-website-visit-pattern/
 * 
 * Analyze User Website Visit Pattern:
 * We are given some website visits: the user with name username[i] visited the website website[i] at 
 * time timestamp[i].

A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits. 
 (The websites in a 3-sequence are not necessarily distinct.)

Find the 3-sequence visited by the largest number of users. If there is more than one solution, 
return the lexicographically smallest such 3-sequence.


 */
public class AnalyzeUserWebsitePattern {
	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		List<Visit> users=new ArrayList<>();
		for(int i=0;i<username.length;i++){
			users.add(new Visit(username[i], timestamp[i], website[i]));
		}
		Collections.sort(users,(a,b)->a.timestamp-b.timestamp);
		Map<String, List<String>> userSiteMap=new HashMap<>();
		for(Visit v: users){
			if(userSiteMap.containsKey(v.username)){
				userSiteMap.get(v.username).add(v.website);
			}
			else{
				List<String> l=new ArrayList<>();
				l.add(v.website);
				userSiteMap.put(v.username, l);
			}
		}
		Map<List<String>, Integer> seqFreqMap=new HashMap<>();
		for(List<String> values: userSiteMap.values()){
			if(values.size()<3){
				continue;
			}
			Set<List<String>> set=new HashSet<>();
			for(int i=0;i<values.size();i++){
				for(int j=i+1;j<values.size();j++){
					for(int k=j+1;k<values.size();k++){
						List<String> l=new ArrayList<>();
						l.add(values.get(i));
						l.add(values.get(j));
						l.add(values.get(k));
						set.add(l);
					}
				}
			}

			for(List<String> l: set){
				seqFreqMap.put(l, seqFreqMap.getOrDefault(l, 0)+1);
			}

		}

		List<String> res= new ArrayList<>();
		int max=0;
		for(Map.Entry<List<String>,Integer> entry:seqFreqMap.entrySet()){
			if(entry.getValue() > max){
				max=entry.getValue();
				res=entry.getKey();
			}
			else if(entry.getValue() == max){
				if(entry.getKey().toString().compareTo(res.toString()) < 0){
					res=entry.getKey();
				}
			}
		}
		return res;
	}
}

class Visit{
	String username;
	int timestamp;
	String website;

	Visit(String username, int timestamp, String website){
		this.username=username;
		this.timestamp=timestamp;
		this.website=website;
	}
}
