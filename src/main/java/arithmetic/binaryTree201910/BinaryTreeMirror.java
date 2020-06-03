package arithmetic.binaryTree201910;
/** 二叉树的镜像
 * 更加的熟悉，递归的写法。递归是要如何看出重叠部分的子问题
 * Created by 10718 on 2019/10/22.
 */
public class BinaryTreeMirror {

    private static void mirror(BinaryTreeNode binaryTreeNode){
        if(binaryTreeNode == null){
            return;
        }
        BinaryTreeNode left = binaryTreeNode.left;
        BinaryTreeNode right = binaryTreeNode.right;
        if(left != null && right != null){
            binaryTreeNode.left =right;
            binaryTreeNode.right = left;
        }
        if(left != null){
            mirror(left);
        }
        if(right != null){
            mirror(right);
        }
    }


    private static class BinaryTreeNode{
        public BinaryTreeNode(int value,BinaryTreeNode left,BinaryTreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static void main(String[] args) {
        BinaryTreeNode node7 =  new BinaryTreeNode(7,null,null);
        BinaryTreeNode node9 =  new BinaryTreeNode(9,null,null);
        BinaryTreeNode node11 =  new BinaryTreeNode(11,null,null);
        BinaryTreeNode node6 =  new BinaryTreeNode(6,null,node7);
        BinaryTreeNode node10 =  new BinaryTreeNode(10,node9,node11);
        BinaryTreeNode node8 =  new BinaryTreeNode(8,node6,node10);
        mirror(node8);
        System.out.println("");
    }
}
