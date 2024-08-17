package Mathematics;
import java.util.Scanner;;
public class traillingZeroInFactorial {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter A Number");
        int N = sc.nextInt();
        int ans = traillingZeroes(N);
         System.out.println("Trailling zeroes in Factorial of " + N +" " + " is "+ans);
    }

    //  Getting Trailling zeroes in factorial 
   
    // Example 5! = 120 Only 1 Trailling Zero , so Answer is 1
    // Naive solution we can think of that is first find factorial of a number
    // than count the number of trailling zeroes. This might work but is smaller factorial number
    // what we can do in case of very large numbers. How we can store such a huge number in variable
    // Fact of 15 is => 1307674368000. 


    // Solution
    // The number of trailing zeros in n! is determined by the number of times 5 appears as a factor in the numbers from 1 to 𝑛

    // Number of trailing zeros=⌊n/5] + [n/25] + [n/125]......


    static int traillingZeroes(int n){
        int res =0;
        for(int i =5 ;i<=n;i=i*5){
            res+= n/i;
        }
        return res;
    }
}
