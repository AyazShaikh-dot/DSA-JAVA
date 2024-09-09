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

        // DoublyNode newNode = new DoublyNode(5432);
        // System.out.println(head.prev);

        //   DoublyNode currHead =  insertAtBeginningInDoublyLinkedList(newNode, head);

        //   insertAtEndInDoublyLinkedList(new DoublyNode(123321), currHead);
        //   currHead =reverseDoublyLinkedList(currHead);
    
        // head = reversDoublyLinkedListEfficiently(head);


        // DoublyNode ans = deleteHead(head);

        head = deleteLastNode(head);
        traversingLinkedList(head);

        // traversingLinkedListBackward(temp2.next);
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

    public static void insertAtEndInDoublyLinkedList(DoublyNode nodeToBeInsert , DoublyNode head){

        if(head == null){
            head= nodeToBeInsert;
        }

        DoublyNode curr = head;
        while (curr.next !=null) {
            curr= curr.next;
        }
        curr.next = nodeToBeInsert;
        nodeToBeInsert.prev = curr;
    }

    // NAive Solution
    public static DoublyNode reverseDoublyLinkedList(DoublyNode head){

        if(head == null || head.next ==null)
        return head;

        DoublyNode currNode = head;
        while (currNode.next !=null) {
            currNode = currNode.next;
        }

        DoublyNode lastNode = currNode;
        DoublyNode currHead =head;

        while (head != lastNode) {
            int temp = lastNode.data;
            lastNode.data = currHead.data;
            currHead.data =temp;

            currHead = currHead.next;
            lastNode = lastNode.prev;
        }

        return head;
    }

    // Efficient Solution 

    public static DoublyNode reversDoublyLinkedListEfficiently( DoublyNode head){

        if(head == null || head.next==null) return head;

        DoublyNode currNode = head;
        DoublyNode prev = null;

        while ( currNode != null) {
            prev = currNode.prev;
            currNode.prev= currNode.next;
            currNode.next = prev;

            currNode = currNode.prev;
        }
        return prev.prev;
    }

    //  Delete HEad Of the Doubly Linked List
    public static DoublyNode deleteHead(DoublyNode head){
        if(head == null || head.next == null) 
        return null;

        head= head.next;
        head.prev = null;
        return head;

    }

    // Delete Last Node of Doubly Linked List

    public static DoublyNode deleteLastNode(DoublyNode head){

        if(head == null || head.next ==null)
        return null;

        DoublyNode curr = head;
        while (curr.next != null) {
            curr=curr.next;
        }
        curr.prev.next= null;

        return head;
    }
}
