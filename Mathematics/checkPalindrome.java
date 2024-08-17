package Mathematics;

import java.util.Scanner;

//  Checking A number is PAllindrome or not.
// Example 989 reverse 989 (989==989) pallindrome
// 678 reverse 876 (678 !=876)not pallindrome
public class checkPalindrome {
    
   public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter A Number To Check Pallindrome");
        int N = sc.nextInt();
         if(check(N)){
            System.out.println("It is a PALLINDROME");
         }
         else{
            System.out.println("It is not a Pallindrome");
         }
    }

    static boolean check(int num){
        int reversedNum =0;
        int temp =num;
        if(num < 10) return true;
        while (temp>0) {
            reversedNum = reversedNum *10 + temp%10;
            temp/=10;
        }

        return (reversedNum == num);
    }
}