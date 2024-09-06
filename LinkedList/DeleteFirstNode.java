package LinkedList;

class Node{
    int data;
    Node next;

    Node(int x){
        data =x;
        next= null;
    }
}
public class DeleteFirstNode {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(1890);
        head.next.next = new Node(90);
        head.next.next.next = new Node(189);

        Node cur =deleteFirstNodeOfLinkedList(head);
        

        recursiveTraversingLinkedList(cur);

    }
    public static Node deleteFirstNodeOfLinkedList(Node head){
        if(head == null) return head;

        head = head.next;
        return head;
    }

    public static void recursiveTraversingLinkedList(Node head){
        Node temp = head;
        if(temp == null) return;

        System.out.println(temp.data);
        recursiveTraversingLinkedList(temp.next);
    }
}
