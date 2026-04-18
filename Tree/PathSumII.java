package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
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
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            findEachPath(root, targetSum, new ArrayList<>());
            return result;
        }

        public void findEachPath(TreeNode root, int targetSum, List<Integer> list) {
            if (root == null) {
                return;
            }

            list.add(root.val);
            targetSum -= root.val;
            if (root.left == null && root.right == null && targetSum == 0) {
                result.add(new ArrayList<>(list));
            } else {
                findEachPath(root.left, targetSum, list);
                findEachPath(root.right, targetSum, list);
            }
            list.remove(list.size() - 1);
            return;
        }
    }
}
