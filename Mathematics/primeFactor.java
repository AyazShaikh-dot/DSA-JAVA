
package Mathematics;

public class primeFactor extends checkForPrime {

    public static void main(String[] args) {
        printPrimefacor(315);
        System.out.println();
        efficientSoltionPrint(315);
    }


    // NAive Solution

    static void printPrimefacor(int n){
        for(int i=2;i<=n;i++){
            if(primeFactor.checkPrime(i)){
                while (n%i ==0) {
                    System.out.print(i +" ");
                    n= n/i;
                }
            }
        }
    }

    static void efficientSoltionPrint(int n){
        while(n%2==0){
            System.out.print(2+" ");
            n=n/2;
        }
        while(n%3==0){
            System.out.print(3+" ");
            n=n/3;
        }

        for(int i=5;i*i<=n;i+=6){
            if(n%i==0 ){
            System.out.print(i+" ");
            n=n/i;
            }
            if(n%(i+2)==0){
            System.out.print(i+2 +" ");
            n=n/i;
            }         
        }
        if(n>3){
            System.out.print(n+" ");
        }
    }
}