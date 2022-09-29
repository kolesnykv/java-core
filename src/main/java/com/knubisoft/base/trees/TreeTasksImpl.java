package com.knubisoft.base.trees;

import java.util.ArrayList;
import java.util.List;


public class TreeTasksImpl implements TreeTasks {

    @Override
    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null & node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.val == node2.val && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }

    @Override
    public List<Integer> inorderTraversal(TreeNode node) {
        List<Integer> list = new ArrayList<>();

        if (node == null) {
            return list;
        }

        list.addAll(inorderTraversal(node.left));
        list.add(node.val);
        list.addAll(inorderTraversal(node.right));

        return list;
    }

    @Override
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (r == null || l == null) {
            return false;
        }

        if (l.val != r.val)
            return false;

        if (!isSymmetric(l.left, r.right))
            return false;
        if (!isSymmetric(l.right, r.left))
            return false;

        return true;
    }

    @Override
    public int maxDepth(TreeNode node) {
//        if(node==null) {
//            return 0;
//        }
//        int leftDepth = maxDepth(node.left);
//        int rightDepth = maxDepth(node.right);
//        int bigger = Math.max(leftDepth, rightDepth);
//        return bigger+1;
        return node == null ? 0 : Math.max(maxDepth(node.left), maxDepth(node.right))+1;
    }

    @Override
    public boolean hasPathSum(TreeNode node, int targetSum) {
        return false;
    }

    @Override
    public TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode leftNode = invertTree(node.left);

        node.left = invertTree(node.right);
        node.right = leftNode;

        return node;
    }

    @Override
    public int sumOfLeftLeaves(TreeNode node) {
        return -1;
    }

    @Override
    public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }

        node1.val += node2.val;
        node1.left = mergeTrees(node1.left, node2.left);
        node1.right = mergeTrees(node1.right, node2.right);

        return node1;
    }
}
