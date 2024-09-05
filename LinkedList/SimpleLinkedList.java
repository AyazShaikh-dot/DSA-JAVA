package LinkedList;

public class SimpleLinkedList {
    // Creating Node 
    int value;
    SimpleLinkedList next;
    // Constructor
    SimpleLinkedList(int x){
        value =x;
        next =null;
    }
    public static void main(String[] args) {
        
        SimpleLinkedList head = new SimpleLinkedList(10);
        SimpleLinkedList temp1 = new SimpleLinkedList(30);
        SimpleLinkedList temp2 = new SimpleLinkedList(90);

        head.next =temp1;
        temp1.next = temp2;

        //  Traversing Linked List
        SimpleLinkedList tem = head;

        while (tem!=null) {
            System.out.println(tem.value);
            tem= tem.next;
        }
        
    }
}


