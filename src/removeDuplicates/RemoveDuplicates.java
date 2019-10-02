package removeDuplicates;

public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		int len = removeDuplicates(nums);
		
		for (int i = 0;i < len; i++) {
			System.out.println("element: " + nums[i]);
		}
	}
	
	public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) 
        	return 0;
        if (nums.length == 1) 
        	return 1;
        
        int maxNum = nums[nums.length - 1];
        
        sortDuplicate(nums);
        
        for (int i = 0; i < nums.length; i++) {
        	if (maxNum == nums[i]) {
				return i+1;
			}
        }
        
        return 0;
    }
	
	public static void sortDuplicate(int[] nums) {
		int i = 0;
		
		int j = i +1;
		while (j < nums.length) {
			if (nums[i] == nums[j]) {
				nums[j] = Integer.MIN_VALUE;
			} else if (nums[i] < nums[j]) {
				swap(nums, i+1, j);
				i++;
			}
			
			j++;
		}
		
		
	}
	
	public static void swap(int[] nums, int start, int end) {
		int tmp = nums[start];
		nums[start] = nums[end];
		nums[end] = tmp;
	}
}
