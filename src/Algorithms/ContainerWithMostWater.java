package Algorithms;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, minHeight * (right - left));
            while (height[left] <= minHeight && left < right) left++;
            while (height[right] <= minHeight && left < right) right--;
        }

        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();
        System.out.println(sol.maxArea(new int[]{6,4,3,5,2,3}));
    }

}
