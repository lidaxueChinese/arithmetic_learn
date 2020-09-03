package arithmetic.aa202006.iqtest;
/**
 * Created by lidaxue on 2020/9/3.
 *
 */
public class DistributionBall {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/26b2392f3e144dfaafad43d59bafd60a
     来源：牛客网

     现在有50个红球，50个蓝球，给小明两个袋子，一个袋子能装任意个球(0~100)。
     现由小明将这100个球，以一定方法装入这两个袋子。找另找一个不明真相的路人，
     闭眼，随机从两个袋子中随机选择一个袋子并摸一个球。要使得他摸出红球的概率最高，
     小明分配这100个球的最佳方案是

      分球方案

     1号袋          2号袋
     only 红        红+ 蓝    ===> 1号袋 放一个概率肯定最大 ，概率>0.5
     only 蓝        红+ 蓝    ====> 概率<=0.5
     无             红+ 蓝    ====> 概率 = 0.5
     红+蓝（红 ：m; 蓝：n，1<=m< 50;1<=n<50） 红 + 蓝  0.5*p2 + 0.5*p2
     */
}
