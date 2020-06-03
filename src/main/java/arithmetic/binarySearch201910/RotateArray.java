package arithmetic.binarySearch201910;
/**
 * 旋转数组:把一个数组最开始的若干元素半到元素的末尾，我们称之为旋转数组
 * 例如：{1，2，3，4，5}，从第二个元素旋转后变为{3，4，5，1，2},现在需要求出数组的最小值（即找出从哪个位置开始做的旋转）
 * 排序的数组：遇到排序数组的问题，首先要利用二分查找法（利用数组的有序性可以快速的查找，一次性可以丢掉一半的长度）
 * Created by 10718 on 2019/10/20.
 */
public class RotateArray {

    static int index = -1;
    //现在暂时未考虑特殊的情况
    private static void findMinData(int[] rotateArr,int startIndex,int endIndex){
        if(startIndex>endIndex){
            return ;
        }
        int middleIndex = (startIndex+endIndex)/2;
        //判断该middleIndex 是否为临界点
        int preIndex = middleIndex-1;
        int nextIndex = middleIndex+1;
        if(preIndex>=0 && nextIndex<rotateArr.length){
            if(rotateArr[preIndex] > rotateArr[middleIndex] && rotateArr[middleIndex] <= rotateArr[nextIndex]){
                index = middleIndex;
                return;
            }
        }else if(preIndex >=0){
            if(rotateArr[preIndex] > rotateArr[middleIndex]){
                index = middleIndex;
                return;
            }
        }
        if(rotateArr[startIndex] > rotateArr[middleIndex]){//旋转临界点在左边
            findMinData(rotateArr,startIndex,middleIndex-1);
        }else if(rotateArr[middleIndex] > rotateArr[endIndex]){
            findMinData(rotateArr,middleIndex+1,endIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr  = {4,5,6,7,8,9,10,11,12,13,2,3};
        findMinData(arr,0,arr.length-1);
        System.out.println("index is:"+index+". the min value is:"+arr[index]);
    }
}
