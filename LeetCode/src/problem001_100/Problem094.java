package problem001_100;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem094 {

    private void inorderByIterator(TreeNode root, List<Integer> ansList) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // 先找到相对于当前节点的最左的节点, 并将整条左侧链上的节点压栈。
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            ansList.add(curr.val);
            curr = curr.right;
        }
    }

    // 用栈，按照右->中->左的顺序压栈
    private void iteratorVersion(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        if (root.right != null) {
            stack.push(root.right);
            root.right = null;
        }

        stack.push(root);

        if (root.left != null) {
            stack.push(root.left);
            root.left = null;
        }

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();

            if (top.left == null && top.right == null) {
                ansList.add(top.val);
                continue;
            }

            if (top.right != null) {
                stack.push(top.right);
                top.right = null;
            }

            stack.push(top);

            if (top.left != null) {
                stack.push(top.left);
                top.left = null;
            }
        }

    }

    private void inorderByRecursive(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inorderByRecursive(root.left, ansList);
        }

        ansList.add(root.val);

        if (root.right != null) {
            inorderByRecursive(root.right, ansList);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
//        inorderByRecursive(root, ansList);
        inorderByIterator(root, ansList);
        return ansList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> ansList = new Problem094().inorderTraversal(root);

        for (int item : ansList) {
            System.out.print(item + " ");
        }
    }
}
