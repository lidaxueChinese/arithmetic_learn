package arithmetic.aa202006.base;
/**
 * Created by lidaxue on 2020/8/18.
 * 接雨水
 * link: https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * 时间复杂度： 两次遍历 O(n)
 * 空间复杂度：O(1)
 *
 */
public class Rainwater {
    public static void main(String[] args) {
        //int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
         int[] height = {0,2,0};
        //todo arr.length > 2
        //find the index of max value
        int maxIndex = 0;
        for(int i =1;i<height.length;i++){
            if(height[i] > height[maxIndex]){
                maxIndex = i;
            }
        }
        System.out.println("the max index is:"+maxIndex+" the value is:"+height[maxIndex]);

        int waterNum = 0;
        int leftHighValue = 0;
        for(int l=0;l<maxIndex;l++){
            if(height[l] < leftHighValue){
                waterNum  = waterNum + leftHighValue - height[l];
            }else{
                leftHighValue = height[l];
            }
        }

        int rightHighValue = 0;
        for(int r = height.length-1;r > maxIndex;r--){
            if(height[r] < rightHighValue){
                waterNum = waterNum + rightHighValue - height[r];
            }else{
                rightHighValue = height[r];
            }
        }
        System.out.println("the water num is:"+waterNum);
    }
}
