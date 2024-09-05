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

public class RecursiveTraverse {
    public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(1890);
    head.next.next = new Node(90);
    head.next.next.next = new Node(189);

    Node curr = head;

    recursiveTraversingLinkedList(curr);

}

public static void recursiveTraversingLinkedList(Node head){
    if(head == null) return;

    System.out.println(head.data);

    recursiveTraversingLinkedList(head.next);
}
}
