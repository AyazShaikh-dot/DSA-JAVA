package Mathematics;
import java.util.Scanner;
public class factorial {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter A Number To Check Pallindrome");
        int N = sc.nextInt();

        int ans1 = factorialUsingLoop(N);
        int ans2 = factorialRecursion(N);
      
        System.out.println("Factorial of" +N + " is " + ans1);
      
        System.out.println("Factorial of" +N + " is " + ans2);

       
}

//  Get Factorial of number using loop
//  Time complexity O(N) Space Complexity O(1)

static int factorialUsingLoop(int n){
 int res=1;

    for(int i=1;i<=n;i++){
        res= res*i;
    }
    return res;
}

//  Get Factorial using Recursion

static int factorialRecursion(int n){
    if(n==0) return 1;

    return n * factorialRecursion(n-1);
}

}