package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> result = new ArrayList<>();
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.addLast(root);
            boolean leftToRight = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                Deque<Integer> level = new ArrayDeque<>();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.removeFirst();
                    if (leftToRight) {
                        level.addLast(temp.val);
                    } else {
                        level.addFirst(temp.val);
                    }
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
                leftToRight = !leftToRight;
                result.add(new ArrayList<>(level));
            }
            return result;
        }
    }
}
