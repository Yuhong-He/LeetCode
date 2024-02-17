import data.TreeNode;

import java.util.LinkedList;

public class _101_SymmetricTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2a = new TreeNode(2);
        TreeNode t2b = new TreeNode(2);
        TreeNode t3a = new TreeNode(3);
        TreeNode t3b = new TreeNode(3);
        TreeNode t4a = new TreeNode(4);
        TreeNode t4b = new TreeNode(4);
        t1.left = t2a;
        t1.right = t2b;
        t2a.left = t3a;
        t2a.right = t4a;
        t2b.left = t4b;
        t2b.right = t3b;
        boolean actual = isSymmetric(t1);
        System.out.println("expected: " + true);
        System.out.println("actual: " + actual);
    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public static boolean check(TreeNode root, TreeNode copy) {
        if(root == null && copy == null){
            return true;
        } else if(root == null || copy == null) {
            return false;
        } else {
            return root.val == copy.val && check(root.left, copy.right) && check(root.right, copy.left);
        }
    }

    public static boolean isSymmetric2(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode u = root.left;
        TreeNode v = root.right;
        if (u == null && v == null) {
            return true;
        }
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }
            q.offer(u.left);
            q.offer(v.right);
        }
        return true;
    }

    public static boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check2(root.left, root.right);
    }

    public static boolean check2(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return check2(left.left, right.right) && check2(left.right, right.left);
    }
}
