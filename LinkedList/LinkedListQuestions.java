package LinkedList;
import java.util.*;

public class LinkedListQuestions {
    
    public static void main(String[] args) {
              
        Node head = new Node(10);

        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);


        // head = insertInSortedLinkedList(head, 34);


        // System.out.println(middleOfLinkedList(head));

        // System.out.println(slowAndFastPointer(head));

        // System.out.println(NthNodeFromLast(head, 6));
        // System.out.println(effecientSolutionOfNthNodeFromLast(head, 6));

        // naiveReverse(head);

        // head = effecientlyReverseLinkedList(head);

        // head = recursiveReverseMethod1(head);

        // head = removeDup(head);

        head = reverseInGroup(head, 3);

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
}
