package arithmetic.aa202006.partition;

/**
 * Created by zuihaodeziji on 2020/6/3.
 * 寻找超过一半数字的元素
 * partition201910 packet下有
 * 时间复杂度空间复杂度可以看201910 packet下的记录
 */
public class FindMoreHalfNumber {

    private static void findPartitionMiddle(int[] arr, int startIndex , int endIndex ,int middleIndex){

        int leftSlideIndex = startIndex;
        int rightSlideIndex = endIndex;
        int index = startIndex;
        while(leftSlideIndex < rightSlideIndex){
             while (leftSlideIndex< rightSlideIndex && arr[index] <= arr[rightSlideIndex]){
                 rightSlideIndex --;
             }
             if(leftSlideIndex < rightSlideIndex){
                 //交换
                 int temp = arr[rightSlideIndex];
                 arr[rightSlideIndex] = arr[index];
                 arr[index] = temp;
                 index = rightSlideIndex;
                 leftSlideIndex ++;
             }
             while (leftSlideIndex < rightSlideIndex && arr[leftSlideIndex] <= arr[index]){
                 leftSlideIndex ++;
             }
             if(leftSlideIndex < rightSlideIndex){
                 int temp = arr[leftSlideIndex];
                 arr[leftSlideIndex] = arr[index];
                 arr[index] = temp;
                 index = leftSlideIndex;
                 rightSlideIndex --;
             }


        }

        if(index < middleIndex){
            findPartitionMiddle(arr,index+1,endIndex,middleIndex);
        }

        if(index > middleIndex){
            findPartitionMiddle(arr,startIndex,index-1,middleIndex);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,3,2,3,3,5,3,3,1};
        if(arr == null && arr.length == 0){
            System.out.print("the arr is null or empty");
        }

        if(arr.length ==1 || arr.length ==2){
            System.out.println("the half value is:"+arr[0]);
        }else{
            int middleIndex = (arr.length-1)/2;
            findPartitionMiddle(arr,0,arr.length-1,middleIndex);
            System.out.println("the half value is:"+arr[middleIndex]);
        }
    }

}
