package removeElement;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        final int size = nums.length;
        if (size == 0)
            return 0;
        int k = size - 1;
        int i = 0;
        while (i < size & i <= k) {
            int element = nums[i];

            if (i == k) {
                if (nums[k] == val) {
                    k--;
                }

                break;
            }
            while (i < k && nums[k] == val) {
                k--;
            }
            if (i < k) {
                if (element != val) {
                    i++;
                } else {
                    int tmp = nums[k];
                    nums[k] = element;
                    nums[i] = tmp;

                    k--;
                    i++;
                }
            }
        }

        return k+1;
    }

    public static void main(String[] args) {
        int val = 2;
        int[] nums = {3,2};

        RemoveElement removeElement = new RemoveElement();
        System.out.print(removeElement.removeElement(nums, val));
    }
}
