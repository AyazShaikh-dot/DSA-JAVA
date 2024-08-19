package Hashing;
import java.util.*;
public class TestHashSet {
    public static void main(String[] args) {
    // Hashset doesn,t Promise of the values it contains
    // Methods provise by the hashset
    // add() O(1) remove() O(1) contains() O(1) size() O(1) isEmpty() O(1) clear()
        HashSet<String> hs = new HashSet<>();
        hs.add("ayaz");
        hs.add("shaikh");
        hs.add("BCA");
        hs.add("29-11-2001");

        System.out.println(hs);

        hs.remove("shaikh");

        System.out.println(hs);

        System.out.println(hs.contains("ayaz"));

        // Iteraton over HashSet
        //  hs.iterator();
        // Returns an iterator over the elements in this set. The elements are returned in no particular order.
        Iterator<String> i = hs.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

        // Anothe way of traversing HAshset
        for(String s : hs){
            System.out.println(s);
        }
    }
}
