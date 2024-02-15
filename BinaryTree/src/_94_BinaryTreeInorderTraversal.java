import data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;
        List<Integer> result = inorderTraversal(t1);
        System.out.println(result);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        accessTree(root, result);
        return result;
    }

    public static void accessTree(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        accessTree(root.left, result);
        result.add(root.val);
        accessTree(root.right, result);
    }
}
