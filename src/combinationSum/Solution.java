package combinationSum;

import java.util.*;

import static java.lang.System.out;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List resultList = new ArrayList();
        if (candidates.length == 0)
            return resultList;
        if (target == 0)
            return resultList;
        Arrays.sort(candidates);

        bfs(candidates, target, resultList, new ArrayList<Integer>(), 0);
        return resultList;
    }

    public void bfs(int[] candidates, int target, List<List<Integer>> result,
                    List<Integer> solset, int sum) {
        if (sum > target)
            return;

        if (sum == target) {
            Collections.sort(solset);

            if (!result.contains(solset)) {
                result.add(new ArrayList<Integer>(solset));
                return;
            }
        }

        for (int i = 0; i < candidates.length; i++) {
            solset.add(candidates[i]);
            sum = sum + candidates[i];
            bfs(candidates, target, result, solset, sum);
            sum = sum - candidates[i];
            solset.remove(candidates[i]);
        }
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        String line = "[2,3,6,7]";
        int[] candidates = stringToIntegerArray(line);
        int target = 7;

        List<List<Integer>> ret = new Solution().combinationSum(candidates, target);

        String out = int2dListToString(ret);

        System.out.print(out);
    }
}
