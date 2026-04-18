package Tree;

public class PathSum {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            return validSum(root, targetSum, 0);
        }

        public boolean validSum(TreeNode root, int targetSum, int currSum) {
            if (root == null) {
                return false;
            }
            currSum += root.val;
            if (currSum == targetSum && root.left == null && root.right == null) {
                return true;
            }
            if (validSum(root.left, targetSum, currSum)) {
                return true;
            }
            return validSum(root.right, targetSum, currSum);
        }
    }
}
