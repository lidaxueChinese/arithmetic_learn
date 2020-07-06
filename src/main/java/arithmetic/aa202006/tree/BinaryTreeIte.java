package arithmetic.aa202006.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的遍历
 * Created by lidaxue on 2020/7/6.
 * 问题描述：
 * 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,2,3]



 时间/空间 复杂度分析

 1.时间复杂度
 O(n)

 2.空间复杂度
 最差的是O(n),平均log2 N (如何计算？)
 */
public class BinaryTreeIte {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
           //leetcode 已经实现 参考  https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
           //preorderTraversal()
    }


    //前序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        int value = root.val;
        list.add(value);
        TreeNode left = root.left;
        if(left != null){
            preorderTraversal(left);
        }
        TreeNode right = root.right;
        if(right != null){
            preorderTraversal(right);
        }
        return list;
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }

        TreeNode left = root.left;
        if(left != null){
            inorderTraversal(left);
        }
        int value = root.val;
        list.add(value);
        TreeNode right = root.right;
        if(right != null){
            inorderTraversal(right);
        }
        return list;
    }

    //后续遍历
    public List<Integer> postorderTraversal(TreeNode root) {
      if(root == null){
          return list;
      }

        TreeNode left = root.left;
        if(left != null){
            postorderTraversal(left);
        }
        TreeNode right = root.right;
        if(right != null){
            postorderTraversal(right);
        }
        int value = root.val;
        list.add(value);
        return list;

    }
}
