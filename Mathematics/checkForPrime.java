package Mathematics;

import java.util.Scanner;

public class checkForPrime {
    
       public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter A Numbers to check Prime or not");
         int a = sc.nextInt();

         boolean ans1=checkPrime(a);
         boolean ans2=efficientSoltion(a);
         boolean ans3=bestSol(a);
         
         System.out.println(ans1);
         System.out.println(ans2);
         System.out.println(ans3);
       
    }

    // Naive solution
    public static boolean checkPrime(int n){
        for(int i=2;i<n;i++){
            if(n%i==0)
            return false;
        }
        return true;
    }

    // Efficient Solution
    static boolean efficientSoltion(int n){

        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }

        return true;
    }

    // Best Solution
    public static boolean bestSol(int n){
        if(n%2==0 || n%3==0) return false;

        for(int i=5;i*i<=n;i+=6){
            if(n%i==0 || n%(i+2)==0)
            return false;
        }
        return true;
    }
}
