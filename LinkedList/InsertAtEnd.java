package LinkedList;

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next= null;
    }
}
public class InsertAtEnd {
    
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(1890);
        head.next.next = new Node(90);
        head.next.next.next = new Node(189);

        insertAtEndOfLinkedList(87, head);
        traversingLinkedList(head);
    }

    public static void insertAtEndOfLinkedList(int x , Node head){
       
        Node newNode = new Node(x);

        if(head ==null) head = newNode;

        else{

            Node temp = head;
            while (temp.next !=null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    public static void traversingLinkedList(Node head){
        Node curr = head;
        while (curr !=null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

}
