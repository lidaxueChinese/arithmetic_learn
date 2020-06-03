package arithmetic.partiton;
/**找出出现超过一半的数字，有一个数组里面有一串数字，寻找出现大于一半的那个数字
 * 该算法的实现 和 前k 大的数组（前k大的数字不需要排序）,只不过需要通过条件 判断出要找出中位数-即找出第 n/2 大的数字
 * 改算法的时间复杂度是:O(n),平均partitionIndex就应该排到中位数
 * Created by 10718 on 2019/10/24.
 */
public class FindMoreHalfNumber {


    private  static Integer findMedianIndex(int[] arr, int startIndex ,int endIndex,int medianIndex){
        if(arr == null){
            return null;
        }else if(arr.length == 1){
            return arr[0];
        }

        int partitionIndex = getPartitonIndex(arr,startIndex,endIndex);
        if(partitionIndex == medianIndex){
            return  arr[partitionIndex];
        }else if(partitionIndex < medianIndex){
          return  findMedianIndex(arr,partitionIndex+1,endIndex,medianIndex);
        }else{
           return findMedianIndex(arr,startIndex,partitionIndex-1,medianIndex);
        }
    }

    private static int getPartitonIndex(int[] arr,int startIndex, int endIndex){
        int compareValue = arr[startIndex];

        while(startIndex < endIndex){
            while (startIndex < endIndex){
                if(arr[endIndex] > compareValue){
                    endIndex --;
                }else{
                    arr[startIndex] = arr[endIndex];
                    startIndex ++ ;
                    break;
                }
            }
            while (startIndex < endIndex){
                if(arr[startIndex] < compareValue){
                    startIndex ++;
                }else{
                    arr[endIndex] = arr[startIndex];
                    endIndex --;
                    break;
                }
            }
        }
        return startIndex;
    }


    public static void main(String[] args) {
       int[] arr = {1,2,3,2,2,2,5,4,2};
       Integer mediaValue = findMedianIndex(arr,0,arr.length-1,arr.length/2);
       System.out.println("the mediaValue is:"+mediaValue);
    }
}
