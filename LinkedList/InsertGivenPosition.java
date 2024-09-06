package LinkedList;

class Node{
    int data;
    Node next;

    Node(int x){
        data =x;
        next= null;
    }
}
public class InsertGivenPosition {
    
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(1890);
        head.next.next = new Node(90);
        head.next.next.next = new Node(189);

        Node cur =insertInLinkedListAtGivenPosition(893, 3, head);
        

        recursiveTraversingLinkedList(cur);

    }

    public static Node insertInLinkedListAtGivenPosition(int value, int pos , Node head){

        Node insertNode  = new Node(value);
        // If someone  want to insert At Beginning
        if(pos == 1){
             insertNode.next = head;
             head = insertNode;
             return head;
        }
        
        int cur = 1;
        Node currNode = head;
        while (pos-2>=cur && currNode !=null ) {
            currNode = currNode.next;
            cur++;
        }

        //  if position is greater than the lenght of LinkedList
        if(currNode == null) return head;
      
        insertNode.next = currNode.next;
        currNode.next = insertNode;
       
        return head;
        
    }

    
public static void recursiveTraversingLinkedList(Node head){
    if(head == null) return;

    System.out.println(head.data);

    recursiveTraversingLinkedList(head.next);
}
}
