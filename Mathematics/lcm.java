package Mathematics;
import java.util.Scanner;

public class lcm extends euclideanAlgo{
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter A Numbers to check LCM");
         int a = sc.nextInt();
         int b = sc.nextInt();
         sc.close();
         
         int ans = leastCommonFactor(a, b);
         int ans1=usingGcd(a, b);
         System.out.println(ans);
         System.out.println(ans1);
       
    }

    // Solution USing loop
    static int leastCommonFactor(int a , int b){
        int res = Math.max(a, b);
        while(true){
            if(res%a==0 && res%b==0)
            break;
            res++;
        }
        return res;
    }

    // solution using gcd
    static int usingGcd(int a, int b){
        int gcd= lcm.eucAlgo(a, b);

        return a*b/gcd;
    }
}
