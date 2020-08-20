package arithmetic.aa202006.base;
/**
 * Created by lidaxue on 2020/8/19.
 * 大数相乘
 * leetcode link : https://leetcode-cn.com/problems/multiply-strings/
 *
 *  大数相乘的本质： 2层for循环
 *   9   9
 *   9   9  9
 *
 *  第一次计算        8  1
 *  第二次计算     8  1
 *  第三次计算  8  1
 *  第四次计算     8  1
 *  第n次计算   * * *
 *
 *  m 和 n 分别表示两个数的长度
 *  时间复杂度 O（m * n）
 *  空间复杂度O(m + n)
 *
 *
 */
public class BigNumMultiply {

    public static void main(String[] args) {
        String valueStr = multiply("99","999");
        System.out.println("valueStr is:"+valueStr);
    }

    private  static String multiply(String num1,String num2){

        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] multiplyArr = new int[len1+len2];

        for(int i = len1-1;i>=0;i--){
            int iv = num1.charAt(i) - '0';
            for(int j = len2-1;j>=0;j--){
                int jv = num2.charAt(j) - '0';
                int value = iv * jv;
                //在数组中的偏移量
                int lowBitOffset = i+j+1;
                int sum = multiplyArr[lowBitOffset]+value;
                multiplyArr[lowBitOffset] = sum % 10;
                //TODO 进一位为什么可以直接相加？？
                /**
                 * 哎，死记吧
                 */
                multiplyArr[lowBitOffset-1] += sum/10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<multiplyArr.length;i++){
            if(multiplyArr[i] == 0 && stringBuilder.toString().isEmpty()){
                continue;
            }
            stringBuilder.append(multiplyArr[i]);
        }
        return stringBuilder.toString();
    }

    public static String multiply_test(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }


}
