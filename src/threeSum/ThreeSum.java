package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List result = new ArrayList();
        final int size = nums.length;

        if (size <= 2) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < size; i++) {
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            int j = i + 1;
            int k = size - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> sums = new ArrayList<Integer>();
                    sums.add(nums[i]);
                    sums.add(nums[j]);
                    sums.add(nums[k]);
                    result.add(sums);
                    j++;
                    while (j < size && nums[j] == nums[j-1]) {
                        j++;
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,0, 0};

        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(nums);
        for (List<Integer> list : result) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + ", ");
            }
            System.out.println();
        }

    }
}
