package LinkedList;
import java.util.*;

public class LinkedListQuestions {
    
    public static void main(String[] args) {
              
        Node head = new Node(10);

        // head.next=head;
        head.next = new Node(90);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next = new Node(9);

        // head.next.next.next.next.next.next.next = head;





        // head = insertInSortedLinkedList(head, 34);


        // System.out.println(middleOfLinkedList(head));

        // System.out.println(slowAndFastPointer(head));

        // System.out.println(NthNodeFromLast(head, 6));
        // System.out.println(effecientSolutionOfNthNodeFromLast(head, 6));

        // naiveReverse(head);

        // head = effecientlyReverseLinkedList(head);

        // head = recursiveReverseMethod1(head);

        // head = removeDup(head);

        // head = reverseInGroup(head, 3);

        // head = reverseInGroupIteratively(head, 4);
        
        // System.out.println(floydCycleDetection(head));
        // System.out.println(usingHashingCycleDetection(head));

        // detectAndRemoveUsingHashing(head);

        // detectAndRemoveCycleUsingFloydAlgo(head);

        head = segregateOddEven(head);

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

    // Print Nth Node from the last of the Linked List

    public static int NthNodeFromLast(Node head , int n){
        if(head == null){
            return -1;
        }

        int length = 1;
        Node curr = head;

        while ( curr.next !=null) {
            curr= curr.next;
            length++;
        }

        if(length<n) return -1;

       int nThNodeFromStarting = length - n + 1;
    //    System.out.println(nThNodeFromStarting);
       int i=1;
       Node temp =head;
       while (i<nThNodeFromStarting) {
        temp=temp.next;
        i++;
       }

       return temp.data;
    }

    public static int effecientSolutionOfNthNodeFromLast( Node head, int pos){

        if(head == null) return -1;

        int i =1;
        Node fast= head ,slow = head;
        while ( i<=pos) {
            if(fast==null) return -1;
            fast = fast.next;
            i++;
        }

        while (fast !=null) {
            fast= fast.next;
            slow = slow.next;
        }

        return slow.data;
    }

    // Reverse A Linked List

    public static void naiveReverse(Node head){
        ArrayList <Integer> cpy = new ArrayList<Integer>();
        Node curr = head;
        while (curr!=null) {
            cpy.add(curr.data);
            curr=curr.next;
        }

        // System.out.println(cpy.size());

        Node temp = head;
        while (temp!=null) {
            temp.data= cpy.remove(cpy.size()-1);
            temp=temp.next;
        }

    }

    public static Node effecientlyReverseLinkedList(Node head){

        Node curNode= head;
        Node prevNode = null;
        Node next= null;

        while (curNode !=null) {
            next = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode  = next;
        }

         return prevNode;
    }

    // Recursive Reverse Linked List Method 1

    public static Node recursiveReverseMethod1(Node head){
      
        if(head ==null || head.next == null) return head;
        Node restHead = recursiveReverseMethod1(head.next);
        
        Node restTail = head.next;
        head.next = null;
        restTail.next = head;

        return restHead;
    }

    //  Recursive Solution Meyhod 2

    public static Node recurSiveSolutionMethod2(Node curr , Node prev){
        if(curr == null) return prev;

      Node next =curr.next;
      curr.next = prev;
      return recurSiveSolutionMethod2(next, curr);

    }

    //  Remove Duplicates from Sorted Linked List

    public static Node removeDup(Node head){
        if(head == null || head.next == null)
        return head;

        Node curr = head;
        while (curr.next != null) {
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            }

            else{
                curr= curr.next;
            }
        }
        return head;
    }

    // Revserse A Linked List in Groups

    public static Node reverseInGroup(Node head ,int k){

        // if(head == null || head.next == null ) return head;

        Node prevNode = null;
        Node next = null;
        Node curr = head;

        int count = 1;

        while (curr !=null && count <= k) {
            next = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = next;

            count++;
        }
        if(next!=null){
        Node restHead = reverseInGroup(next, k);
        head.next = restHead;
        }
        return prevNode;
        
    }

    public static Node reverseInGroupIteratively(Node head ,int k){

        // if(head == null || head.next == null ) return head;
        Node curr = head;
        Node prevFirst =null;
        boolean isFirstPass =true;
        while (curr != null) {
            Node prevNode = null;
            Node next = null;
    
            int count = 1;
            Node first = curr;
            
            while (curr !=null && count <= k) {
                next = curr.next;
                curr.next = prevNode;
                prevNode = curr;
                curr = next;
    
                count++;
            }

            if(isFirstPass){
                head = prevNode;
                isFirstPass= false;
            }
            else{
                prevFirst.next = prevNode;
            }
            prevFirst = first;
        }

        return head;
      
    }

    // Detect Loop in linked List

    public static boolean usingHashingCycleDetection(Node head){

        HashSet<Node> hs = new HashSet<>();
      
        Node curr = head;
        while (curr!=null) {
            if(hs.contains(curr)) return true;

            hs.add(curr);
            curr=curr.next;
        }
        return false;
    }
    
    public static boolean floydCycleDetection(Node head){
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null) {
            
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            return true;
        }

        return false;
    }

    //  Detect and Remove Cycle from Linked List

    // First using hashing 
    public static Node detectAndRemoveUsingHashing( Node head){
        HashSet <Node> hs = new HashSet<>();

        Node curr = head;
        while (curr != null) {
            if(hs.contains(curr.next)){
                curr.next=null;
                return head;
            }
            hs.add(curr);
            curr =curr.next;
        }

        return head;
    }

    public static void detectAndRemoveCycleUsingFloydAlgo(Node head){

        if(head == null || head.next == null) return ;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next!=null) {
            slow =slow.next;
            fast=fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(slow != fast){
            return ;
        }

        slow = head;
        while (slow.next !=fast.next) {
            slow=slow.next;
            fast=fast.next;
        }
        fast.next = null;
    }

    // Delete Note with only Pointer Given to it

    public static void  deleteNodeWithGivenPointer(Node nodeToBeDeleted){
        nodeToBeDeleted.data = nodeToBeDeleted.next.data;
        nodeToBeDeleted.next = nodeToBeDeleted.next.next;
    }

    //  Segregate Even odd Linked list

    public static Node segregateOddEven(Node head){
        if(head ==null || head.next == null)
        return head;

        Node currNode = head;
        Node nextOddNode = head;

        while (nextOddNode != null) {
            if(nextOddNode.data %2 ==0){
                int temp =nextOddNode.data;
                nextOddNode.data = currNode.data;
                currNode.data = temp;
                
                currNode = currNode.next;
            }

            nextOddNode= nextOddNode.next;
        }

        return head;
    }
}
