package arithmetic.aa202006.sort;
/**
 * Created by lidaxue on 2020/10/24.
 * 快速排序
 *
 * 思想：开始找到一个partitionIndex ,并保存partitionValue。双指针，如果选取的partitionIndex 取得左边第一个，那么
 * 从右指针开始->左扫描，遇到比partitionValue 小的放到partitionIndex位置，那么partitionIndex 就变换成该位置，再从
 * 左指针开始->右扫描。
 * 相当于partitionIndex专门用来存放比partitionValue 大或者小的值的，当左右指针相等的时候，则存放partitionValue
 *
 * 不稳定排序
 * 平均时间复杂度为 nlog2 n
 * 最差时间复杂度为 n^2
 * 空间复杂度：log2 n  (递归深度为log2 n )
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,4,9};
        QuickSort obj = new QuickSort();
        obj.quickSortImp(arr,0,arr.length-1);
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public void quickSortImp(int[] arr,int startIndex,int endIndex){
        if(startIndex >= endIndex) return;

        int partitionIndex = startIndex;
        int partitionValue = arr[startIndex];

        int lIndex = startIndex;
        int rIndex = endIndex;

        while(lIndex < rIndex){
            while(lIndex < rIndex){
                if(arr[rIndex] >= partitionValue){
                    rIndex --;
                }else{
                    //TODO 容易忽略,当遇到比partitionValue 小的时候，将改值交换到partitionValue,修改partitionValue.注意这个时候break,从左边进行遍历

                    arr[partitionIndex] = arr[rIndex];
                    partitionIndex = rIndex;
                    break;
                }
            }

            while(lIndex < rIndex){
                if(arr[lIndex] <= partitionValue){
                    lIndex ++;
                }else{
                    //TODO　和上述同理
                    arr[partitionIndex] = arr[lIndex];
                    partitionIndex = lIndex;
                    break;
                }
            }
        }

        // lIndex 必然会和 rIndex 相等
        arr[lIndex] = partitionValue;

        //递归左边
        quickSortImp(arr,startIndex,lIndex-1);

        //递归右边
        quickSortImp(arr,lIndex+1,endIndex);


    }
}
