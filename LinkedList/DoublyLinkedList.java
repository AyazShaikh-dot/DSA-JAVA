package LinkedList;

class DoublyNode{
    int data;
    DoublyNode prev;
    DoublyNode next;

    DoublyNode(int x){
        data = x;
    }
}
public class DoublyLinkedList {
    public static void main(String[] args) {
        
        DoublyNode head = new DoublyNode ( 90);
        DoublyNode temp1 = new DoublyNode(80);
        DoublyNode temp2 = new DoublyNode(65);

        head.next =temp1;
        temp1.next= temp2;
        temp1.prev = head;
        temp2.prev= temp1;

        DoublyNode newNode = new DoublyNode(5432);
        // System.out.println(head.prev);

      DoublyNode currHead =  insertAtBeginningInDoublyLinkedList(newNode, head);

        traversingLinkedList(currHead);

        traversingLinkedListBackward(temp2);
    }

    public static void traversingLinkedList(DoublyNode head){

        DoublyNode currNode = head;
        while (currNode != null) {
            System.out.println(currNode.data);
            currNode= currNode.next;
        }
    }

    public static void traversingLinkedListBackward(DoublyNode lastNode){

        DoublyNode currNode = lastNode;
        while (currNode != null) {
            System.out.println(currNode.data);
            currNode= currNode.prev;
        }
    }

    public static DoublyNode insertAtBeginningInDoublyLinkedList(DoublyNode nodeToBeInsert , DoublyNode head){

        if(head == null){
            return nodeToBeInsert;
        }
        nodeToBeInsert.next= head;
        head.prev = nodeToBeInsert;

        return nodeToBeInsert;
    }
}
