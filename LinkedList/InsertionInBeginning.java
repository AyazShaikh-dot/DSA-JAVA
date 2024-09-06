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
public class InsertionInBeginning {
    
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(1890);
        head.next.next = new Node(90);
        head.next.next.next = new Node(189);
    
      

        Node newHead = insertInBeginningOfSingleList(420, head);

        Node curr = newHead;
    
        recursiveTraversingLinkedList(curr);
    
    }

    public static Node insertInBeginningOfSingleList(int x, Node head){

        Node curr = new Node(x);

        curr.next =head;

        return curr;
    }
    
    public static void recursiveTraversingLinkedList(Node head){
        if(head == null) return;
    
        System.out.println(head.data);
    
        recursiveTraversingLinkedList(head.next);
    }
    }