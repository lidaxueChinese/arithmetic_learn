package arithmetic;

/**
 * Created by ldxPC on 2018/12/10.
 */
public class QuickSort {


    int[] needSortData;

    public QuickSort(int[] tempData){
        needSortData = tempData;
    }

    public void sort(int left ,int right){

        //边界条件
        if(left >= right){
            return;
        }

        int partitionIndex = getPartition(needSortData[left],left,right);

        sort(0,partitionIndex-1);

        sort(partitionIndex+1,right);



    }


    private int getPartition(int baseData,int left,int right){
         while(left < right){
               //从right start
               while(left < right){
                    if(needSortData[right] >= baseData){
                        right --;
                    }else{
                        //right所在位置的元素 插入到left 位置上
                        needSortData[left] = needSortData[right];
                        left ++;
                        //居然right
                        break;
                    }
               }

               while(left < right){
                   if(needSortData[left] <= baseData){
                       left ++ ;
                   }else{
                       needSortData[right] = needSortData[left];
                       right --;
                       break;
                   }
               }

               if(left == right){
                   needSortData[left] = baseData;
               }

         }

         return left;
    }


    public static void main(String[] args){
        //int[] temp = {4,7,6,5,3,2,8,1};
        int[] temp = {10,9,8,7,6,5,4,3,2,1};
        QuickSort quickSort = new QuickSort(temp);
        quickSort.sort(0,temp.length-1);

        for(int i = 0;i<temp.length;i++){
            System.out.println(temp[i]+",");
        }
    }
}
