package LinkedList;


public class CircularLinkedList {
    public static void main(String[] args) {
        
        
        Node head = new Node(10);
        head.next = new Node(1890);
        head.next.next = new Node(90);
        head.next.next.next = new Node(189);
        head.next.next.next.next=head;
        
        traverseLinked(head);
    }

    public static void traverseLinked( Node head){
        Node curr = head;
        
        while (curr.next != head) {
            System.out.println(curr.data);
            curr= curr.next;
        }
    }
}
