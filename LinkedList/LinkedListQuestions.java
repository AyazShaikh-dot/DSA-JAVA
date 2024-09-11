package LinkedList;

public class LinkedListQuestions {
    
    public static void main(String[] args) {
              
        Node head = new Node(10);

        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        head = insertInSortedLinkedList(head, 34);
        traverseLinkedList(head);
    }

    public static void traverseLinkedList(Node head){
        Node curr= head;
        while (curr !=null) {
            System.out.println(curr.data);
            curr= curr.next;
        }
    }

    public static Node insertInSortedLinkedList(Node head , int x){
        Node nodeTobeInserted = new Node(x);
        if(head == null){
            return nodeTobeInserted;
        }
        if(x<head.data){
            nodeTobeInserted.next=head;
            return nodeTobeInserted;
        }
        Node curr = head;

        while ( curr.next !=null && curr.next.data<x) {
            curr= curr.next;
        }
        nodeTobeInserted.next =curr.next;
        curr.next = nodeTobeInserted;

        return head;
    }
}
