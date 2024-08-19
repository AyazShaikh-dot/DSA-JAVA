package Hashing;
import java.util.*;
public class SubArrayWithZeroSum {

    public static void main(String[] args) {
        int arr[] ={-3,4,-8,8,9,2};
        boolean ans = naiveSolution(arr);
        System.out.println(ans);

        boolean ans2 = efficientSoltion(arr);
        System.out.println(ans2);
    }

    //  Efficient Solution 
    // Using Prefix sum Technique for sum
    // And USing Hashing to check previous sum in O(1)

    static boolean efficientSoltion(int arr[]){
        HashSet<Integer> hs = new HashSet<>(arr.length);

        int prefixSum =arr[0];
        for(int i=1;i<arr.length;i++){
            // Edge case if prifix sum itself zero;
            
            if(prefixSum==0) return true;
            prefixSum+=arr[i];
           
            if(hs.contains(prefixSum)) return true;
            hs.add(prefixSum);
        }
        if(prefixSum==0) return true;
        return false;
    }

    // Naive Solution  O(n^2)
    static boolean naiveSolution(int[] arr){

        for(int i=0;i<arr.length;i++){
            int sum=arr[i];
            if(sum==0) return true;
            for(int j=i+1;j<arr.length;j++){
                sum+=arr[j];
                if(sum ==0) return true;
            }
        }
        return false;
    }
}