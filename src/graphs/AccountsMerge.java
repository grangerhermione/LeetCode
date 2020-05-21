package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 * https://leetcode.com/problems/accounts-merge/
 * Accounts Merge:
 * Given a list accounts, each element accounts[i] is a list of strings, 
 * where the first element accounts[i][0] is a name, and the rest of the elements are emails 
 * representing emails of the account.
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person 
 * if there is some email that is common to both accounts. Note that even if two accounts have the 
 * same name, they may belong to different people as people could have the same name. 
 * A person can have any number of accounts initially, but all of their accounts definitely have 
 * the same name.
 * After merging the accounts, return the accounts in the following format: 
 * the first element of each account is the name, and the rest of the elements are emails in 
 * sorted order. The accounts themselves can be returned in any order.
 */
public class AccountsMerge {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName=new HashMap<>();
        Map<String, List<String>> graph=new HashMap<>();
        
        for(List<String> account:accounts){
            String name ="";
            for(int i=0;i<account.size();i++){
                if(i==0){
                    name = account.get(i);
                    continue;
                }
                String email = account.get(i);
                emailToName.put(email, name);
                graph.computeIfAbsent(email, u -> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), u -> new ArrayList<String>()).add(email);
            }
        }
        List<List<String>> result=new ArrayList<>();
        Set<String> visited =new HashSet<>();
        for(String email: graph.keySet()){
            if(!visited.contains(email)){
                visited.add(email);
                Stack<String> stack = new Stack<>();
                List<String> component= new ArrayList<>();
                
                stack.push(email);
                while(!stack.isEmpty()){
                    String element=stack.pop();
                    component.add(element);
                    for(String value: graph.get(element)){
                        if(!visited.contains(value)){
                            visited.add(value);
                            stack.push(value);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                result.add(component);
            }
        }
        return result;
        
    }
}
