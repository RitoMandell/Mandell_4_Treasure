/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandell_4_prime_methods;

/**
 *
 * @author mmandell
 */
public class Mandell_4_prime_methods {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            if(isPrime (i)){
                if (isEven (i)){
                System.out.println(i+ " is prime");
            }
    }
    
}
/*
    method- a little program
    it can recieve and return values to other methods
    */
    }
    static boolean isOdd (int n){
        return (n % 2 == 1);
    }
    static boolean isEven (int m){ 
        return (m % 2 == 0);
    }
    static boolean isPrime (int x){
        int divisor = 0;
        for(int i = 2; i < x ;i++)
        if (x % i  == 0);
           divisor += 1;
    }
}
    if(divisor > 0){
        return false;
} else {
    return true;
}
}
}
    
//
