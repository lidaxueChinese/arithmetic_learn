package arithmetic.aa202006.link;
/**
 * Created by lidaxue on 2020/9/1.
 * 发现环的入口 ： 剑指offer
 *
 *
 * 时间复杂度 =  寻找是否有环 0（n） + 寻找环的大小 O（n） + 两指针共同走到环入口 O(n) ,,即总体时间复杂度为 O(n)
 *
 * 空间复杂度：O(1)
 *
 * 关键点：
 * 可以理解 环的入口是最终点（设置环大小为m），那么第二指针需要多走m步，即可以让第二个指针先走m步，那么两个指针必然会相交。相交点就是环的入口了
 */
public class LinkLoopEntrance {

    private static class Node{
        public Node(Node node, Integer value){
            this.next = node;
            this.value = value;
        }
        Node next;
        Integer value;
    }

    public static void main(String[] args) {
        Node node6 = new Node(null,6);
        Node node5 = new Node(node6,5);
        Node node4 = new Node(node5,4);
        Node node3 = new Node(node4,3);
        Node node2 = new Node(node3,2);
        Node node1 = new Node(node2,1);

        node6.next = node3;

        LinkLoopEntrance linkLoopEntrance = new LinkLoopEntrance();
       int value =  linkLoopEntrance.findLoop(node1);

       //我们把环的入口（大小为n）当作 当作两个指针 移动过程中的最后一个节点。。 即第二个指针（需要走环绕一圈的） 需要先移动n步
       if(value > 0){ //有环,
           System.out.println("has the loop .the loop size is:"+value);
           Node first = node1;
           Node second = node1;
           int n = value;
           while(n > 0){
               second = second.next;
               n --;
           }

           while(first != second){
               first = first.next;
               second = second.next;
           }

           Node entranceNode = first;
           System.out.println("the entrance node value is:"+entranceNode.value);

       }else{
           System.out.println("not has the loop .the loop size is:"+value);
       }


    }

    /**
     * 返回值为-1 表示没有环，返回>0表示有环并返回环的大小
     * @param node
     * @return
     */
    private int findLoop(Node node){
        //init
        Node first = node;
        Node second = node;
        while(second != null){
            if(second.next != null){
                second = second.next.next;
                first = first.next;
                if(second != null && first == second){
                    return loopSize(second);
                }
            }
        }
        return -1;
    }

    private int loopSize(Node node){
        Node temp = node.next;
        int size = 1;
        while(temp != node){
            temp = temp.next;
            size ++;
        }
        return size;
    }
}
