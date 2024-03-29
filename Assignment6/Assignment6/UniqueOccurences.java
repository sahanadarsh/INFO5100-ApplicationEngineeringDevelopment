package Assignment6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*Given an array of integers arr, write a function that returns true if and only 
 * if the number of occurrences of each value in the array is unique.
 *  Example 1:

    Input: arr = [1,2,2,1,1,3]
    Output: true
    Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. 
    No two values have the same number of occurrences.

    Example 2:

    Input: arr = [1,2]
    Output: false
    Example 3:

    Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
    Output: true

    Constraints:

    1 <= arr.length <= 1000
    -1000 <= arr[i] <= 1000

 */

public class UniqueOccurences {

	public static boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i < arr.length; i++) {
			int n = arr[i];
			map.put(n,map.getOrDefault(n, 0) + 1);
		}
		Set<Integer> set = new HashSet<>();
		for(int i: map.keySet()) {
			if(!set.add(map.get(i))){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,2,1,1,3};
		System.out.println(uniqueOccurrences(arr));
	}
}
