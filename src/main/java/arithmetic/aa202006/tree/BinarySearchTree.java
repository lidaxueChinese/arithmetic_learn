package arithmetic.aa202006.tree;
/**
 * Created by lidaxue on 2020/10/20.
 *
 * 根据二叉搜索树 后续遍历得到的数组，返回该树的root 节点
 * 来源于 左程云的公开课
 *
 * 平均时间复杂度 n*log2 (n)
 * 空间复杂度：递归深度最大为n,空间复杂度为n
 */
public class BinarySearchTree {


    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public static void main(String[] args) {
        int[] data ={2,4,3,6,8,7,5};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeNode root = binarySearchTree.getBinarySearchTree(data);
        System.out.println("root is:"+root);
    }

    private TreeNode getBinarySearchTree(int[] data){
        if(data == null || data.length == 0){
            return null;
        }
        return getBinarySearchTree(data,0,data.length-1);
    }

    private TreeNode getBinarySearchTree(int[] data,int leftIndex,int rightIndex){
        if(leftIndex == rightIndex){
            return new TreeNode(data[rightIndex]);
        }
        int rootData = data[rightIndex];
        TreeNode root = new TreeNode(rootData);
        if(data[leftIndex] > rootData){ //只有右子树
            TreeNode rightNode = getBinarySearchTree(data,leftIndex,rightIndex-1);
            root.right = rightNode;
        }else if(data[rightIndex -1 ] < rootData){ //只有左子树
            TreeNode leftNode = getBinarySearchTree(data,leftIndex,rightIndex-1);
            root.left = leftNode;
        }else{
            int middleIndex = -1;
            for(int i = leftIndex ; i < rightIndex ;i++){
                if(data[i] > rootData){
                    middleIndex = i;
                    break;
                }
            }
            TreeNode leftNode = getBinarySearchTree(data,leftIndex,middleIndex-1);
            TreeNode rightNode = getBinarySearchTree(data,middleIndex,rightIndex-1);
            root.left = leftNode;
            root.right = rightNode;

        }

        return root;

    }
}
