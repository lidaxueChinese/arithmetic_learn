package arithmetic;

/**
 * Created by ldxPC on 2018/12/9.
 */
public class DynamicPlanning {

    private int[] goldWeight;
    private int[] goldNeedPerson;
    private int goldNum;
    private int totalPerson;
    private String goldWeightAndNeedPerson;

    private int[] lastRowMaxGoldNum;

    public DynamicPlanning(int tempGoldNum,int tempTotalPerson,String tempGoldWeightAndNeedPerson){
        this.goldNum = tempGoldNum;
        this.totalPerson = tempTotalPerson;
        this.goldWeightAndNeedPerson = tempGoldWeightAndNeedPerson;
        lastRowMaxGoldNum = new int[totalPerson];
    }
    public void initDate(){
        goldWeight = new int[goldNum];
        goldNeedPerson = new int[goldNum];
        String[] tempGoldPersonNumArr = goldWeightAndNeedPerson.split(",");
        for(int i =0;i<tempGoldPersonNumArr.length;i++){
            String[] goldWeightAndNeedPersonArr = tempGoldPersonNumArr[i].split(":");
            goldWeight[i] = new Integer(goldWeightAndNeedPersonArr[0]);
            goldNeedPerson[i] = new Integer(goldWeightAndNeedPersonArr[1]);
        }

    }

    public void calculate(){
        for(int i = 0;i<totalPerson;i++){
            if((i+1) >= goldNeedPerson[0]){
                lastRowMaxGoldNum[i] = goldWeight[0];
            }else{
                lastRowMaxGoldNum[i] = 0;
            }
        }

        printData(lastRowMaxGoldNum);


        int[] tempLastRowMaxGoldNum = new int[totalPerson];
        //g=0 已经统计
        for(int g=1;g<goldNum;g++){
            for(int p=0;p<totalPerson;p++){
                 int tempMax = 0;
                 int rowNeendPerson = goldNeedPerson[g];
                 if( (p+1) >= rowNeendPerson){
                     //tempRemainPersonNum表示还剩下的人数
                     int tempRemainPersonNum  = (p+1)-rowNeendPerson;
                     int tempLastRowMaxGoldNum2 = tempRemainPersonNum==0?0:lastRowMaxGoldNum[tempRemainPersonNum-1];
                     tempMax = Math.max(lastRowMaxGoldNum[p],(tempLastRowMaxGoldNum2+goldWeight[g]));
                 }else{
                     tempMax = Math.max(lastRowMaxGoldNum[p],0);
                 }

                tempLastRowMaxGoldNum[p] = tempMax;

            }

            //update the lastRowMaxGoldNum
            for(int t=0;t<tempLastRowMaxGoldNum.length;t++){
                lastRowMaxGoldNum[t] = tempLastRowMaxGoldNum[t];
            }

            printData(lastRowMaxGoldNum);
        }

        printData(lastRowMaxGoldNum);
    }

    public void printData(int[] pa){
        for(int i = 0;i<pa.length;i++){
            System.out.print(pa[i]+",");
        }
        System.out.println();
    }


    public static void main(String[] args){
      DynamicPlanning dynamicPlanning =  new  DynamicPlanning(5,10,"400:5,500:5,200:3,300:4,350:3");
      dynamicPlanning.initDate();
      dynamicPlanning.calculate();
    }


}
