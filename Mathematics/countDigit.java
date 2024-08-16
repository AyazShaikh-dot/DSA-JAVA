
package Mathematics;

import java.util.Scanner;

/**
 * countDigit
 */
public class countDigit {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter A Number");
        int N = sc.nextInt();
         System.out.println("Number of Digits in" + N +" " + " is "+countDigits(N));
    }
    static int countDigits(int N){
        int res =0;
        while ( N!=0){
            res++;
            N=N/10;
        }
        return res;
    }
}

