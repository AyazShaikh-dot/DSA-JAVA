package LinkedList;

public class LinkedListQuestions {
    
    public static void main(String[] args) {
              
        Node head = new Node(10);

        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);

        // head = insertInSortedLinkedList(head, 34);


        // System.out.println(middleOfLinkedList(head));

        System.out.println(slowAndFastPointer(head));

        // traverseLinkedList(head);
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


    public static int middleOfLinkedList(Node head){
        if(head == null)
        return -1;

        // if(head.next ==null) return head.data;  //This case is check already check in below code

        int length = 0;
        
        Node curr = head;
      
        while (curr!=null) {
            curr=curr.next;
            length++;
        }
     
            Node temp = head;
            int i=1;
            int pos= length/2;
            while (i<=pos) {
                temp=temp.next;
                i++;
            }
            return temp.data;
       
    }

    public static int slowAndFastPointer(Node head){

        if(head == null)
        return -1;

        Node slow =head , fast =head;
        while (fast !=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }
}
