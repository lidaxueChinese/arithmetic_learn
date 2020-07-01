package arithmetic.aa202006.link;
/**
 * Created by lidaxue on 2020/7/1.
 *问题描述：给定两个升序链表，打印两个升序链表的公共部分
 * 输出描述：输出一行整数表示两个升序链表的公共部分的值 (按升序输出)
 * eg:
 * 输入
 *1 2 3 4
 *1 2 3 5 6
 *输出
 *1 2 3
 *
 *
 * 疑问：是否存在多个公共的部分
 */
public class AscLinkCommonPart {
   private static class Node{
       public Node(Node node,Integer value){
           this.next = node;
           this.value = value;
       }
       Node next;
       Integer value;
   }

    public static void main(String[] args) {
        Node link1Node3 = new Node(null,3);
        Node link1Node2 = new Node(link1Node3,2);
        Node link1Node1 = new Node(link1Node2,1);
        Node link1NodeBase = new Node(link1Node1,0);

        Node link2Node5 = new Node(null,5);
        Node link2Node4 = new Node(link2Node5,4);
        Node link2Node3 = new Node(link2Node4,3);
        Node link2Node2 = new Node(link2Node3,2);
        Node link2NodeBase = new Node(link2Node2,1);
        StringBuilder commonStringBuilder = new StringBuilder();
        boolean isHaveCommonPart = false;
        while(link1NodeBase != null && link2NodeBase != null){
                Integer baseValue = link1NodeBase.value;
                Integer compareValue = link2NodeBase.value;
                if(baseValue == compareValue){
                    commonStringBuilder.append(baseValue).append(" ");
                    isHaveCommonPart = true;
                    link1NodeBase = link1NodeBase.next;
                    link2NodeBase = link2NodeBase.next;
                }else{
                    if(isHaveCommonPart){
                        break;
                    }else if(baseValue < compareValue){
                        link1NodeBase = link1NodeBase.next;
                    }else{
                        link2NodeBase = link2NodeBase.next;
                    }
                }
            }

            System.out.println("the common part is:"+commonStringBuilder.toString());

    }



}
