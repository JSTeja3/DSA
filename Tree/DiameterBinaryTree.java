package Tree;

public class DiameterBinaryTree {
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
        public int ans = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            maxLength(root);
            return ans;
        }

        public int maxLength(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxLength(root.left);
            int right = maxLength(root.right);
            ans = Math.max(ans, left + right);
            return 1 + Math.max(left, right);
        }
    }
}
