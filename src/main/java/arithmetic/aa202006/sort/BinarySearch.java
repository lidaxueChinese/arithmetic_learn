package arithmetic.aa202006.sort;
/**
 * Created by lidaxue on 2020/10/20.
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1,2,3,5,7,8,9};

        int value = 7;
        int valueIndex = -1;

        int leftIndex = 0;

        int rightIndex = arr.length-1;

        while(leftIndex <= rightIndex){
            //int middleIndex = (leftIndex + rightIndex) / 2;
            //TODO  1. leftIndex + rightIndex 可能超出 int 的最大表示范围  2.除以2 可以使用>>1
            int middleIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
            if(arr[middleIndex] == value){
                valueIndex = middleIndex;
                break;
            }else if(arr[middleIndex] > value){
                rightIndex = middleIndex -1;
            }else{
                leftIndex = middleIndex + 1;
            }

        }

        System.out.println("the value index is:"+valueIndex);
    }
}
