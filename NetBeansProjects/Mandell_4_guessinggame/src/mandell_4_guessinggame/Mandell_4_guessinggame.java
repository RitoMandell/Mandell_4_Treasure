/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandell_4_guessinggame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mmandell
 */
public class Mandell_4_guessinggame {

    /**
     * @param args the command line arguments
     */
    static String username;
    static int userguess;
    static int magicnumber;
    static Random rand;
    static String usernames;
    static Random randy = new Random();
    static boolean playagain;
    static int guessesleft = 7;

    public static void main(String[] args) {
        // the statics are shared with the entire program!
        playagain = true;
        magicnumber = randy.nextInt(100);
        System.out.println("Hello, I would like to play a game with you. What's your name?");
        Scanner userinputname = new Scanner(System.in);
        username = userinputname.nextLine();
        System.out.println("Hello " + username);
        while (playagain) {
            playthegame();
        }
    }

static void playthegame (){
Scanner userinputnumber = new Scanner (System.in);
System.out.println("Please pick a number between 1 and 100");
userguess = userinputnumber.nextInt();
guessesleft --;
if (guessesleft == 6){
System.out.println("Six gusses guess!");
}else if (guessesleft == 5){
System.out.println("Five gusses left!");
}else if (guessesleft == 4){
    System.out.println("Four guesses left!");
}else if (guessesleft == 3){
    System.out.println ("Three guesses left");
}else if (guessesleft == 2){
System.out.println ("Only 2 guesses left!");
}else if (guessesleft == 1){
    System.out.println("ONE GUESS LEFT, MAKE IT COUNT!");
}else if (guessesleft == 0){
    System.out.println ("sorry game over!");
    playagain = false;}
if (magicnumber == userguess){
System.out.println (" You win, let's play again!");
playagain = false;

}else if (magicnumber > userguess){
System.out.println ( "Sorry too low!");
} else {
System.out.println("Nope Too high!");
}
}
}
//needs a bit of work, but cool first game!     
