package arithmetic.aa202006.tree;
/**
 * Created by lidaxue on 2020/7/6.
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。

 例如，给出

 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 返回如下的二叉树：

 3
 / \
 9  20
 /  \
 15   7

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 优化点：考虑到没有重复的元素，可以为 每个元素在什么位置上创建一个 映射。这样可以通过映射确定搜索的位置，
 时间复杂度可以达到 O(n),空间复杂度也为O(n) -- 返回的结果 以及存储映射map都需要n


 目前版本: 时间复杂度为 n*log(n),其空间复杂度为O(n)--返回的结果 需要n
 */
public class BinaryTreeRestore {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    TreeNode treeNode = null;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
      if(preorder == null || preorder.length == 0){
          return null;
      }
       return buildTree(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }


    private static TreeNode buildTree(int preStartIndex,int preEndIndex,int inStartIndex,int inEndIndex,int[] preorder, int[] inorder){
        if(preStartIndex > preEndIndex){
            return null;
        }else if(preStartIndex == preEndIndex){
            return new TreeNode(preorder[preStartIndex]);
        }

        int value = preorder[preStartIndex];//中间节点
        int peakIndex = inStartIndex;
        for(int i = inStartIndex;i<= inEndIndex;i++){
            if(inorder[i] == value){ //中序 中的 顶点
               peakIndex = i;
               break;
            }
        }
        int leftNodeLen = peakIndex - 1 - inStartIndex +1;
        TreeNode peakNode = new TreeNode(value);
        //left
        int leftPreStartIndex = preStartIndex+1;
        int leftPreEndIndex = leftPreStartIndex+leftNodeLen-1;
        int leftInStartIndex = inStartIndex;
        int leftInEndIndex = leftInStartIndex + leftNodeLen -1;

        //right
        int rightPreStartIndex = leftPreEndIndex+1;
        int rightPreEndIndex = preEndIndex;
        int rightInStartIndex = peakIndex +1;
        int rightInEndIndex = inEndIndex;
        TreeNode leftTreeNode = buildTree(leftPreStartIndex ,leftPreEndIndex,leftInStartIndex,leftInEndIndex,preorder,inorder);
        TreeNode rightTreeNode = buildTree(rightPreStartIndex,rightPreEndIndex,rightInStartIndex,rightInEndIndex,preorder,inorder);
        peakNode.left = leftTreeNode;
        peakNode.right = rightTreeNode;
        return peakNode;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder,inorder);
        System.out.println("====");
    }
}
