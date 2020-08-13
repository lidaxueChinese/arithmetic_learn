package arithmetic.aa202006.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lidaxue on 2020/8/12.
 *
 * 传统版：
 * 空间复杂度：List<List<Integer>> resultList = pathSum(treeNode); 的大小，外层list为n/2 ,里层list大小为log2(n),
 * 时间复杂度：跟空间复杂度一样，因为对resultList进行遍历
 *
 * 优化版：
 * subTreeSum = sum - value
 * 通过一个公共的list<Integer> list 来存储遍历的过程中是否存在"符合条件的"list
 * 空间复杂度：LinkList<Integer> list, 空间复杂度为O(n)+linkList自带的前后指针
 * 时间复杂度为 O(n)
 */
public class BinaryTreeValueSum {
    private static class TreeNode{
        int val;
        BinaryTreeValueSum.TreeNode left;
        BinaryTreeValueSum.TreeNode right;
        TreeNode(int x){val = x;}
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode level2_1 = new TreeNode(4);
        TreeNode level2_2 = new TreeNode(8);

        TreeNode level3_1 = new TreeNode(11);
        TreeNode level3_2 = new TreeNode(13);
        TreeNode level3_3 = new TreeNode(4);

        TreeNode level4_1 = new TreeNode(7);
        TreeNode level4_2 = new TreeNode(2);
        TreeNode level4_3 = new TreeNode(5);
        TreeNode level4_4 = new TreeNode(1);

        level3_1.left  = level4_1;
        level3_1.right = level4_2;

        level3_3.left  = level4_3;
        level3_3.right = level4_4;

        level2_1.left = level3_1;
        level2_2.left  = level3_2;
        level2_2.right = level3_3;

        root.left = level2_1;
        root.right = level2_2;

        BinaryTreeValueSum binaryTreeValueSum = new BinaryTreeValueSum();
        //List<List<Integer>> resultList = binaryTreeValueSum.pathSum(root,22);
        binaryTreeValueSum.pathSum(root,22);
        LinkedList<List<Integer>> resultList = binaryTreeValueSum.resultList;
        System.out.println("=============");
    }


    /**
     * old version
     */
    /*private List<List<Integer>> pathSum(TreeNode treeNode,int sum){
        List<List<Integer>> finalResultList = new ArrayList<>();
         List<List<Integer>> resultList = pathSum(treeNode);
         if(resultList != null){
             for(List<Integer> l:resultList){
               Integer listInteger = listSum(l);
               if(listInteger == sum){
                   finalResultList.add(l);
               }

             }
         }
         return finalResultList;
    }


    private List<List<Integer>> pathSum(TreeNode treeNode){

        if(treeNode == null){
            return null;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        int value = treeNode.val;
        TreeNode leftTreeNode = treeNode.left;
        List<List<Integer>> leftResultList = pathSum(leftTreeNode);
        if(leftResultList != null){
            for(List<Integer> l:leftResultList){
                List<Integer> leftSubList = new ArrayList<>();
                leftSubList.add(value);
                leftSubList.addAll(l);
                resultList.add(leftSubList);
            }
        }

        TreeNode rightTreeNode = treeNode.right;
        List<List<Integer>> rightResultList = pathSum(rightTreeNode);
        if(rightTreeNode != null){
            for(List<Integer> r:rightResultList){
                List<Integer> rightSubList = new ArrayList<>();
                rightSubList.add(value);
                rightSubList.addAll(r);
                resultList.add(rightSubList);

            }
        }

        if(leftResultList == null && rightResultList == null){
            List<Integer> subList = new ArrayList<>();
            subList.add(value);
            resultList.add(subList);
        }

        return resultList;

    }

    private Integer listSum(List<Integer> list){
        Integer sum = 0;
        for(Integer integer:list){
               sum += integer;
        }
        return sum;
    }*/

    /**
     * new version
     */


    LinkedList<Integer> list = new LinkedList<>();
    LinkedList<List<Integer>> resultList = new LinkedList<>();

    private void pathSum(TreeNode treeNode,int sum){
        recursion(treeNode,sum);
    }

    private void recursion(TreeNode treeNode,int remainValue){
        if(treeNode == null){
            return;
        }

        int value = treeNode.val;
        list.add(value);
        remainValue = remainValue - value;

        //达到符合的条件
        if(remainValue == 0 && treeNode.left == null && treeNode.right == null){
           //list是动态变化的，对于符合条件的需要new一个新的对象
           resultList.add(new LinkedList<>(list));
        }
        if(treeNode.left != null){
            recursion(treeNode.left,remainValue);
        }

        if(treeNode.right != null){
            recursion(treeNode.right,remainValue);
        }

        //执行到此处说明左右子树已经处理完成了，第一次执行到此处为叶子节点
        //TODO linkedList ,通过双链表 构成，removeLast时间复杂度为O(1)
        list.removeLast();

    }
}
