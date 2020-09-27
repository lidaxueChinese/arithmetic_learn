package arithmetic.aa202006.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 该问题是：字符串最大 子字符串
 * leetcode: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 解决方案：通过滑动窗口
 * 通过一个窗口 维护一个有序的 无重复的字符窗口（queue），当遇到重复的字符时，
 * 先计算无重复元素大小， 然后 将 队列 第一个元素 到 重复的元素 移除掉。 依次类推
 *
 * 注意点： 如果解决 遇到重复元素，将队列第一个元素到重复的元素 移除，总不至于真的需要构建一个队列吧
 * 优化方案：
 * 通过map,记录每个字符 对应的index 位置信息，通过维护一个startIndex。 字符index 比 startIndex 小的元素我们认为是已经被移除的元素
 *
 * 时间复杂度 O(n) * O(map.get) ,这里map.get 可以认为是O（1），即时间复杂度是O（n）
 * 空间复杂度 O(n) ,即map的大小
 */

/**
 * Created by lidaxue on 2020/9/27.
 */
public class MaxLengthOfSubString {

    public static void main(String[] args) {
        String ff = "abcba";
        MaxLengthOfSubString maxLengthOfSubString = new MaxLengthOfSubString();
       int value =  maxLengthOfSubString.lengthOfLongestSubstring(ff);
       System.out.println("the max length is:"+value);
    }

    Map<Character,Integer> map = new HashMap<Character,Integer>();

    public int lengthOfLongestSubstring(String s) {

        if(s == null){
            return 0;
        }
        int maxLength = 0;

        int startIndex = 0;
        for(int i = 0;i<s.length();i++){
            //遇到重复的元素了
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= startIndex){
              int length = i-startIndex;
              startIndex = map.get(s.charAt(i)) + 1;
              map.put(s.charAt(i),i);

              maxLength = (length > maxLength) ? length : maxLength;
            }else{
                map.put(s.charAt(i),i);
            }

        }
        int tempMax = (s.length() - 1) - startIndex +1;
        if(tempMax > maxLength){
            return tempMax;
        }else{
            return maxLength;
        }
    }
}
