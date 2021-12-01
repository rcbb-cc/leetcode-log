package cc.rcbb.leetcode.topic_1373;

import cc.rcbb.leetcode.template.TreeNode;

class Solution1 {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (isBST(root.left) && isBST(root.right)) {
            int rootVal = root.val;
            if (root.left == null && root.right == null) {
                maxSum = Math.max(rootVal, maxSum);
            }
            if (root.left != null && root.right == null) {
                int leftSum = findSum(root.left);
                maxSum = Math.max(rootVal + leftSum, maxSum);
            }
            if (root.left == null && root.right != null) {
                int rightSum = findSum(root.right);
                maxSum = Math.max(rootVal + rightSum, maxSum);
            }
            if (root.left != null && root.right != null) {
                int leftMaxVal = findMax(root.left);
                int rightMinVal = findMin(root.right);

                if (rootVal > leftMaxVal && rootVal < rightMinVal) {
                    int leftSum = findSum(root.left);
                    int rightSum = findSum(root.right);
                    maxSum = Math.max(rootVal + leftSum + rightSum, maxSum);
                }
            }
        }
        traverse(root.left);
        traverse(root.right);
    }


    public boolean isBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    public int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return findSum(root.left) + findSum(root.right) + root.val;
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.maxSumBST(buildTree()));

    }

    private static TreeNode buildTree() {


        TreeNode ten = new TreeNode();
        ten.val =10;
        ten.left = null;
        ten.right = null;

        TreeNode four2 = new TreeNode();
        four2.val =4;
        four2.left = null;
        four2.right = ten;




        TreeNode fuThree = new TreeNode();
        fuThree.val =-3;
        fuThree.left = null;
        fuThree.right = null;

        TreeNode fuFive = new TreeNode();
        fuFive.val =-5;
        fuFive.left = null;
        fuFive.right = fuThree;

        TreeNode one = new TreeNode();
        one.val = 1;
        one.left = null;
        one.right = four2;



        TreeNode nine = new TreeNode();
        nine.val = 9;
        nine.left = null;
        nine.right = null;

        TreeNode six = new TreeNode();
        six.val = 6;
        six.left = nine;
        six.right = null;

        TreeNode eight = new TreeNode();
        eight.val = 8;
        eight.left = null;
        eight.right = one;

        TreeNode four = new TreeNode();
        four.val = 4;
        four.left = eight;
        four.right = null;


        return four;
    }

}