package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MaxSum {
	//result
	int max = Integer.MIN_VALUE; 
	public int maxSum(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int lastPlus = -1;
		List<String> ops = new ArrayList<String>();
		//string process
		for(int i = 0; i < str.length(); i++) {
			if(Character.isLetter(str.charAt(i))) {
				map.put(str.charAt(i), null);
			}
			else if(str.charAt(i) == '+'){
				ops.add(str.substring(lastPlus + 1, i));
				lastPlus = i;
			}
			else {
				ops.add(str.substring(lastPlus + 1, i));
				ops.add(str.substring(i + 1));
			}
		}
		//brute force to get all possible result
		dfs(map, new HashSet<Integer>(), ops, 0);
		//return maximum result
		return max;
	}
	
	private void dfs(HashMap<Character, Integer> map, HashSet<Integer> set, List<String> ops, int size) {
		if(size == map.size()) {
			int add = 0;
			for(int i = 0; i < ops.size() - 1; i++) {
				add += getVal(map, ops.get(i));
			}
			int sum = getVal(map, ops.get(ops.size() - 1));
			if(sum == add) {
				max = Math.max(max, sum);
				//for debug, ignore this
				for(char key : map.keySet()) {
					// System.out.println(key + ":" + map.get(key));
				}
				// System.out.println(sum);
			}
			return;
		}
		for(char key : map.keySet()) {
			Integer val = map.get(key);
			if(val != null) {
				continue;
			}
			for(int i = 0; i <= 9; i++) {
				if(set.contains(i)) {
					continue;
				}
				map.put(key, i);
				set.add(i);
				dfs(map, set, ops, size + 1);
				set.remove(i);
				map.put(key, null);
			}
		}
	}
	
	private int getVal(HashMap<Character, Integer> map, String op) {
		int res = 0;
		for(int i = 0; i < op.length(); i++) {
			res = res * 10 + (int)map.get(op.charAt(i));
		}
		return res;
	}
	
	public static void main(String[] args) {
		MaxSum test = new MaxSum();
		int res = test.maxSum("A+B=C");
		System.out.println(res);
	}
	
}
