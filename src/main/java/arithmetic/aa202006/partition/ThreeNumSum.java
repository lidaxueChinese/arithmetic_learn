package arithmetic.aa202006.partition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidaxue on 2020/6/15.
 * 数组中任意三个数相加等于0
 * 因为需要去重，需要保证“同一层”遍历时，改索引对应的value 不小于上一次对应的值。需要先对数据进行排序
 *
 */
public class ThreeNumSum {

    public static void main(String[] args) {

        //int[] arr = {-1,1,0};
        int[] arr = {-1, 0, 1, 2, -1, -4};
        quickSort(arr,0,arr.length-1);
        //int[] arr = {-4,-1, -1,-1,0, 1, 2};
        List<List<Integer>> result = result(arr);
        System.out.println(result);
    }
    private static List<List<Integer>>  result(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        int threeNumIndex = arr.length-1;
        for(int i=0;i<arr.length;i++){
            for(int j =i+1;j<arr.length;j++){
                //重复项
                if(i >0 && arr[i] == arr[i-1] && arr[j] == arr[j-1]){
                    break;
                }
                if(j >= threeNumIndex){
                    break;
                }
               if(arr[i]+arr[j]+arr[threeNumIndex] >0){ //threeNumIndex -- 向左移动(减少第三值)
                   //注意点：因为左边两个已经是最小值了，需要需要将第三个数调整到一个较小的位置上
                   while(true){
                       if(j>=threeNumIndex){
                           break;
                       }
                       threeNumIndex --;
                       if(arr[i]+arr[j]+arr[threeNumIndex]==0){
                           List<Integer> subResult = new ArrayList<>();
                           subResult.add(arr[i]);
                           subResult.add(arr[j]);
                           subResult.add(arr[threeNumIndex]);
                           result.add(subResult);
                           break;
                       }else if(arr[i]+arr[j]+arr[threeNumIndex] < 0){
                           break;
                       }
                   }
               }else if(arr[i]+arr[j]+arr[threeNumIndex] < 0){ //前两值向右移动（增大前两值）
                   continue;
               }else{
                   List<Integer> subResult = new ArrayList<>();
                   subResult.add(arr[i]);
                   subResult.add(arr[j]);
                   subResult.add(arr[threeNumIndex]);
                   result.add(subResult);
                   break;
               }
            }
        }
        return result;
    }

    private static void quickSort(int[] arr,int startIndex ,int endIndex){

        if(startIndex <= endIndex){
            return;
        }
        int partitionIndex = startIndex;
        int partitionValue = arr[startIndex];

        while(startIndex <= endIndex){

            while(startIndex <= endIndex){
                if(arr[endIndex] >= partitionValue){
                    endIndex --;
                }else{
                    arr[partitionIndex] = arr[endIndex];
                    partitionIndex  = endIndex;
                    endIndex --;
                    break;
                }
            }
            while(startIndex <= endIndex){
                if(arr[startIndex] <= partitionValue){
                    startIndex ++;
                }else{
                    arr[partitionIndex] = arr[startIndex];
                    partitionIndex = startIndex;
                    startIndex ++;
                    break;
                }
            }
        }

        arr[partitionIndex] = partitionValue;

        if((partitionIndex -1) > startIndex){
            quickSort(arr,startIndex,partitionIndex-1);
        }
        if(endIndex > (partitionIndex+1)) {
            quickSort(arr, partitionIndex + 1, endIndex);
        }
    }
}
