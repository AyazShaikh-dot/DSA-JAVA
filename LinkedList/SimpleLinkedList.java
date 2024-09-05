package LinkedList;

// Creating Node of Linked List 
// Self Refentials 
class Node{
    int data ;
    Node next;
    // Constructor of linked List
    Node(int x){
        data = x;
        next=null;
    }
}
public class SimpleLinkedList {

    public static void main(String[] args) {
        
        Node head = new Node(10);
        Node temp1 = new Node(30);
        Node temp2 = new Node(90);

        head.next =temp1;
        temp1.next = temp2;

        //  Traversing Linked List
        SimpleLinkedList tem = head;

        while (tem!=null) {
            System.out.println(tem.value);
            tem= tem.next;
        }
        
    }
}


