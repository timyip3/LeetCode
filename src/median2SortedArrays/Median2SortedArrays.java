package median2SortedArrays;

public class Median2SortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {3};
		int[] nums2 = {-2,-1};
		double result = findMedianSortedArrays(nums1, nums2);
		//int result = 3/2;
		System.out.println("result: " + result);
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
		if ((m + n) % 2 == 0) {
			double k = findMedianSortedArrays(nums1, nums2, m, n, (m + n)/2);
			double k1 = findMedianSortedArrays(nums1, nums2, m, n, (m + n)/2 + 1);
			
			return (k + k1)/2.0;
		} else {
			return findMedianSortedArrays(nums1, nums2, m, n, (m+n)/2);
		}
    }
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2,
			int m, int n, int k) {
		if (m <= 0) {
			return nums2[k-1];
        }
			
		if (n <= 0) {
			return nums1[k-1];
        }
			
		if (k <= 1)
			return Math.max(nums1[0], nums2[0]);
		
		if (nums1[m/2] >= nums2[n/2]) {
			if ((m/2 + n/2 +1) >= k) {
				return findMedianSortedArrays(nums1, nums2, m/2, n, k);
			} else {
				return findMedianSortedArrays(nums1, nums2, m, n - (n/2+1), k - (n/2 + 1));
			}
		} else {
			if ((m/2 + n/2 +1) >= k) {
				return findMedianSortedArrays(nums1, nums2, m, n/2, k);
			} else {
				return findMedianSortedArrays(nums1, nums2, m - (m/2+1), n, k - (m/2 + 1));
			}
		}
    }
}
