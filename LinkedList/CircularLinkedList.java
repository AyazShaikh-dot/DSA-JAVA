package LinkedList;


public class CircularLinkedList {
    public static void main(String[] args) {
        
        
        Node head = new Node(10);

        head.next = new Node(1890);
        head.next.next = new Node(90);
        head.next.next.next = new Node(189);
        head.next.next.next.next=head;
        
        head = insertAtBeginnig(head, new Node(900));
        traverseLinked(head);
    }

    public static void traverseLinked( Node head){

        if(head == null) return;
        Node curr = head.next;
        System.out.println(head.data);
        while (curr!= head) {
            System.out.println(curr.data);
            curr= curr.next;
        }
    }

    public static  Node insertAtBeginnig( Node head , Node nodeToBeInserted){

        if(head == null){
            nodeToBeInserted.next = nodeToBeInserted;
            return nodeToBeInserted;
        }
        Node curr = head;
        while (curr.next!=head) {
            curr= curr.next;
        }

        nodeToBeInserted.next=head;
        curr.next=nodeToBeInserted;

        return nodeToBeInserted;

    }
}
