package mandell_4_textbasedgame.java;

import java.util.Scanner;

/**
 *
 * @author mmandell
 */
public class Mandell_4_TextBasedGameJava {

    static String userinput; //used to help create: answerphrase.nextLine();
    static boolean play; //reason why the while loop will keep running
    static boolean inputphrase; //allows the user to put in their answer 
    static boolean TheKey; //require for one of the win clauses

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Let the game begin!");
        Scanner answerphrase = new Scanner(System.in);
        userinput = answerphrase.nextLine();
        while (play = true) { //this runs the game, as long as play = true then the game will continue 

           start();
        }

    }
    
    
    
private static void start(){ //first options
    
     System.out.println("You walk outside on a fine morning, as you go to grab your newspaper a rock is thrown at your head you: nothing or duck");
            Scanner aanswerphrase = new Scanner(System.in);
            String sanswerphrase = aanswerphrase.nextLine(); //this is the player's choices and character #hero
            if (sanswerphrase.contains("nothing")) {
                System.out.println("You do nothing and get hit by the rock, you got knocked out. Game Over!");

                play = false; //#lose / #fortheloss

            } else if (sanswerphrase.contains("duck")) {
                System.out.println("You duck, and then dodge the rock, you see who threw the rock, you run: away or after");
                nextstep();
            }

            
}
private static void nextstep(){ //next set of options
     Scanner aanswerphrase = new Scanner(System.in);
            String sanswerphrase = aanswerphrase.nextLine(); //this is the player's choices and character #hero
    if (sanswerphrase.contains("away")) {
                System.out.println("You run away from the guy, but now a group of shady looking guys has surrounded you, you: surrender or fight");
            } else if (sanswerphrase.contains("after")) {
                System.out.println("you run after the guy and catch up to him, he throws a punch you: dodge or hit");
            }
            if (sanswerphrase.contains("surrender")) {
                System.out.println("you surrender to the group of guys, they put a bag over your head and you wake up tied up in ropes in an evil lair you: struggle or stay");
            } else if (sanswerphrase.contains("fight")) {
                System.out.println("you try and fight the group of guys but you lose miserably, you black out. Game over");
                play = false; //#lose/ #fortheloss
            }
}
             private static void nextstep2(){ //third set of options
                  Scanner aanswerphrase = new Scanner(System.in);
            String sanswerphrase = aanswerphrase.nextLine(); //this is the player's choices and character #hero
            if (sanswerphrase.contains("hit")) {
                System.out.println("You try and hit the guy first, you fail though and he hits you. You get knocked out, game over!");
                play = false; //#win1 / #forthewin1
            }
            if (sanswerphrase.contains("dodge")) {
                System.out.println("You dodge the guy's punch, you then: punch or kick");
            }

            }
             
             
    private static void nextstep3(){ //fourth set of options
          Scanner aanswerphrase = new Scanner(System.in);
            String sanswerphrase = aanswerphrase.nextLine(); //this is the player's choices and character #hero
            if (sanswerphrase.contains("struggle")) {
                System.out.println("You struggle against the ropes and eventually you get out of the ropes. You hear the men coming back you: run or hide");
            } else if (sanswerphrase.contains("stay")) {
                System.out.println("You stay in the ropes, and the shady men come to interogate you. They ask you a bunch of questions, you: answer or don't");
            }
    }
    
    
            private static void nextstep4(){ //fifth set of options
                  Scanner aanswerphrase = new Scanner(System.in);
            String sanswerphrase = aanswerphrase.nextLine(); //this is the player's choices and character #hero
            if (sanswerphrase.contains("run")) {
                System.out.println("You run away but then there is a fork in the lair, you go: left, or right ");
            } else if (sanswerphrase.contains("hide")) {
                System.out.println("You hide as a group of shady guys pass by, you notice one of them drop a key you: grab or run");
            }
            if (sanswerphrase.contains("answer")) {
                System.out.println("You answer all their question, and they see no reason to keep you alive. They shoot you, game over!");
                play = false; //#lose / #fortheloss
            } else if (sanswerphrase.contains("don't")) {
                System.out.println("You don't answer any question and they begin to threaten you, you: answer or still don't");
            }
            }
            private static void nextstep5(){ //sixth set of options
                      Scanner aanswerphrase = new Scanner(System.in);
            String sanswerphrase = aanswerphrase.nextLine(); //this is the player's choices and character #hero

            if (sanswerphrase.contains("punch")) {
                System.out.println("You punch the man, he gets knocked out and you enjoy rest of your day in peace. You win, one of three possible endings!");
                play = false;
            } else if (sanswerphrase.contains("kick")) {
                System.out.println("You try and kick the man, but he catches your leg and you fall back hitting your head on the ground. You black out, game over");
            }
            }
            private static void nextstep6(){ //seventh set of options
                  Scanner aanswerphrase = new Scanner(System.in);
            String sanswerphrase = aanswerphrase.nextLine(); //this is the player's choices and character #hero

            if (sanswerphrase.contains("grab")) {
                System.out.println("You grab the key, it looks like it may be important");
                TheKey = true;
            } else if (sanswerphrase.contains("run")) {
                System.out.println("You don't pick up the key and you run, you are faced with a fork in the path you can either go: right or left");
            }
            if (sanswerphrase.contains("left")) {
                System.out.println("You go left, but there is a door that is locked you: go back or use key");
            } else if (sanswerphrase.contains("right")) {
                System.out.println("You go right, but you end up running into a run full of guys, they instantly knock you out, game over!");
                play = false; //#lose / #fortheloss
            }
            }
            
            
            private static void nextstep7(){ //eighth set of options
                 Scanner aanswerphrase = new Scanner(System.in);
            String sanswerphrase = aanswerphrase.nextLine(); //this is the player's choices and character #hero
  
            if (sanswerphrase.contains("still don't")) {
                System.out.println("You still don't answer their questions, and they respect you for that. They offer you a job, you: accept or decline");
            } else if (sanswerphrase.contains("answer")) {
                System.out.println("Fearing for your life you answer their questions, seeing as you no longer have any use to them they shoot you, game over!");
                play = false; //#lose / #fortheloss
            }
            if (TheKey = true & sanswerphrase.contains("use key")) {
                System.out.println("You use the key and you get out, you enjoy rest of your day. You win, 1 of 3 possible wins!");
                play = false; //#win2 / #forthewin2
            } else if (sanswerphrase.contains("go back")) {
                System.out.println("You go back but you get back by the villians, you lose!");
                play = false; //#lose / #fortheloss
            }
            if (sanswerphrase.contains("accept")) {
                System.out.println("You accept their job offer and you join the crime organization. You eventually end up ruling the world with an iron fist. You win! 1 of 3 possible win conditions");
                play = false; //#win / #forthewin3
            } else if (sanswerphrase.contains("decline")) {
                System.out.println("You decline the offer, but they can't let you go, you spend rest of your life in their lair. Game over!");
                play = false; //#lose / #fortheloss
}
    }
}
            


// This is my text based game, a few bugs but it is getting finished soonTM 
