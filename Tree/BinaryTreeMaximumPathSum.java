package Tree;

public class BinaryTreeMaximumPathSum {
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
        public int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxWithCurrent(root);
            return ans;
        }

        public int maxWithCurrent(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(0, maxWithCurrent(root.left));
            int right = Math.max(0, maxWithCurrent(root.right));
            ans = Math.max(ans, root.val + left + right);
            int max = Math.max(left, right);
            return max + root.val;
        }
    }
}
