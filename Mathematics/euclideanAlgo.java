package Mathematics;

import java.util.Scanner;

public class euclideanAlgo {
 
    public static void main(String[] args) {
          Scanner sc= new Scanner(System.in);
          System.out.println("Enter A Numbers to check GCD");
           int a = sc.nextInt();
           int b = sc.nextInt();

        //    int ans = gcd(a,b);

        int ans2= eucAlgoRecursion(a, b);
           System.out.println(ans2);
    }

    // Euclidean Algorithm using Loop
   public static int eucAlgo(int a, int b){

        while (a!=b) {
            if(a>b)
            a=a-b;
            else
            b=b-a;
        }
        return a;
    }

     // Euclidean Algorithm using Recursion
     static int eucAlgoRecursion(int a , int b){
        if(b==0)
        return a;

        return eucAlgoRecursion(b,a%b);
     }

    // Find GCD (Greatest Common Divisor) of two number 
    // Time Complexity O(min(a,b))
    static int gcd(int a, int b){

        int res = Math.min(a,b);
        while (a%res!=0 && b%res!=0) {
            res--;
        }
        return res;
    }
}
