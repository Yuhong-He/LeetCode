import data.TreeNode;

public class _110_BalancedBinaryTree {
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
        boolean actual = isBalanced(t3);
        System.out.println("expected: true");
        System.out.println("actual: " + actual);
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) != -1;
    }

    private static int helper(TreeNode root) {
        if (root == null) { // 递归到最后一个子节点
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 // 如果树此时已经不平衡
                || Math.abs(left - right) > 1) { // 计算左右子树高度差，如果大于一说明不平衡
            return -1;
        }
        return Math.max(left, right) + 1; // 返回当前节点高度，Math.max(left, right)为最长子树高度，加1即可返回当前节点高度
    }
}
