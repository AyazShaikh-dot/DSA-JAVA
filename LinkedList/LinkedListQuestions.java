package LinkedList;
import java.util.*;

 class NodeWithRandom{
    int data;
    NodeWithRandom next;
    NodeWithRandom random;

    NodeWithRandom(int x){
        data =x;
    }
}
public class LinkedListQuestions {
    
    public static void main(String[] args) {
              
        Node head = new Node(10);

        // head.next=head;
        head.next = new Node(90);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(8);
        // head.next.next.next.next.next.next = new Node(9);

   

        // head.next.next.next.next.next.next.next = head;

        // Node head2 = new Node(1010);
        // head2.next = new Node( 909);
        // head2.next.next=head.next.next.next;



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

        // head = segregateOddEven(head);

        // head = effecientSegregateOddEven(head);p

        // System.out.println(naiveIntersectionPoint(head, head2));

        // System.out.println(effecientIntersectionPoint(head, head2));

        // myPairWiseSwap(head);

        //  head= effecientPairWiseSwap(head);

        // traverseLinkedList(head);

        NodeWithRandom headWithRandom = new NodeWithRandom(900);
        headWithRandom.next = new NodeWithRandom(901);
        headWithRandom.next.next = new NodeWithRandom(902);
        headWithRandom.next.next.next = new NodeWithRandom(903);
        headWithRandom.next.next.next.next = new NodeWithRandom(905);

        headWithRandom.random = headWithRandom.next.next;
        headWithRandom.next.random = headWithRandom;
        headWithRandom.next.next.random = headWithRandom;
        headWithRandom.next.next.next.random = headWithRandom.next.next.next.next;
        headWithRandom.next.next.next.next.random=headWithRandom.next;

        NodeWithRandom copyHead = naiveClone(headWithRandom);

        copyHead.next.data =700;

        System.out.println(headWithRandom.next.next.next.random.data);
        traverseRandom(headWithRandom);
        traverseRandom(copyHead);

      

      
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
    // My Solution but does not maintainn the order of linkedlist
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

    // Anothe naive approach 
    // public static Node segregateEvenOddTwo(Node head){

    //     Node lastNode =head;
      

    //     while (lastNode.next !=null) {
    //         lastNode= lastNode.next;
    //     }
    //     Node firstLastNode =lastNode;
    //     Node startingNode = head;
    //     boolean firstOddNode = true;

    //     while (startingNode != firstLastNode) {
    //         if(startingNode.data%2!=0){
    //             lastNode.next = startingNode;
    //             lastNode = lastNode.next;
    //         }
    //         if(startingNode.data%2==0 && firstOddNode){
    //             head = startingNode;
    //             firstOddNode = false;
    //         }

    //         startingNode = startingNode.next;
    //     }

    //     return head;

    // }

    //Effecient Solution
    
    public static Node effecientSegregateOddEven( Node head){

        Node evenStart = null;
        Node evenEnd = null;

        Node oddStart = null;
        Node oddEnd = null;

        Node curr = head;
        
        while (curr != null) {
            
            if(curr.data%2 == 0){
                if(evenStart==null){
                    evenStart=evenEnd=curr;
                }
                else{
                    evenEnd.next= curr;
                    evenEnd=evenEnd.next;
                }
            }
            else{
                if(oddEnd==null){
                    oddStart = curr;
                    oddEnd = curr;
                }
                else{
                    oddEnd.next= curr;
                    oddEnd=oddEnd.next;
                }
            }

            curr= curr.next;
        }

        if(evenStart == null || oddStart == null){
            return head;
        }

        evenEnd.next = oddStart;
        oddEnd.next = null;

        return evenStart;
    }

    //  Intersection Point Naive Solution Space Complexity O(N||M) Time Complexity O(N + M)

    public static int naiveIntersectionPoint(Node head1, Node head2){

    
        Node curr1 = head1;
        Node curr2 = head2;

        HashSet <Node> hs = new HashSet<>();

        while (curr1!=null) {
            hs.add(curr1);
            curr1=curr1.next;
        }

        while (curr2!=null) {
            if(hs.contains(curr2)){
                return curr2.data;
            }
            curr2=curr2.next;
        }
        return -1;
    }

    // Effecient Solution 
    public static int effecientIntersectionPoint(Node head1 , Node head2){
        int c1=0;
        int c2=0;

        for(Node curr= head1; curr!=null; curr=curr.next){
            c1++;
        }
        for(Node curr= head2; curr!=null; curr=curr.next){
            c2++;
        }

        // System.out.println(c1 +" " + c2);

        int absoluteValue = Math.abs(c1-c2);

        if(c1>=c2){
            Node curr1 = head1;
            while (absoluteValue>0) {
                curr1= curr1.next;
                absoluteValue--;
            }
            System.out.println(curr1.data);
           
            Node curr2 = head2;

            while (curr1!=null && curr2!=null) {
                if(curr1==curr2)
                return curr1.data;

                curr1= curr1.next;
                curr2= curr2.next;
            }
        }
        else{
            Node curr2 = head2;
            while (absoluteValue>0) {
                curr2= curr2.next;
                absoluteValue--;
            }
            Node curr1 = head1;

            while (curr2!=null && curr1!=null) {
                if(curr1==curr2)
                return curr1.data;

                curr1= curr1.next;
                curr2= curr2.next;
            }
        }

        return -1;
    }

    //  Swap Pairwise My Approach 

    public static void myPairWiseSwap(Node head){
        if(head == null || head.next == null){
            return;
        }

      Node curr =head;

        while (curr!=null && curr.next!=null) {
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data =temp;

            curr= curr.next.next;
        }
    }

    // Above Solution is not Good as because in real world we have objects stores in linked list and swapping is not a good idea;

    public static Node effecientPairWiseSwap(Node head){

        if(head == null || head.next == null){
            return head;
        }

       Node curr = head.next.next;
       Node prev = head;
       head= head.next;
       head.next = prev;

        
        while (curr!=null && curr.next!=null) {
            // swap logic
            prev.next = curr.next;
            prev = curr;
            Node next = curr.next.next;
            curr.next.next = curr;
            curr= next;
        }

        prev.next = curr;

        return head;
    }

    // Clone a Linked list With Random Pointer

    // traversal 

    public static void traverseRandom(NodeWithRandom head){
        NodeWithRandom curr = head;
        while (curr!=null) {
            System.out.println(curr.data);

            curr = curr.next;
        }
    }
    public static NodeWithRandom naiveClone(NodeWithRandom head){
        NodeWithRandom head2 =new NodeWithRandom(head.data);

        NodeWithRandom currHead2= head2;

        NodeWithRandom currHead = head.next;
        while (currHead!=null) {
            currHead2.next = new NodeWithRandom(currHead.data);

            currHead= currHead.next;
            currHead2= currHead2.next;
        }

        return head2;
    }
}
