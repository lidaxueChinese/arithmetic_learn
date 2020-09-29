package arithmetic.aa202006.array;
/**
 * Created by lidaxue on 2020/9/29.
 *
 * https://leetcode-cn.com/problems/move-zeroes/submissions/
 *
 * 思路：用一个zeroIndex 来表示可以交换0的索引位置
 * 当交换后zeroIndex 位置变成 zeroIndex+1
 *
 * 时间复杂度 O(n)
 * 空间复杂度O(1)
 */
public class MoveZero {

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        MoveZero moveZero = new MoveZero();
        moveZero.moveZeroes(arr);
        System.out.println();
    }

    public void moveZeroes(int[] nums) {

        int zeroIndex = -1;
        for(int i= 0;i<nums.length;i++){
            if(nums[i] == 0){
                if(zeroIndex == -1){
                    zeroIndex = i;
                }
            }else{
                if(zeroIndex >= 0){ //前面有zero,交换位置
                    nums[zeroIndex] = nums[i];
                    nums[i] = 0;
                    zeroIndex += 1;
                }
            }
        }
    }
}
