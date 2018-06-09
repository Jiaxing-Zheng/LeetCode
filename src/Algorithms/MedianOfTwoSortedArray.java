package Algorithms;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        if (sum % 2 == 0) {
            return ((double) findKth(nums1, 0, nums2, 0, sum / 2) + (double) findKth(nums1, 0, nums2, 0, sum / 2 + 1)) / 2;
        }
        return findKth(nums1, 0, nums2, 0, (sum + 1) / 2);
    }

    public int findKth(int[] nums1, int left1, int[] nums2, int left2, int k) {
        if (left1 >= nums1.length) return nums2[left2 + k - 1];
        if (left2 >= nums2.length) return nums1[left1 + k - 1];
        if (k == 1) return Math.min(nums1[left1], nums2[left2]);
        int mid1 = left1 + k / 2 - 1 < nums1.length ? nums1[left1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = left2 + k / 2 - 1 < nums2.length ? nums2[left2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 <= mid2) {
            return findKth(nums1, left1 + k / 2, nums2, left2, k - k / 2);
        }
        return findKth(nums1, left1, nums2, left2 + k / 2, k - k / 2);
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArray sol = new MedianOfTwoSortedArray();
        int[] array1 = new int[] {1};
        int[] array2 = new int[] {2,3,4,5,6};
        System.out.println(sol.findMedianSortedArrays(array1, array2));
    }
}
