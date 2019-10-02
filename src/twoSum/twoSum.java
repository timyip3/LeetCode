package twoSum;

import java.util.HashMap;
import java.util.Map;

public class twoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]nums = new int[] {3, 2, 4};
		int target = 6;
		int[] result = twoSum(nums, target);
		for (int i = 0; i < result.length; i++)
			System.out.println("result: " + result[i]);
	}

	public static int[] twoSum(int[] nums, int target) {
        Map <Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length;i++) {
            int delta = target - nums[i];
            
            if (!map.isEmpty() && map.containsKey(delta)) {
                result = new int[]{map.get(delta), i};
                return result;
            }

            map.put(nums[i], i);
        }
        
        return result;
    }
}
