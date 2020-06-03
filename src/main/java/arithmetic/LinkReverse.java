package arithmetic;

/**
 * Created by ldxPC on 2019/3/2.
 * 链表反转
 */
public class LinkReverse {


    private static LinkNode reverse(LinkNode originNode){

        if(originNode == null || originNode.next == null ){
            return originNode;
        }
        //init the  last node of reverse link
        LinkNode lastNode = new LinkNode(originNode.value,null);


        LinkNode nextNode = originNode.next;
        LinkNode currentNode = originNode.next;
        while (nextNode != null){

            nextNode = nextNode.next;

            //当前元素反转指向上一个元素o
            LinkNode tempLastNode = new LinkNode(lastNode.value,lastNode.next);

            currentNode.next = tempLastNode; //lastNode;

            //update the last node
            lastNode.setValue(currentNode.getValue());
            lastNode.setNext(currentNode.getNext());

            currentNode = nextNode;

        }
        return lastNode;

    }

    static void printlnLink(LinkNode linkNode){
        LinkNode tempNode = linkNode;
        while(tempNode != null){
            System.out.print(tempNode.value+"->");
            tempNode = tempNode.next;
        }
    }

    public static void main(String[] args) {


        LinkNode sevenNode = new LinkNode(7,null);
        LinkNode sixNode = new LinkNode(5,sevenNode);
        LinkNode fiveNode = new LinkNode(4,sixNode);
        LinkNode fourNode = new LinkNode(11,fiveNode);
        LinkNode threeNode = new LinkNode(9,fourNode);
        LinkNode twoNode = new LinkNode(2,threeNode);
        LinkNode oneNode = new LinkNode(1,twoNode);
        printlnLink(oneNode);
        System.out.println("=============================");
        LinkNode reverseFirstNode = reverse(oneNode);

        printlnLink(reverseFirstNode);
        System.out.println("=============================");
    }

    private static class LinkNode{
         int value ;
         LinkNode next;

         public LinkNode(int pValue,LinkNode pLinkNode){
             this.value = pValue;
             this.next = pLinkNode;
         }
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public LinkNode getNext() {
            return next;
        }

        public void setNext(LinkNode next) {
            this.next = next;
        }
    }
}
