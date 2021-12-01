package cc.rcbb.leetcode.template;

public class BinarySearchTemplate {

    int right_bound(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println(left +" " + right +" " +mid);
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left >= nums.length) {
            return -1;
        }
        return left - 1; // 注意
    }

    public static void main(String[] args) {
        BinarySearchTemplate template = new BinarySearchTemplate();
        int r = template.right_bound(new int[]{1, 2, 2, 4}, 0);
        System.out.println(r);
    }

}
