import data.TreeNode;

import java.util.LinkedList;

public class _104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        t3.left = t9;
        t3.right = t20;
        t20.left = t15;
        t20.right = t7;
        int actual = maxDepth(t3);
        System.out.println("expected: 3");
        System.out.println("actual: " + actual);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        int depth = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size > 0) {
                TreeNode node = stack.poll();
                if (node.left != null) {
                    stack.offer(node.left);
                }
                if (node.right != null) {
                    stack.offer(node.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
