import data.TreeNode;

import java.util.List;

public class _226_InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t7 = new TreeNode(7);
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t9 = new TreeNode(9);
        t4.left = t2;
        t4.right = t7;
        t2.left = t1;
        t2.right = t3;
        t7.left = t6;
        t7.right = t9;

        TreeNode actual = invertTree(t4);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.right);
        invertTree(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
