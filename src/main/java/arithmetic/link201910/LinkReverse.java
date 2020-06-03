package arithmetic.link201910;
/** 链表反转
 * 这次完成的速度比第一次还是快了不少
 * 1. 反转的时候，注意保存 next,因为pre.next会被修改，原来的next将会丢失，所以需要先保存起来
 * 2. 维护一个pre，其实每次处理完后，除了保存next. 还需要维护pre,pre就是当前的“自己”啦
 * 3. 注意临界条件。当然也是每次需要注意的
 * Created by 10718 on 2019/10/18.
 */
public class LinkReverse {

    private static NodeLink reverse(NodeLink link){

        NodeLink reverseLink = null;
        NodeLink main = link;
        NodeLink pre = null;
         
        while(main != null){
            
            NodeLink next = main.next;
            NodeLink curr = main;
            curr.next = pre;
            pre = curr;
            
            main = next;
            if(main==null){
                reverseLink = curr;
            }
        }
        return reverseLink;
        
    }

    static void printlnLink(NodeLink nodeLink){
        NodeLink tempNode = nodeLink;
        while(tempNode != null){
            System.out.print(tempNode.data+"->");
            tempNode = tempNode.next;
        }
    }

    public static void main(String[] args) {
        NodeLink threeNode = new NodeLink(3,null);
        NodeLink twoNode = new NodeLink(2,threeNode);
        NodeLink oneNode = new NodeLink(1,twoNode);

        NodeLink reverseFirstNode = reverse(oneNode);

        printlnLink(reverseFirstNode);
    }

    private  static class NodeLink {
        
        
        int data;
        NodeLink next;
        
        public NodeLink(int data,NodeLink next){
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public NodeLink getNext() {
            return next;
        }

        public void setNext(NodeLink next) {
            this.next = next;
        }
    }

}
