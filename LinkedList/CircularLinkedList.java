package LinkedList;


public class CircularLinkedList {
    public static void main(String[] args) {
        
        
        Node head = new Node(10);

        head.next = new Node(1890);
        head.next.next = new Node(90);
        head.next.next.next = new Node(189);
        head.next.next.next.next=head;

        // head.next=head;
        // head=null;
        
        // head = insertAtBeginnig(head, 900);

        // head =effecientInsertAtBeginning(head, 909);

        // head = naiveInsertAtEnd(head, 101);

        // head = effecientltInsertAtEnt(head, 505);

        // head = naiveDeleteHead(head);

        head = effecientDeleteNode(head);

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

    // NAive Solution O(N)
    public static  Node insertAtBeginnig( Node head , int x){

        Node nodeToBeInserted = new Node(x);
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

    //  Efficient Solutiom

    public static Node effecientInsertAtBeginning(Node head , int x){

        Node nodeToBeInserted = new Node(x);
        if(head == null){
            nodeToBeInserted.next = nodeToBeInserted;
            return nodeToBeInserted;
        }

        nodeToBeInserted.data = head.data;
        head.data =x;
        nodeToBeInserted.next = head.next;
        head.next = nodeToBeInserted;

        return head;
    }

    // Naive Solution 
    public static Node naiveInsertAtEnd(Node head, int x){
        Node newNode = new Node(x);
        if(head == null){
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.next = head;

        return head;
    }

    //  Efficient solution

    public static Node effecientltInsertAtEnt (Node head , int x){
        Node newNode = new Node(x);
        if(head == null){
            newNode.next = newNode;
            return newNode;
        }
        
        newNode.data= head.data;
        head.data = x;

        newNode.next = head.next;
        head.next= newNode;

        return newNode;
        
    }

    //  Naive Solution
    public static Node naiveDeleteHead(Node head){
        if(head == null || head.next==head){
            return null;
        }

        Node curr= head;
        while (curr.next != head) {
            curr= curr.next;
        }
        curr.next = head.next;
         return head.next;
    }

    //  Effecient Solution

    public static Node effecientDeleteNode(Node head ){
        if(head == null || head.next==head){
            return null;
        }

        head.data= head.next.data;
        head.next = head.next.next;

        return head;
    }

}
