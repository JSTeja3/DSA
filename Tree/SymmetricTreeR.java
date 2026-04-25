package Tree;

public class SymmetricTreeR {
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isEqual(root.left, root.right);
    }
    public boolean isEqual(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null || left.val!=right.val){
            return false;
        }
        if(!isEqual(left.left, right.right)){
            return false;
        }
        return isEqual(left.right, right.left);
    }

}
