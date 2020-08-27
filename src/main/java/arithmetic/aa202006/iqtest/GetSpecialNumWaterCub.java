package arithmetic.aa202006.iqtest;/**
 * Created by lidaxue on 2020/8/27.
 *
 * 8升水，有一个5L的杯子和3L的杯子，怎么得到4升水
 *
 * 通过将5L杯子中的水倒入到3L杯子中，通过差值获取 其他L的水量（5L杯中的水剩余）
 */
public class GetSpecialNumWaterCub {

    /**
     *  1. 5L杯子倒满
     *  2. 5L杯子水 倒入到3L杯子中（5L杯子得到2L）
     *  3. 3L杯子水倒入原始容器中，5L杯子中的水 倒入到3L中的容器中(3L杯子中有2L的水)
     *  4. 将5L中的杯子倒满，将5L中的水倒入到3L的杯子中，直到3L杯子倒满（3L杯子倒满需要1L）,5-1=4L即5L的杯子中还有4L的水
     */
}
