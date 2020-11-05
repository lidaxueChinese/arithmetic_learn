package arithmetic.aa202006.sort;
/**
 * Created by lidaxue on 2020/11/5.
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1,4,3,6,8,2,0};
        int[] pos = new int[arr.length];
        MergeSort mergeSort = new MergeSort();
       // mergeSort.recursionMergeSort(arr,pos,0,arr.length-1);
        mergeSort.iteMergeSort(arr,pos);
        System.out.println("=====");

    }
    //递归版
    public void recursionMergeSort(int[] arr,int[] pos,int startIndex,int endIndex){

        if(startIndex >= endIndex){
            return;
        }
        int middleIndex = startIndex + (endIndex-startIndex)/2;
        int leftStartIndex = startIndex;
        int leftEndIndex = middleIndex;

        int rightStartIndex = middleIndex+1;
        int rightEndIndex = endIndex;

        recursionMergeSort(arr,pos,leftStartIndex,leftEndIndex);
        recursionMergeSort(arr,pos,rightStartIndex,rightEndIndex);
        int index = startIndex;

        while(leftStartIndex <= leftEndIndex && rightStartIndex<=rightEndIndex){
            if(arr[leftStartIndex] < arr[rightStartIndex]){
              pos[index++] = arr[leftStartIndex++];
            }else{
                pos[index++] = arr[rightStartIndex++];
            }
        }
        while(leftStartIndex <= leftEndIndex){
            pos[index++] = arr[leftStartIndex++];
        }
        while(rightStartIndex<=rightEndIndex){
            pos[index++] = arr[rightStartIndex++];
        }

        //保持arr 和 pos 一致，为了合并时保持arr也是有序的
        for(int i = startIndex;i<=endIndex;i++){
            arr[i] = pos[i];
        }

    }


    //遍历迭代
    public void iteMergeSort(int[] arr,int[] pos){
        int arrLen = arr.length;
        for(int step = 1;step<arrLen;step*=2){
            for(int start=0;start<arrLen;start=start+2*step){
                int leftStartIndex = start;
                int leftEndIndex = Math.min(leftStartIndex+step-1,arrLen-1);
                int rightStartIndex = leftEndIndex+1;
                int rightEndIndex =  Math.min(rightStartIndex+step-1,arrLen-1);
                int index = start;
                while(leftStartIndex <= leftEndIndex && rightStartIndex<=rightEndIndex){
                    if(arr[leftStartIndex] < arr[rightStartIndex]){
                        pos[index++] = arr[leftStartIndex++];
                    }else{
                        pos[index++] = arr[rightStartIndex++];
                    }
                }
                while(leftStartIndex <= leftEndIndex){
                    pos[index++] = arr[leftStartIndex++];
                }
                while(rightStartIndex<=rightEndIndex){
                    pos[index++] = arr[rightStartIndex++];
                }

                //将arr同步成pos 一样的
                for(int k = start;k<=rightEndIndex;k++){
                    arr[k] = pos[k];
                }
            }
        }
    }

}
