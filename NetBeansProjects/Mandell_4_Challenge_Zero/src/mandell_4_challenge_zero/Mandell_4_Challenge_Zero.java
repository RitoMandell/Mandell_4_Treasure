/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandell_4_challenge_zero;

/**
 *
 * @author mmandell
 */
public class Mandell_4_Challenge_Zero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i = 0; i <   500; i++){
            if (isDivisbleby2 (i) & isDivisbleby3 (i) & isDivisbleby5 (i)){
                            System.out.println("Team building" );
                                    }
            else if (isFiftyfive (i)){
                        System.out.println(" Animate This" );
            }
            else if (isDivisbleby5 (i)){
                             System.out.println(" Vidal" );
                        }
             else if (isTwentytwo (i)){
                         System.out.println(" Ninja" );
             }
                    else if (isDivisbleby3 (i)){
                        System.out.println(" Cluaghton" );
                    }
                    else if (isDivisbleby3 (i) & isDivisbleby5 (i)){
                    System.out.println( " Old school" );
                         
                    else if (isDivisbleby2 (i) & isDivisbleby3 (i)){
                            System.out.println(" Chisme" );
                                }
            else if (isDivisbleby2 (i)){
                    System.out.println(" Davis" );
             }
                   
             }
                    
                            
                                           
                    }
            
        
   

}

static boolean isDivisbleby2 (int i){
    return (i % 2 == 0);    
}
static boolean isTwentytwo (int i){
    return (i == 22);
}
static boolean isDivisbleby3 (int c){
    return (c % 3 == 0);
}
static boolean isThirtythree (int i){
    return (i == 33);
}
static boolean isDivisbleby5 (int v){
    return (v % 5 == 0);
}
static boolean isFiftyfive (int i){
    return (i == 55);
}
}


// this is challenge zero  
// I need to work on this more! 