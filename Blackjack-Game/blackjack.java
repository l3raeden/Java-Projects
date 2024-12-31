//imports basic tools including scanner
import java.util.*;

public class blackjack{


    public static void main(String [] args){

        //initializes scanner
        Scanner in = new Scanner(System.in);



        boolean endgame = false;
        

        //starts while loop
        while(endgame == false){

            System.out.println("***Welcome to Blackjack***\n-------------------------");

            int dealerscore = 0;
            int playerscore = 0;

            //dealer draws cards
            dealerscore += (int)(Math.random() * 10) + 1;
            System.out.println("\nDealer drew a " + dealerscore + " and a mystery card");
            

            //player draws cards
            playerscore += (int)(Math.random() * 10) + 1;
            playerscore += (int)(Math.random() * 10) + 1;
            System.out.println("\nYour current score is: " + playerscore);

            System.out.println("\nDealer current score: " + dealerscore + " and a face down card");


            
            System.out.println("***Your turn to draw***");
            int playerchoice = 1;
            while(playerchoice == 1){

                System.out.println("Press [1] to hit - Press [2] to stand");
                playerchoice = in.nextInt();

                if(playerchoice == 1){
                    playerscore += (int)(Math.random() * 10) + 1;
                    System.out.println("Your new score is: " + playerscore);
                }
                if(playerscore > 21){
                    break;
                }
            }

            System.out.println("\n***Dealers turn to draw***");

            if(dealerscore < 17){

                System.out.println("\n*Dealer must draw");

                while(dealerscore < 17){
                    dealerscore += (int)(Math.random() * 10) + 1;

                }

                System.out.println("Dealer new score: " + dealerscore);
            }
            System.out.println("Player current score: " + playerscore);

            //checks endgame scores
            if(dealerscore > 21){
                System.out.println("***YOU WIN***");
            }else if(playerscore > 21){
                System.out.println("***DEALER WINS***");
            }else if((dealerscore > playerscore) && (dealerscore <= 21)){
                System.out.println("***DEALER WINS***");
            }else if((playerscore > dealerscore) && (playerscore <= 21)){
                System.out.println("***YOU WIN***");
            }

            int choice;

            System.out.println("\nWould you like to play again? [1] yes - [2] no");
            choice = in.nextInt();

            if(choice == 2){
                endgame = true;
            }

            //add dealer has to draw after

        }

        


        
    }
}